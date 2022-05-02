package com.example.demo.Repositories;

import com.example.demo.DTOs.OrderDTO;
import com.example.demo.DbEntities.UsuarioOrdem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<UsuarioOrdem, Long> {
	@Query("SELECT new com.example.demo.DTOs.OrderDTO" +
			"(s.isAccepted, s.usuario_ordem.id, s.usuario_ordem.nome, s.usuario_ordem.email, s.listing_ordem.titulo, s.listing_ordem.img_url, s.listing_ordem.material_type, s.listing_ordem.usuario.id, s.listing_ordem.usuario.nome, s.listing_ordem.usuario.email)" +
			" FROM UsuarioOrdem s WHERE s.usuario_ordem.id = ?1")
	Optional<OrderDTO> findOrderByUserId(Long id);

	@Query("SELECT s FROM UsuarioOrdem s WHERE s.usuario_ordem.id = ?1")
	Optional<UsuarioOrdem> findOrderByOwnerId(Long orderParam);
}
