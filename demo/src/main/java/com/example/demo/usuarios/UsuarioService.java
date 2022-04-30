package com.example.demo.usuarios;

import com.example.demo.Authentication.TokenGenerator;
import com.example.demo.DTOs.UsuarioPublicDTO;
import com.example.demo.DbEntities.Usuario;
import com.example.demo.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}


	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public HttpServletResponse addNewUsuario(Usuario usuario, HttpServletResponse response) {
		Optional<Usuario> UsuarioOptional = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
		if (UsuarioOptional.isPresent()){
			throw new IllegalStateException("Email taken");
		}

		String token = TokenGenerator.generateNewToken();
		usuario.setToken(token);
		usuarioRepository.save(usuario);

		Cookie cookieLogado = new Cookie("auth", token);
		cookieLogado.setMaxAge(9999);
		cookieLogado.setHttpOnly(true);
		cookieLogado.setSecure(true);

		response.addCookie(cookieLogado);
		response.setStatus(200);

		return response;
	}

	public void deleteUsuario(Long studentId) {
		boolean exists = usuarioRepository.existsById(studentId);

		if(!exists) {
			throw new IllegalStateException("Usuario with id " + studentId + " does not exists");
		}
		usuarioRepository.deleteById(studentId);
	}

	@Transactional
	public void updateUsuario(Long studentId, String name, String email) {
		Usuario student = usuarioRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Usuario with id " + studentId + " does not exists!"));

		if (name != null && name.length() > 0 && !Objects.equals(student.getNome(), name)){
			student.setNome(name);
		}

		if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
			Optional<Usuario> studentOptional = usuarioRepository.findUsuarioByEmail(email);
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("Email taken");
			}
			student.setEmail(email);
		}
	}

	public UsuarioPublicDTO getPublicUserInfo(HttpServletResponse response, String authString, Long id){
		UsuarioPublicDTO usuarioDb =
				usuarioRepository.findUsuarioPublicById(id).orElse(null);

		if (usuarioDb == null){
			response.setStatus(401);
			return null;
		}

		return usuarioDb;
	}


//		return List.of(
//				new Usuario(
//						1L,
//						"Mariam",
//						"mariam.jamal@gmail.com",
//						LocalDate.of(2000, Month.JANUARY, 5),
//						21
//				)
//		);
}

