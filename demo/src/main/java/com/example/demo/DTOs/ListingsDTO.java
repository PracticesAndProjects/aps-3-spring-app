package com.example.demo.DTOs;


public class ListingsDTO {
	private String title;
	private String img_url;
	private String material_type;
	private int delivery_type; //1: Conta do comprador, 2: Conta do vendedor
	private int product_price;
	private int delivery_median_price;
	private int volume_dimension;
	private int weight_dimension;
	private Long usuario_id;
	private Long listing_id;
	private String owner_name;

	public ListingsDTO(String title,
	                   String img_url,
	                   String material_type,
	                   int delivery_type,
	                   int product_price,
	                   int delivery_median_price,
	                   int volume_dimension,
	                   int weight_dimension,
	                   Long usuario_id,
	                   Long listing_id,
	                   String owner_name) {
		this.title = title;
		this.img_url = img_url;
		this.material_type = material_type;
		this.delivery_type = delivery_type;
		this.product_price = product_price;
		this.delivery_median_price = delivery_median_price;
		this.volume_dimension = volume_dimension;
		this.weight_dimension = weight_dimension;
		this.usuario_id = usuario_id;
		this.listing_id = listing_id;
		this.owner_name = owner_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getMaterial_type() {
		return material_type;
	}

	public void setMaterial_type(String material_type) {
		this.material_type = material_type;
	}

	public int getDelivery_type() {
		return delivery_type;
	}

	public void setDelivery_type(int delivery_type) {
		this.delivery_type = delivery_type;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getDelivery_median_price() {
		return delivery_median_price;
	}

	public void setDelivery_median_price(int delivery_median_price) {
		this.delivery_median_price = delivery_median_price;
	}

	public int getVolume_dimension() {
		return volume_dimension;
	}

	public void setVolume_dimension(int volume_dimension) {
		this.volume_dimension = volume_dimension;
	}

	public int getWeight_dimension() {
		return weight_dimension;
	}

	public void setWeight_dimension(int weight_dimension) {
		this.weight_dimension = weight_dimension;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Long getListing_id() {
		return listing_id;
	}

	public void setListing_id(Long listing_id) {
		this.listing_id = listing_id;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
}
