package com.edexsoft.matrix.outer.domain.view;

import java.util.Date;

import com.edexsoft.data.PagingDataResult;

public interface IPurchaseOrderExService {

	long GetTotalItemAmount(long purchaseOrderId);

	PagingDataResult<PurchaseOrderEx> ListAll(String no,
			Date startTime, Date endTime, long pageIndex, long pageSize);
}
