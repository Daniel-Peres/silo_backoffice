package br.com.silo.backoffice.dao;

import br.com.silo.backoffice.domain.Equipamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipamentoDAO extends PagingAndSortingRepository<Equipamento, Long> {

    @Query("SELECT e FROM Equipamento e WHERE e.cod_equipamento = ?1")
    Equipamento findByUsername(String codEquipamento);

    @Query(nativeQuery = true, value = "SELECT * FROM equipamento eq JOIN empresa e ON eq.empresa_id=e.id WHERE cod_equipamento LIKE concat('%', ?1,'%')")
    Page<Equipamento> findPaged(String codEquipamento, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM equipamento eq JOIN empresa e ON eq.empresa_id=e.id WHERE status_equipamento = 'INATIVO' and empresa_id = ?1")
    List<Equipamento> findDisabled(long empresaId);
}
