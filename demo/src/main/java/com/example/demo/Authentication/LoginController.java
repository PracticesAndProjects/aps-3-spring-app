package com.example.demo.Authentication;

import com.example.demo.DbEntities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "api/v1/user/signup", produces = "application/json")
public class LoginController {

	private final LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping
	public String loginPostMapping(HttpServletResponse response,
	                      @CookieValue(value = "auth", defaultValue = "undefined") String authString,
	                      @RequestBody Usuario usuario){

		if (authString.equals("undefined")){
			return loginService.doLogin(response, usuario);
		} else {
			response.setStatus(401);
			return null;
		}
	}

}
