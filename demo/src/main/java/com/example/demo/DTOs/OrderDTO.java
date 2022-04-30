package com.example.demo.DTOs;

public class OrderDTO {
	private boolean isAccepted;
	private Long orderOwnerId;
	private String orderOwnerName;
	private String orderOwnerEmail;
	private String listingTitle;
	private String listingUrl;
	private String listingMaterialType;
	private Long listingCreatorId;
	private String listingCreatorName;
	private String listingCreatorEmail;

	public OrderDTO(boolean isAccepted,
	                Long orderOwnerId,
	                String orderOwnerName,
	                String orderOwnerEmail,
	                String listingTitle,
	                String listingUrl,
	                String listingMaterialType,
	                Long listingCreatorId,
	                String listingCreatorName,
	                String listingCreatorEmail) {
		this.isAccepted = isAccepted;
		this.orderOwnerId = orderOwnerId;
		this.orderOwnerName = orderOwnerName;
		this.orderOwnerEmail = orderOwnerEmail;
		this.listingTitle = listingTitle;
		this.listingUrl = listingUrl;
		this.listingMaterialType = listingMaterialType;
		this.listingCreatorId = listingCreatorId;
		this.listingCreatorName = listingCreatorName;
		this.listingCreatorEmail = listingCreatorEmail;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean accepted) {
		isAccepted = accepted;
	}

	public Long getOrderOwnerId() {
		return orderOwnerId;
	}

	public void setOrderOwnerId(Long orderOwnerId) {
		this.orderOwnerId = orderOwnerId;
	}

	public String getOrderOwnerName() {
		return orderOwnerName;
	}

	public void setOrderOwnerName(String orderOwnerName) {
		this.orderOwnerName = orderOwnerName;
	}

	public String getOrderOwnerEmail() {
		return orderOwnerEmail;
	}

	public void setOrderOwnerEmail(String orderOwnerEmail) {
		this.orderOwnerEmail = orderOwnerEmail;
	}

	public String getListingTitle() {
		return listingTitle;
	}

	public void setListingTitle(String listingTitle) {
		this.listingTitle = listingTitle;
	}

	public String getListingUrl() {
		return listingUrl;
	}

	public void setListingUrl(String listingUrl) {
		this.listingUrl = listingUrl;
	}

	public String getListingMaterialType() {
		return listingMaterialType;
	}

	public void setListingMaterialType(String listingMaterialType) {
		this.listingMaterialType = listingMaterialType;
	}

	public Long getListingCreatorId() {
		return listingCreatorId;
	}

	public void setListingCreatorId(Long listingCreatorId) {
		this.listingCreatorId = listingCreatorId;
	}

	public String getListingCreatorName() {
		return listingCreatorName;
	}

	public void setListingCreatorName(String listingCreatorName) {
		this.listingCreatorName = listingCreatorName;
	}

	public String getListingCreatorEmail() {
		return listingCreatorEmail;
	}

	public void setListingCreatorEmail(String listingCreatorEmail) {
		this.listingCreatorEmail = listingCreatorEmail;
	}
}
