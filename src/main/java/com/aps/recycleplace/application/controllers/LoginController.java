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
	public void loginPostMapping(HttpServletResponse response,
			@CookieValue(value = "token", defaultValue = "undefined") String authString,
			@RequestBody Usuario usuario) {
		loginService.doLogin(response, usuario, authString);
	}

}
