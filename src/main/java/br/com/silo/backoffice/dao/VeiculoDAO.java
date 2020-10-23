package br.com.silo.backoffice.dao;

import br.com.silo.backoffice.domain.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoDAO extends PagingAndSortingRepository<Veiculo, Long> {

    @Query("SELECT v FROM Veiculo v WHERE v.placa_veiculo = ?1")
    Veiculo findByUsername(String placaVeiculo);

    @Query(nativeQuery = true, value = "SELECT * FROM veiculo v JOIN empresa e ON v.empresa_id=e.id JOIN equipamento q ON  v.equipamento_id=q.id WHERE placa_veiculo LIKE concat('%', ?1,'%')")
    Page<Veiculo> findPaged(String placaVeiculo, Pageable pageable);
}
