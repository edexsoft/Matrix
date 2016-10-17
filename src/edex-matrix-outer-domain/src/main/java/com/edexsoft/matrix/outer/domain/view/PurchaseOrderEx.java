package com.edexsoft.matrix.outer.domain.view;

import java.util.List;

import com.edexsoft.matrix.outer.domain.PurchaseOrder;
import com.edexsoft.matrix.outer.domain.PurchaseOrderItem;

public class PurchaseOrderEx extends PurchaseOrder{
	
	private List<PurchaseOrderItem> items;

	public List<PurchaseOrderItem> getItems() {
		return items;
	}

	public void setItems(List<PurchaseOrderItem> items) {
		this.items = items;
	}
}
