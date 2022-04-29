package com.example.demo.Dashboard;

import com.example.demo.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class DashboardService {

	public UsuarioRepository usuarioRepository;

	@Autowired
	public DashboardService(UsuarioRepository usuarioRepository){
		this.usuarioRepository = usuarioRepository;
	}

	public DashboardUserData getUserData(String authToken, HttpServletResponse response) {

		Optional<DashboardUserData> userOptional = usuarioRepository.findUsuarioByAuthList(authToken);

		if (userOptional.isEmpty()){
			response.setStatus(401);
			return null;
		}

		return userOptional.get();
	}
}
