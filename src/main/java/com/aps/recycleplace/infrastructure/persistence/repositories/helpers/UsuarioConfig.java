package com.aps.recycleplace.infrastructure.persistence.repositories.helpers;

import com.aps.recycleplace.domain.entities.Usuario;
import com.aps.recycleplace.infrastructure.persistence.repositories.UsuarioRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class UsuarioConfig {

	@Bean
	CommandLineRunner commandLineRunner(UsuarioRepository repository) {
		return args -> {
			Usuario mariam = new Usuario("Mariam", "mariam.jamal@gmail.com",
					LocalDate.of(2000, JANUARY, 5), 2000, 1000, "9 9999 9999",
					"Rua tal, numero tal, bairro tal", "111.111.111-11", "111", "123456", 1);

			Usuario alex = new Usuario("Alex", "alex@gmail.com", LocalDate.of(2004, JANUARY, 5), 2000,
					1000, "9 9999 9999", "Rua tal, numero tal, bairro tal", "111.111.111-11", "222", "123456",
					1);

			// repository.saveAll(List.of(mariam, alex));
		};

	}
}
