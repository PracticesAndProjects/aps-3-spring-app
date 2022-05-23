package com.aps.recycleplace.domain.mapping;

public class UserAuthDTO {
  private String nome;
  private String email;
  private String token;
  private Long id;

  public UserAuthDTO(String email, String nome, String token, Long id) {
    this.email = email;
    this.nome = nome;
    this.token = token;
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public String getNome() {
    return nome;
  }

  public String getToken() {
    return token;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
