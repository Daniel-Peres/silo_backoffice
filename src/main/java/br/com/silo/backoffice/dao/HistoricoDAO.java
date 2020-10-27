package br.com.silo.backoffice.dao;

import br.com.silo.backoffice.domain.Historico;
import br.com.silo.backoffice.domain.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface HistoricoDAO extends PagingAndSortingRepository<Historico, Long> {
    @Query(nativeQuery = true, value = "SELECT h FROM historico h WHERE h.datahora = ?1")
    Historico findByDate(String datahora);

    @Query(nativeQuery = true, value = "SELECT * FROM historico h JOIN veiculo v ON h.veiculo_id=v.id WHERE datahora LIKE concat('%', ?1,'%')")
    Page<Historico> findPaged(String datahora, Pageable pageable);
}
