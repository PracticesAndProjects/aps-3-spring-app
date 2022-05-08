package com.aps.recycleplace.implementation.services;

import com.aps.recycleplace.domain.entities.Usuario;
import com.aps.recycleplace.implementation.services.common.TokenGenerator;
import com.aps.recycleplace.infrastructure.persistence.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@Service
public class LoginService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public LoginService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Transactional
	public void doLogin(HttpServletResponse response, Usuario usuario, String authString) {

		Usuario usuariodb = usuarioRepository
				.findUsuarioByEmailandSenha(usuario.getEmail(), usuario.getSenha())
				.orElse(null);

		if (usuariodb == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		if (!authString.equals("undefined") && usuariodb.getToken().equals(authString)){
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}

		String token = TokenGenerator.generateNewToken();
		usuario.setToken(token);
		usuariodb.setToken(token);

		Cookie cookieLogado = new Cookie("token", token);
		cookieLogado.setMaxAge(9999);
		cookieLogado.setHttpOnly(true);
		cookieLogado.setSecure(true);
		response.addCookie(cookieLogado);
		response.setStatus(HttpServletResponse.SC_OK);


	}

	public boolean checkAuth(HttpServletResponse response,
			String authString) {

		Usuario usuariodb = usuarioRepository
				.findUsuarioByAuth(authString)
				.orElse(null);

		if (authString.equals("undefined") || usuariodb == null || !authString.equals(usuariodb.getToken())) {
			response.setStatus(401);
			return false;
		}
		return true;
	}
}
