package com.aps.recycleplace.application.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import com.aps.recycleplace.domain.mapping.DashboardUserData;
import com.aps.recycleplace.implementation.services.DashboardService;

@RestController
@RequestMapping(path = "api/v1/dashboard", produces = "application/json")
public class DashboardController {

	private DashboardService dashboardService;

	@Autowired
	public DashboardController(DashboardService dashboardService) {
		this.dashboardService = dashboardService;
	}

	@GetMapping
	public DashboardUserData getUserData(@CookieValue(value = "token", defaultValue = "undefined") String authToken,
			HttpServletResponse response) {
		return dashboardService.getUserData(authToken, response);
	}

}
