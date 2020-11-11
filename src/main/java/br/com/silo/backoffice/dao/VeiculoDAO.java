package br.com.silo.backoffice.dao;

import br.com.silo.backoffice.domain.Historico;
import br.com.silo.backoffice.domain.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoDAO extends PagingAndSortingRepository<Veiculo, Long> {

    @Query("SELECT v FROM Veiculo v WHERE v.placa_veiculo = ?1")
    Veiculo findByUsername(String placaVeiculo);

    @Query("SELECT v FROM Veiculo v WHERE v.id = ?1")
    Veiculo findByID(long id);

//    @Query(nativeQuery = true, value = "SELECT * FROM veiculo v JOIN empresa e ON v.empresa_id=e.id LEFT JOIN equipamento q ON  v.equipamento_id=q.id WHERE placa_veiculo LIKE concat('%', ?1,'%')")
//    Page<Veiculo> findPaged(String placaVeiculo, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM veiculo v JOIN empresa e ON v.empresa_id=e.id LEFT JOIN equipamento q ON  v.equipamento_id=q.id WHERE placa_veiculo LIKE concat('%', ?1,'%') and v.empresa_id = ?2")
    Page<Veiculo> findPaged(String placaVeiculo, long empresaId, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM veiculo v JOIN empresa e ON v.empresa_id=e.id LEFT JOIN equipamento q ON  v.equipamento_id=q.id WHERE v.empresa_id = ?1")
    List<Veiculo> findGeral(long empresaId);
}
