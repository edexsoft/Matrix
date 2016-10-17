package com.edexsoft.matrix.outer.domain.view;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.edexsoft.matrix.outer.domain.PurchaseOrderItem;

@Repository("PurchaseOrderExMapper")
public interface PurchaseOrderExMapper {

	@Select("SELECT SUM(poi.amount) FROM t_parchase_order po LEFT JOIN t_parchase_order_item poi ON po.id=poi.parchase_orer_id WHERE po.id = #{purchaseOrderId}")
	long totalItemAmount(long purchaseOrderId);

	long countAll(@Param("no") String no, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

	List<PurchaseOrderEx> selectAll(@Param("no") String no, @Param("startTime") Date startTime,
			@Param("endTime") Date endTime, @Param("limit") long limit, @Param("offset") long offset);

	List<PurchaseOrderItem> findByPoId(@Param("purchaseOrderId") long purchaseOrderId);

}
