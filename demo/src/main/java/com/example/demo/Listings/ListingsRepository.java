package com.example.demo.Listings;

import com.example.demo.Dashboard.DashboardUserData;
import com.example.demo.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ListingsRepository extends JpaRepository<Listings, Long> {


}
