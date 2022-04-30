package com.example.demo.Listings;

import com.example.demo.Dashboard.DashboardUserData;
import com.example.demo.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ListingsRepository extends JpaRepository<Listings, Long> {

//	@Query("SELECT s FROM Listings s WHERE s.usuario_id = ?1")
//	List<Listings> getListingByUserId(Long id);

	@Query("SELECT new com.example.demo.Listings.ListingsDTO" +
			"(s.title, " +
			"s.imgUrl, " +
			"s.materialType, " +
			"s.deliveryType, " +
			"s.productPrice, " +
			"s.deliveryMedianPrice, " +
			"s.volumeDimension, " +
			"s.weightDimension, " +
			"s.usuario.id, " +
			"s.id, " +
			"s.usuario.name) " +
			"FROM Listings s WHERE s.usuario.id = ?1")
	List<ListingsDTO> findByusuario_id(Long id);
}
