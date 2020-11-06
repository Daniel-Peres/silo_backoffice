package br.com.silo.backoffice.dao;

import br.com.silo.backoffice.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends PagingAndSortingRepository<Usuario, Long> { //extends BaseDAO<Usuario> {


    @Query("SELECT u FROM Usuario u WHERE u.nome = ?1")
    Usuario findByUsername(String nome);

//    @Query(nativeQuery = true, value = "SELECT * FROM usuario u JOIN empresa e ON u.empresa_id=e.id WHERE nome LIKE concat('%', ?1,'%')")
//    Page<Usuario> findPaged(String nome, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM usuario u JOIN empresa e ON u.empresa_id=e.id WHERE nome LIKE concat('%', ?1,'%') and empresa_id = ?2")
    Page<Usuario> findPaged(String nome, long empresaId, Pageable pageable);

    //@Query(nativeQuery = true, value = "SELECT * FROM usuario WHERE nome LIKE concat('%', ?1,'%')")
    //Page<Usuario> findPaged(String nome, Pageable pageable);

//    @Query("SELECT u FROM usuario u WHERE lower(u.email) like lower(concat('%', ?1,'%'))")
//    Page<Usuario> findByEmail(String email, Pageable pageable);

}
