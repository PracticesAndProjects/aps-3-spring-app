package com.example.demo.Authentication;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "login")
public class LoginController {

	@PostMapping
	public String retorno(HttpServletResponse response, @CookieValue(value = "logado", defaultValue = "undefined") String logado){

		if (logado.equals("undefined")){

			Cookie cookieLogado = new Cookie("logado", "true");
			cookieLogado.setMaxAge(9999);

			response.addCookie(cookieLogado);

			return "Logado com sucesso";
		}

		return "Usuário já se encontra logado";
	}

}
