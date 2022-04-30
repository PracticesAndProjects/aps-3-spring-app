package com.example.demo.DTOs;

public class UsuarioPublicDTO {
	private String name;
	private String email;
	private String telefone;
	private Long id;

	public UsuarioPublicDTO(String name, String email, String telefone, Long id) {
		this.name = name;
		this.email = email;
		this.telefone = telefone;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
