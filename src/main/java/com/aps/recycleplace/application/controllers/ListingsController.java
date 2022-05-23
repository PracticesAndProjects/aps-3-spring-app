package com.aps.recycleplace.application.controllers;

import com.aps.recycleplace.domain.entities.Listagem;
import com.aps.recycleplace.domain.mapping.OrderDTO;
import com.aps.recycleplace.implementation.services.ListingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/v1/listings")
public class ListingsController {
	@Autowired
	private ListingsService listingsService;

	@PostMapping
	public void addListings(HttpServletResponse response, @Valid @RequestBody Listagem listingObj,
			@RequestHeader(name = "Authorization", required = true) String Bearer) {
		listingsService.addNewListings(response, listingObj, Bearer);
	}

	@GetMapping
	public List<Listagem> getListingsSearch(HttpServletResponse response,
			@RequestHeader(name = "Authorization") String Bearer) {
		return listingsService.getAllListings(response, Bearer);
	}

	@DeleteMapping(path = "/{listingId}")
	public void removeListings(HttpServletResponse response,
			@PathVariable("listingId") Long listingId,
			@RequestHeader(name = "Authorization", required = true) String Bearer) {
		listingsService.removeListings(response, listingId, Bearer);
	}

	@PostMapping(path = "/order/{listingId}")
	public void orderList(HttpServletResponse response,
			@RequestHeader(name = "Authorization", required = true) String Bearer,
			@PathVariable("listingId") Long listingId) {
		listingsService.createOrder(response, Bearer, listingId);
	}

	@GetMapping(path = "/order")
	public List<OrderDTO> getOrders(HttpServletResponse response,
			@RequestHeader(name = "Authorization", required = true) String Bearer) {
		return listingsService.getMyOrders(response, Bearer);
	}

	@DeleteMapping(path = "/order/{orderId}")
	public void deleteOrders(HttpServletResponse response,
			@RequestHeader(name = "Authorization", required = true) String Bearer,
			@PathVariable("orderId") Long orderId) {
		listingsService.removeOrder(response, Bearer, orderId);
	}

	// https://stackoverflow.com/questions/21456494/spring-jpa-query-with-like
	// Spring JPA search query
}
