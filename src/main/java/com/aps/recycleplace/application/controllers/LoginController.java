package com.aps.recycleplace.application.controllers;

import com.aps.recycleplace.domain.entities.Usuario;
import com.aps.recycleplace.domain.mapping.UserAuthDTO;
import com.aps.recycleplace.implementation.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/v1/auth", produces = "application/json")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping(path = "/signin")
	public UserAuthDTO loginPostMapping(HttpServletResponse response, @RequestBody Usuario usuario) {
		return loginService.doLogin(response, usuario);
	}
}
