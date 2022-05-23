package com.aps.recycleplace.implementation.services;

import com.aps.recycleplace.domain.entities.Usuario;
import com.aps.recycleplace.domain.mapping.UserAuthDTO;
import com.aps.recycleplace.implementation.services.common.TokenGenerator;
import com.aps.recycleplace.infrastructure.persistence.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;
import antlr.Token;
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
	public UserAuthDTO doLogin(HttpServletResponse response, Usuario usuario) {

		Usuario usuariodb = usuarioRepository
				.findUsuarioByEmailandSenha(usuario.getEmail(), usuario.getSenha()).orElse(null);

		if (usuariodb == null) {
			response.setStatus(404);
			return null;
		}
		String newToken = TokenGenerator.generateNewToken();

		usuario.setToken(newToken);
		usuariodb.setToken(newToken);

		// Cookie cookieSignin = new Cookie("token", newToken);
		// cookieSignin.setMaxAge(9999);
		// cookieSignin.setPath("/");
		// response.addCookie(cookieSignin);

		return new UserAuthDTO(usuariodb.getEmail(), usuariodb.getNome(), newToken, usuariodb.getId());
	}

	public void checkAuth(HttpServletResponse response,
			@CookieValue(value = "auth", defaultValue = "undefined") String cookie) {

		Usuario usuariodb = usuarioRepository.findUsuarioByAuth(cookie).orElse(null);

		if (cookie.equals("undefined") | usuariodb == null) {
			response.setStatus(401);
		}
	}
}
