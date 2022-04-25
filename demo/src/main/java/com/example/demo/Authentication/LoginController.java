package com.example.demo.Authentication;

import com.example.demo.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "login")
public class LoginController {

	private final LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping
	public void retorno(HttpServletResponse response,
	                      @CookieValue(value = "auth", defaultValue = "undefined") String authString,
	                      @RequestBody Usuario usuario){

		if (authString.equals("undefined")){
			loginService.doLogin(response, usuario);
		} else {
			response.setStatus(404);
		}
	}

}
