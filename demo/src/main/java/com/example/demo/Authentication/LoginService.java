package com.example.demo.Authentication;

import com.example.demo.usuarios.Usuario;
import com.example.demo.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class LoginService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public LoginService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Transactional
	public void doLogin(HttpServletResponse response, Usuario usuario){

//		Optional<Usuario> UsuarioEmailandSenhaOptional = usuarioRepository.findUsuarioByEmailandSenha(usuario.getEmail(), usuario.getSenha());

		Usuario usuariodb = usuarioRepository
				.findUsuarioByEmailandSenha(usuario.getEmail(), usuario.getSenha())
				.orElse(null);

		if (usuariodb == null){
			response.setStatus(401);
			return;
		}

		String token = TokenGenerator.generateNewToken();
		usuario.setToken(token);
		usuariodb.setToken(token);

		Cookie cookieLogado = new Cookie("auth", token);
		cookieLogado.setMaxAge(9999);
		cookieLogado.setHttpOnly(true);
		cookieLogado.setSecure(true);

		response.addCookie(cookieLogado);
		response.setStatus(200);


	}

	public void checkAuth(HttpServletResponse response, @CookieValue(value = "auth", defaultValue = "undefined") String cookie){

		Usuario usuariodb = usuarioRepository
				.findUsuarioByAuth(cookie)
				.orElse(null);

		if(cookie.equals("undefined") | usuariodb == null ){
			response.setStatus(401);
		}
	}
}
