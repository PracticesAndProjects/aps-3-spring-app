package com.aps.recycleplace.application.controllers;

import com.aps.recycleplace.domain.entities.Usuario;
import com.aps.recycleplace.domain.mapping.UsuarioPublicDTO;
import com.aps.recycleplace.implementation.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> getUsuarios() {
		return usuarioService.getUsuarios();
	}

	@GetMapping(path = "/{id}")
	public UsuarioPublicDTO getPublicUserInfo(HttpServletResponse response,
			@CookieValue(value = "token", defaultValue = "undefined") String authString,
			@PathVariable("id") Long id) {
		return usuarioService.getPublicUserInfo(response, authString, id);
	}

	@PostMapping
	public void registerNewUsuario(@RequestBody Usuario usuario, HttpServletResponse response) {
		usuarioService.addNewUsuario(usuario, response);
	}

	@DeleteMapping(path = "/{studentId}")
	public void deleteUsuario(@PathVariable("studentId") Long studentId) {
		usuarioService.deleteUsuario(studentId);
	}

	@PutMapping(path = "/{studentId}")
	public void updateUsuario(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		usuarioService.updateUsuario(studentId, name, email);
	}

}
