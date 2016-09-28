package com.edexsoft.matrix.domain;

import java.util.Date;

import com.edexsoft.data.PagingDataResult;

public interface IUserService {
	
	User findByAccount(String account);
	
	PagingDataResult<User> Get(
			String account, String nickName, Integer auditState, String desc, 
			Date createdBegin, Date createdEnd,
			Long pageSize, Long pageIndex);
}
