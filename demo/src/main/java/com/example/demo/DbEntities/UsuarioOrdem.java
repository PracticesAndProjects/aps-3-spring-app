package com.example.demo.DbEntities;

import javax.persistence.*;

@Entity
@Table
public class UsuarioOrdem {
	@Id
	@SequenceGenerator(
			name = "_orders_sequence",
			sequenceName = "_orders_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "_orders_sequence"
	)
	private Long id;
	private boolean isAccepted;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario_ordem;

	@OneToOne
	@JoinColumn(name = "listing_id")
	private Listagem listing_ordem;

	public UsuarioOrdem() {
	}

	public Long getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario_ordem;
	}

	public void setUsuario(Usuario usuario_ordem) {
		this.usuario_ordem = usuario_ordem;
	}

	public Listagem getListing() {
		return listing_ordem;
	}

	public void setListing(Listagem listing_ordem) {
		this.listing_ordem = listing_ordem;
	}

	public UsuarioOrdem(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean accepted) {
		isAccepted = accepted;
	}
}

