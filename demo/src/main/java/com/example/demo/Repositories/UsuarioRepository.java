package com.example.demo.Repositories;

import com.example.demo.DTOs.UsuarioPublicDTO;
import com.example.demo.Dashboard.DashboardUserData;
import com.example.demo.DbEntities.Usuario;
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

	@Query("SELECT s FROM Usuario s WHERE s.token = ?1")
	Optional<Usuario> findUsuarioByAuth(String token);

	@Query("SELECT new com.example.demo.Dashboard.DashboardUserData(s.nome, s.email, s.data_nasc, s.orcamento_total, s.orcamento_op, s.telefone, s.endereco, s.cpf_cnpj) FROM Usuario s WHERE s.token = ?1")
	Optional<DashboardUserData> findUsuarioByAuthList(String token);

	@Query("SELECT new com.example.demo.DTOs.UsuarioPublicDTO" +
			"(s.nome, s.email, s.telefone, s.id) " +
			"FROM Usuario s WHERE s.id = ?1")
	Optional<UsuarioPublicDTO> findUsuarioPublicById(Long id);
}
