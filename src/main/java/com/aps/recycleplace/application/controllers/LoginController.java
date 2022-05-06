package com.aps.recycleplace.application.controllers;

import com.aps.recycleplace.domain.entities.Usuario;
import com.aps.recycleplace.implementation.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/v1/user/auth", produces = "application/json")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping(path = "/signin")
	public String loginPostMapping(HttpServletResponse response,
			@CookieValue(value = "auth", defaultValue = "undefined") String authString,
			@RequestBody Usuario usuario) {

		if (authString.equals("undefined")) {
			return loginService.doLogin(response, usuario);
		} else {
			response.setStatus(401);
			return null;
		}
	}

}
