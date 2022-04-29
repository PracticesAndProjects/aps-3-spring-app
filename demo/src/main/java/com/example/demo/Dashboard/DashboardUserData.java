package com.example.demo.Dashboard;

import java.time.LocalDate;

public class DashboardUserData {
	private String name;
	private String email;
	private LocalDate data_nasc;
	private int orcamento_total;
	private int orcamento_op;
	private String telefone;
	private String endereco;
	private String cpf_cnpj;

	public DashboardUserData(String name,
	                         String email,
	                         LocalDate data_nasc,
	                         int orcamento_total,
	                         int orcamento_op,
	                         String telefone,
	                         String endereco,
	                         String cpf_cnpj) {
		this.name = name;
		this.email = email;
		this.data_nasc = data_nasc;
		this.orcamento_total = orcamento_total;
		this.orcamento_op = orcamento_op;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cpf_cnpj = cpf_cnpj;
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

	public LocalDate getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(LocalDate data_nasc) {
		this.data_nasc = data_nasc;
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

	@Override
	public String toString() {
		return "DashboardUserData{" +
				"name='" + name + '\'' +
				", email='" + email + '\'' +
				", data_nasc=" + data_nasc +
				", orcamento_total=" + orcamento_total +
				", orcamento_op=" + orcamento_op +
				", telefone='" + telefone + '\'' +
				", endereco='" + endereco + '\'' +
				", cpf_cnpj='" + cpf_cnpj + '\'' +
				'}';
	}
}
