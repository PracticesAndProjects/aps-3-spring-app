package com.example.demo.Listings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
	                        @RequestBody Listings listingObj,
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
}
