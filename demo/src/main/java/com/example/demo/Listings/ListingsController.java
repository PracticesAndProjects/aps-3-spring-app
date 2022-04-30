package com.example.demo.Listings;

import com.example.demo.DTOs.ListingsDTO;
import com.example.demo.DTOs.OrderDTO;
import com.example.demo.DbEntities.Listagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user/listings")
public class ListingsController {

	private final ListingsService listingsService;

	@Autowired
	public ListingsController(ListingsService listingsService){
		this.listingsService = listingsService;
	}

	@PostMapping(path = "add")
	public void addListings(HttpServletResponse response,
	                        @RequestBody Listagem listingObj,
	                        @CookieValue(value = "token", defaultValue = "undefined") String authString){
		listingsService.addNewListings(response, listingObj, authString);
	}

	@DeleteMapping(path = "delete/{listingId}")
	public void removeListings(HttpServletResponse response,
	                           @PathVariable("listingId") Long listingId,
	                           @CookieValue(value = "token", defaultValue = "undefined") String authString){
		listingsService.removeListings(response,
				listingId,
				authString);
	}

	@GetMapping
	public List<ListingsDTO> getListings(HttpServletResponse response,
	                                     @CookieValue(value = "token", defaultValue = "undefined") String authString){
		return listingsService.getListings(response, authString);
	}

	@PostMapping(path = "order/create")
	public void orderList(HttpServletResponse response,
	                      @CookieValue(value = "token", defaultValue = "undefined") String authString,
	                      @RequestParam(name = "listingid") Long id){
		listingsService.createOrder(response, authString, id);
	}

	@GetMapping(path = "order")
	public List<OrderDTO> getOrders(HttpServletResponse response,
	                                @CookieValue(value = "token", defaultValue = "undefined") String authString){
		return listingsService.getMyOrders(response, authString);
	}

	//https://stackoverflow.com/questions/21456494/spring-jpa-query-with-like
	//Spring JPA search query
}