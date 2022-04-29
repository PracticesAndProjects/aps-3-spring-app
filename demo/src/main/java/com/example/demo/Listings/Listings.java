package com.example.demo.Listings;

import com.example.demo.usuarios.Usuario;

import javax.persistence.*;

@Entity
@Table
public class Listings {

	@Id
	@SequenceGenerator(
			name = "listings_sequence",
			sequenceName = "listings_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "listings_sequence"
	)
	private Long id;
	private String title;
	private String imgUrl;
	private String materialType;
	private int deliveryType; //1: Conta do comprador, 2: Conta do vendedor
	private int productPrice;
	private int deliveryMedianPrice;
	private int volumeDimension;
	private int weightDimension;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Listings() {
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Listings(String title,
	                String imgUrl,
	                String materialType,
	                int deliveryType,
	                int productPrice,
	                int deliveryMedianPrice,
	                int volumeDimension,
	                int weightDimension) {
		this.title = title;
		this.imgUrl = imgUrl;
		this.materialType = materialType;
		this.deliveryType = deliveryType;
		this.productPrice = productPrice;
		this.deliveryMedianPrice = deliveryMedianPrice;
		this.volumeDimension = volumeDimension;
		this.weightDimension = weightDimension;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public int getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(int deliveryType) {
		this.deliveryType = deliveryType;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getDeliveryMedianPrice() {
		return deliveryMedianPrice;
	}

	public void setDeliveryMedianPrice(int deliveryMedianPrice) {
		this.deliveryMedianPrice = deliveryMedianPrice;
	}

	public int getVolumeDimension() {
		return volumeDimension;
	}

	public void setVolumeDimension(int volumeDimension) {
		this.volumeDimension = volumeDimension;
	}

	public int getWeightDimension() {
		return weightDimension;
	}

	public void setWeightDimension(int weightDimension) {
		this.weightDimension = weightDimension;
	}



}


