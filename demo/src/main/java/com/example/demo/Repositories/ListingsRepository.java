package com.example.demo.Repositories;

import com.example.demo.DTOs.ListingsDTO;
import com.example.demo.DbEntities.Listagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ListingsRepository extends JpaRepository<Listagem, Long> {

//	@Query("SELECT s FROM Listagem s WHERE s.usuario_id = ?1")
//	List<Listagem> getListingByUserId(Long id);

	@Query("SELECT new com.example.demo.DTOs.ListingsDTO" +
			"(s.titulo, " +
			"s.img_url, " +
			"s.material_type, " +
			"s.delivery_type, " +
			"s.product_price, " +
			"s.delivery_median_price, " +
			"s.volume_dimension, " +
			"s.weight_dimension, " +
			"s.usuario.id, " +
			"s.id, " +
			"s.usuario.nome) " +
			"FROM Listagem s WHERE s.usuario.id = ?1")
	List<ListingsDTO> findByusuario_id(Long id);

	@Query("SELECT new com.example.demo.DTOs.ListingsDTO" +
				"(s.titulo, " +
				"s.img_url, " +
				"s.material_type, " +
				"s.delivery_type, " +
				"s.product_price, " +
				"s.delivery_median_price, " +
				"s.volume_dimension, " +
				"s.weight_dimension, " +
				"s.usuario.id, " +
				"s.id, " +
				"s.usuario.nome) " +
				"FROM Listagem s WHERE UPPER(s.titulo)" +
				"LIKE CONCAT('%',UPPER(:searchparam),'%')")
	List<ListingsDTO> findBySearchParam(@Param("searchparam") String searchParam);


	@Query("SELECT s FROM Listagem s WHERE s.id = ?1")
	Optional<Listagem> findById(Long id);
}
