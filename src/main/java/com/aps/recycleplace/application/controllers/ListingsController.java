package com.aps.recycleplace.application.controllers;

import com.aps.recycleplace.domain.entities.Listagem;
import com.aps.recycleplace.domain.mapping.ListingsDTO;
import com.aps.recycleplace.domain.mapping.OrderDTO;
import com.aps.recycleplace.implementation.services.ListingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/listings")
public class ListingsController {
	@Autowired
	private ListingsService listingsService;

	@PostMapping
	public void addListings(HttpServletResponse response,
			@Valid @RequestBody Listagem listingObj,
			@CookieValue(value = "token", defaultValue = "undefined") String authString) {
		listingsService.addNewListings(response, listingObj, authString);
	}

	@GetMapping
	public List<ListingsDTO> getListingsSearch(HttpServletResponse response,
			@CookieValue(value = "token", defaultValue = "undefined") String authString,
			@RequestParam(name = "search", required = false) String searchParam) {
		return listingsService.getListingsBySearch(response, authString, searchParam);
	}

	@DeleteMapping(path = "/{listingId}")
	public void removeListings(HttpServletResponse response,
			@PathVariable("listingId") Long listingId,
			@CookieValue(value = "token", defaultValue = "undefined") String authString) {
		listingsService.removeListings(response,
				listingId,
				authString);
	}

	@PostMapping(path = "/order")
	public void orderList(HttpServletResponse response,
			@CookieValue(value = "token", defaultValue = "undefined") String authString,
			@RequestParam(name = "listingid") Long id) {
		listingsService.createOrder(response, authString, id);
	}

	@GetMapping(path = "/order")
	public List<OrderDTO> getOrders(HttpServletResponse response,
			@CookieValue(value = "token", defaultValue = "undefined") String authString) {
		return listingsService.getMyOrders(response, authString);
	}

	@DeleteMapping(path = "/order")
	public void deleteOrders(HttpServletResponse response,
			@CookieValue(value = "token", defaultValue = "undefined") String authString,
			@RequestParam("order") Long orderParam) {
		listingsService.removeOrder(response, authString, orderParam);
	}

	// https://stackoverflow.com/questions/21456494/spring-jpa-query-with-like
	// Spring JPA search query
}
