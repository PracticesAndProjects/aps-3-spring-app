package com.aps.recycleplace.implementation.services;

import com.aps.recycleplace.domain.entities.Listagem;
import com.aps.recycleplace.domain.entities.Usuario;
import com.aps.recycleplace.domain.entities.UsuarioOrdem;
import com.aps.recycleplace.domain.mapping.OrderDTO;
import com.aps.recycleplace.infrastructure.persistence.repositories.ListingsRepository;
import com.aps.recycleplace.infrastructure.persistence.repositories.OrderRepository;
import com.aps.recycleplace.infrastructure.persistence.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class ListingsService {
	private final UsuarioRepository usuarioRepository;
	private final ListingsRepository listingsRepository;
	private final OrderRepository orderRepository;

	@Autowired
	public ListingsService(UsuarioRepository usuarioRepository, ListingsRepository listingsRepository,
			OrderRepository orderRepository) {
		this.usuarioRepository = usuarioRepository;
		this.listingsRepository = listingsRepository;
		this.orderRepository = orderRepository;
	}

	public void addNewListings(HttpServletResponse response, @RequestBody Listagem listingObj,
			String BearerToken) {
		System.out.println("\nBearerToken\n" + BearerToken + "\n");
		Usuario usuariodb = usuarioRepository.findUsuarioByAuth(BearerToken.split(" ")[1]).orElse(null);
		if (usuariodb == null) {
			response.setStatus(401);
			return;
		}
		listingObj.setUsuario(usuariodb);
		listingsRepository.save(listingObj);
	}

	public void removeListings(HttpServletResponse response, Long listingId, String Bearer) {
		Usuario usuarioDb = usuarioRepository.findUsuarioByAuth(Bearer.split(" ")[1]).orElse(null);
		Listagem listingDb = listingsRepository.findById(listingId).orElse(null);

		if (usuarioDb != null) {
			if (usuarioDb.getId() == listingDb.getUsuario().getId()) {
				try {
					listingsRepository.deleteById(listingId);
				} catch (Exception e) {
					response.setStatus(406);
				}
			}
		}
	}

	public List<Listagem> getAllListings(HttpServletResponse response, String BearerToken) {
		System.out.println("\nBearerToken\n" + BearerToken + "\n");

		Usuario usuarioDb = usuarioRepository.findUsuarioByAuth(BearerToken.split(" ")[1]).orElse(null);
		if (usuarioDb == null) {
			response.setStatus(401);
			return null;
		}

		List<Listagem> searchResult;

		searchResult = listingsRepository.findAll();

		if (searchResult.isEmpty()) {
			response.setStatus(404);

			return null;
		}

		return searchResult;
	}

	public void createOrder(HttpServletResponse response, String Bearer, Long listingId) {
		Usuario usuarioDb = usuarioRepository.findUsuarioByAuth(Bearer.split(" ")[1]).orElse(null);
		Listagem listingDb = listingsRepository.findById(listingId).orElse(null);

		UsuarioOrdem exists =
				orderRepository.findToValidate(usuarioDb.getId(), listingDb.getId()).orElse(null);

		if (exists != null) {
			response.setStatus(409);
			return;
		}
		if (usuarioDb == null || listingDb == null) {
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

	public List<OrderDTO> getMyOrders(HttpServletResponse response, String Bearer) {
		Usuario usuarioDb = usuarioRepository.findUsuarioByAuth(Bearer.split(" ")[1]).orElse(null);
		if (usuarioDb == null) {
			response.setStatus(401);
			return null;
		}

		OrderDTO userOrders = orderRepository.findOrderByUserId(usuarioDb.getId()).orElse(null);
		if (userOrders == null) {
			response.setStatus(404);
			return null;
		}

		return List.of(userOrders);

	}

	public void removeOrder(HttpServletResponse response, String Bearer, Long orderParam) {
		Usuario usuarioDb = usuarioRepository.findUsuarioByAuth(Bearer.split(" ")[1]).orElse(null);
		UsuarioOrdem ordemDb = orderRepository.findOrderByOwnerId(usuarioDb.getId()).orElse(null);

		if (usuarioDb == null || ordemDb == null) {
			response.setStatus(406);
		}
		if (usuarioDb.getId().equals(ordemDb.getUsuario().getId())) {
			orderRepository.deleteById(ordemDb.getId());
		}
	}

}
