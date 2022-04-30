package com.example.demo.Listings;

import com.example.demo.DTOs.ListingsDTO;
import com.example.demo.DTOs.OrderDTO;
import com.example.demo.DbEntities.Listagem;
import com.example.demo.DbEntities.UsuarioOrdem;
import com.example.demo.Repositories.ListingsRepository;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.DbEntities.Usuario;
import com.example.demo.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class ListingsService {
	private final UsuarioRepository usuarioRepository;
	private final ListingsRepository listingsRepository;
	private final OrderRepository orderRepository;

	@Autowired
	public ListingsService(UsuarioRepository usuarioRepository, ListingsRepository listingsRepository, OrderRepository orderRepository) {
		this.usuarioRepository = usuarioRepository;
		this.listingsRepository = listingsRepository;
		this.orderRepository = orderRepository;
	}

	public void addNewListings(HttpServletResponse response,
	                           @RequestBody Listagem listingObj,
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

	public List<ListingsDTO> getListings(HttpServletResponse response,
	                                     String authString){
		Usuario usuariodb = usuarioRepository.findUsuarioByAuth(authString).orElse(null);
		if (usuariodb == null){
			response.setStatus(401);
			return null;
		}

		System.out.println("-----------------------");
		List<ListingsDTO> userListings = listingsRepository.findByusuario_id(usuariodb.getId());
//		List<Listagem> userListings = listingsRepository.getListingByUserId(usuariodb.getId());
		if (userListings.isEmpty()){
			response.setStatus(200);
			return null;
		}
		return userListings;

	}

	public void createOrder(HttpServletResponse response,
	                        String authString,
	                        Long id){
		Usuario usuarioDb = usuarioRepository.findUsuarioByAuth(authString)
				.orElse(null);
		Listagem listingDb = listingsRepository.findById(id).orElse(null);
		if (usuarioDb == null || listingDb == null ) {
			System.out.println("-------------------------------------------");
			System.out.println(usuarioDb);
			System.out.println(listingDb);
			response.setStatus(401);
			return;
		}
		UsuarioOrdem usuarioOrdemObj = new UsuarioOrdem();
		usuarioOrdemObj.setUsuario(usuarioDb);
		usuarioOrdemObj.setListing(listingDb);
		orderRepository.save(usuarioOrdemObj);
	}

	public List<OrderDTO> getMyOrders(HttpServletResponse response,
	                                   String authString){
		Usuario usuarioDb = usuarioRepository.findUsuarioByAuth(authString).orElse(null);
		if (usuarioDb == null) {
			response.setStatus(401);
			return null;
		}

		OrderDTO userOrders = orderRepository.findOrderByUserId(usuarioDb.getId()).orElse(null);
		if (userOrders == null){
			response.setStatus(404);
			return null;
		}

		return List.of(userOrders);

	}

}
