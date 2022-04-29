package com.example.demo.Listings;

import com.example.demo.usuarios.Usuario;
import com.example.demo.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Service
public class ListingsService {
	private final UsuarioRepository usuarioRepository;
	private final ListingsRepository listingsRepository;

	@Autowired
	public ListingsService(UsuarioRepository usuarioRepository, ListingsRepository listingsRepository) {
		this.usuarioRepository = usuarioRepository;
		this.listingsRepository = listingsRepository;
	}

	public void addNewListings(HttpServletResponse response,
	                           @RequestBody Listings listingObj,
	                           @CookieValue(value = "token", defaultValue = "undefined") String authString){
		Usuario usuariodb = usuarioRepository.findUsuarioByAuth(authString).orElse(null);
		if (usuariodb == null){
			response.setStatus(401);
			return;
		}
		listingObj.setUsuario(usuariodb);
		listingsRepository.save(listingObj);
	}

	public void removeListings(HttpServletResponse response,
	                           Long listingId,
	                           String authString){
		listingsRepository.deleteById(listingId);
	}

}
