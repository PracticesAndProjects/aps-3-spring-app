package com.aps.recycleplace.domain.entities;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Usuario {
	@Id
	@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_sequence",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
	private Long id;
	@NotNull
	@Size(min = 3)
	private String nome;

	@NotNull
	@Size(min = 4)
	private String email;

	@NotNull
	@Size(min = 6)
	private String senha;

	private String token;


	@NotNull
	private LocalDate data_nasc;

	@NotNull
	private int orcamento_total;

	@NotNull
	private int orcamento_op;

	@NotNull
	private String telefone;

	@NotNull
	private String endereco;

	@NotNull
	private String cpf_cnpj;
	@Transient
	private Integer idade;

	@NotNull
	private int idType;

	public Usuario() {}

	public Usuario(Long id, String nome, String email, LocalDate data_nasc, int orcamento_total,
			int orcamento_op, String telefone, String endereco, String cpf_cnpj, int idType) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.data_nasc = data_nasc;
		this.orcamento_total = orcamento_total;
		this.orcamento_op = orcamento_op;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cpf_cnpj = cpf_cnpj;
		this.idType = idType;
	}

	public Usuario(String nome, String email, LocalDate data_nasc, int orcamento_total,
			int orcamento_op, String telefone, String endereco, String cpf_cnpj, String token,
			String senha, int idType) {
		this.nome = nome;
		this.email = email;
		this.data_nasc = data_nasc;
		this.orcamento_total = orcamento_total;
		this.orcamento_op = orcamento_op;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cpf_cnpj = cpf_cnpj;
		this.token = token;
		this.senha = senha;
		this.idType = idType;
	}

	public Usuario(String email, String senha, String token, int idType) {
		this.email = email;
		this.senha = senha;
		this.token = token;
		this.idType = idType;
	}

	public Usuario(String nome, String email, String senha, LocalDate data_nasc, int orcamento_total,
			int orcamento_op, String telefone, String endereco, String cpf_cnpj, int idType) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.data_nasc = data_nasc;
		this.orcamento_total = orcamento_total;
		this.orcamento_op = orcamento_op;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cpf_cnpj = cpf_cnpj;
		this.idType = idType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(LocalDate data_nasc) {
		this.data_nasc = data_nasc;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public int getIdType() {
		return idType;
	}

	public Integer getAge() {
		return Period.between(this.data_nasc, LocalDate.now()).getYears();
	}

	public void setAge(Integer idade) {
		this.idade = idade;
	}

	public int getOrcamento_total() {
		return orcamento_total;
	}

	public void setOrcamento_total(int orcamento_total) {
		this.orcamento_total = orcamento_total;
	}

	public int getOrcamento_op() {
		return orcamento_op;
	}

	public void setOrcamento_op(int orcamento_op) {
		this.orcamento_op = orcamento_op;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Usuario{" + "id=" + id + ", name='" + nome + '\'' + ", email='" + email + '\''
				+ ", data_nasc=" + data_nasc + ", orcamento_total=" + orcamento_total + ", orcamento_op="
				+ orcamento_op + ", telefone='" + telefone + '\'' + ", endereco='" + endereco + '\''
				+ ", cpf_cnpj='" + cpf_cnpj + '\'' + ", idade=" + idade + '}';
	}

}
