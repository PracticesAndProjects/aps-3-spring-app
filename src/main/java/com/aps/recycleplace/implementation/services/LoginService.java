package com.aps.recycleplace.implementation.services;

import com.aps.recycleplace.domain.entities.Usuario;
import com.aps.recycleplace.domain.mapping.UserAuthDTO;
import com.aps.recycleplace.implementation.services.common.TokenGenerator;
import com.aps.recycleplace.infrastructure.persistence.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


		String newToken = TokenGenerator.generateNewToken();

		if (usuariodb == null) {
			return null;
		}

		usuario.setToken(newToken);
		usuariodb.setToken(newToken);

		UserAuthDTO userLogin =
				new UserAuthDTO(usuariodb.getEmail(), usuariodb.getNome(), newToken, usuariodb.getId());
		return userLogin;
	}

	public boolean checkAuth(HttpServletResponse response, String authString) {
		Usuario usuariodb = usuarioRepository.findUsuarioByAuth(authString).orElse(null);

		if (authString.equals("undefined") || usuariodb == null
				|| !authString.equals(usuariodb.getToken())) {
			response.setStatus(401);
			return false;
		}
		return true;
	}
}
