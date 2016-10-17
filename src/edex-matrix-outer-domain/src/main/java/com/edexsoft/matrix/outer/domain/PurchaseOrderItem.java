package com.edexsoft.matrix.outer.domain;

public class PurchaseOrderItem {
	private long id;
	private long purchaseOrderId;
	private long providerProductId;
	private long providerProductNo;
	private long materialId;
	private long materialNo;
	private float quantity;
	private int unit;
	private String version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public long getProviderProductId() {
		return providerProductId;
	}

	public void setProviderProductId(long providerProductId) {
		this.providerProductId = providerProductId;
	}

	public long getProviderProductNo() {
		return providerProductNo;
	}

	public void setProviderProductNo(long providerProductNo) {
		this.providerProductNo = providerProductNo;
	}

	public long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(long materialId) {
		this.materialId = materialId;
	}

	public long getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(long materialNo) {
		this.materialNo = materialNo;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
