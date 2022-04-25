package com.example.demo.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}

	@PostMapping
	public void registerNewUsuario(@RequestBody Usuario usuario, HttpServletResponse response){
		usuarioService.addNewUsuario(usuario, response);
	}

	@DeleteMapping(path = "{studentId}")
	public void deleteUsuario(@PathVariable("studentId") Long studentId){
		usuarioService.deleteUsuario(studentId);
	}

	@PutMapping(path = "{studentId}")
	public void updateUsuario(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email
	){
		usuarioService.updateUsuario(studentId, name, email);
	}

}
