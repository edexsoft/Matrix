package com.edexsoft.matrix.outer.domain.view;

import java.util.Date;

import com.edexsoft.data.PagingData;

public interface IPurchaseOrderExService {

	long GetTotalItemAmount(long purchaseOrderId);

	PagingData<PurchaseOrderEx> ListAll(String no,
			Date startTime, Date endTime, long pageIndex, long pageSize);
}
