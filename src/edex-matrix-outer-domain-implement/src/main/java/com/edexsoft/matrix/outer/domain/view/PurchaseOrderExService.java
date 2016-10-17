package com.edexsoft.matrix.outer.domain.view;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edexsoft.data.PagingDataResult;

@Service("PurchaseOrderExService")
public class PurchaseOrderExService implements IPurchaseOrderExService {

	@Autowired
	@Qualifier("PurchaseOrderExMapper")
	private PurchaseOrderExMapper entityMapper;

	public long GetTotalItemAmount(long purchaseOrderId) {
		long iTotalItemAmount = entityMapper.totalItemAmount(purchaseOrderId);
		return iTotalItemAmount;
	}

	public PagingDataResult<PurchaseOrderEx> ListAll(String no, Date startTime, Date endTime, long pageIndex,
			long pageSize) {
		long totalRecords = entityMapper.countAll(no, startTime, endTime);

		List<PurchaseOrderEx> lstEntity = entityMapper.selectAll(no, startTime, endTime, pageSize,
				pageIndex * pageSize);

		PagingDataResult<PurchaseOrderEx> dData = new PagingDataResult<PurchaseOrderEx>();
		dData.setEntities(lstEntity);
		dData.setPageIndex(pageIndex);
		dData.setPageSize(pageSize);
		dData.setTotalRecords(totalRecords);
		return dData;
	}
}
