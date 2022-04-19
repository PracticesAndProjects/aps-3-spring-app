package com.example.demo.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginView {
	@RequestMapping(path = "/login")
	public String LoginPage(){
		return "login.html";
	}
}
