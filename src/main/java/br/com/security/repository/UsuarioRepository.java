package br.com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.security.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.nome=(:nome)")
	public Usuario findByUsuarionome(@Param("nome") String nome);

}
