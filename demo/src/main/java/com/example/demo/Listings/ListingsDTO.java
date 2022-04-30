package com.example.demo.Listings;


public class ListingsDTO {
	private String title;
	private String imgUrl;
	private String materialType;
	private int deliveryType; //1: Conta do comprador, 2: Conta do vendedor
	private int productPrice;
	private int deliveryMedianPrice;
	private int volumeDimension;
	private int weightDimension;
	private Long usuario_id;
	private Long listing_id;
	private String owner_name;

	public ListingsDTO(String title,
	                   String imgUrl,
	                   String materialType,
	                   int deliveryType,
	                   int productPrice,
	                   int deliveryMedianPrice,
	                   int volumeDimension,
	                   int weightDimension,
	                   Long usuario_id,
	                   Long listing_id,
	                   String owner_name) {
		this.title = title;
		this.imgUrl = imgUrl;
		this.materialType = materialType;
		this.deliveryType = deliveryType;
		this.productPrice = productPrice;
		this.deliveryMedianPrice = deliveryMedianPrice;
		this.volumeDimension = volumeDimension;
		this.weightDimension = weightDimension;
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
