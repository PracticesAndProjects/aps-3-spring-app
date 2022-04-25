package com.example.demo.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT s FROM Usuario s WHERE s.email = ?1")
	Optional<Usuario> findUsuarioByEmail(String email);

	@Query("SELECT s FROM Usuario s WHERE s.email = ?1 AND s.senha = ?2")
	Optional<Usuario> findUsuarioByEmailandSenha(String email, String senha);

	@Query("SELECT s FROM Usuario s WHERE s.auth = ?1")
	Optional<Usuario> findUsuarioByAuth(String Auth);


}
