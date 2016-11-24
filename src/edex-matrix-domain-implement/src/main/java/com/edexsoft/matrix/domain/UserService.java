//package com.edexsoft.matrix.domain;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import com.edexsoft.framework.utility.DateTimeHelper;
//import com.edexsoft.framework.utility.StringHelper;
//import com.edexsoft.data.PagingData;
//
//import com.edexsoft.matrix.domain.IUserService;
//import com.edexsoft.matrix.domain.User;
//import com.edexsoft.matrix.domain.repository.UserMapper;
//
//@Service("UserService")
//public class UserService implements IUserService {
//
//	@Autowired
//	@Qualifier("UserMapper")
//	private UserMapper userMapper;
//
//	public PagingData<User> Get(String account, String nickName, Integer auditState, String desc,
//			Date createdBegin, Date createdEnd, Long pageSize, Long pageIndex) {
//
//		UserExample oExample = new UserExample();
//		UserExample.Criteria oCriteria = oExample.createCriteria();
//		if (StringHelper.isNotBlank(account)) {
//			oCriteria.andAccountEqualTo(account);
//		}
//		if (StringHelper.isNotBlank(nickName)) {
//			oCriteria.andNickNameEqualTo(nickName);
//		}
//		if (auditState > 0) {
//			oCriteria.andAuditStateEqualTo(auditState);
//		}
//		if (StringHelper.isNotBlank(desc)) {
//			oCriteria.andDescLike("%" + desc + "%");
//		}
//
//		if (DateTimeHelper.isNotBlank(createdBegin) && DateTimeHelper.isNotBlank(createdEnd)) {
//			oCriteria.andMetaCreatedBetween(createdBegin, createdEnd);
//		} else if (DateTimeHelper.isNotBlank(createdBegin)) {
//			oCriteria.andMetaCreatedGreaterThanOrEqualTo(createdBegin);
//		} else if (DateTimeHelper.isNotBlank(createdEnd)) {
//			oCriteria.andMetaCreatedLessThan(createdEnd);
//		}
//
//		Long iTotalRecords = userMapper.countByExample(oExample);
//
//		oExample.setLimit(pageSize);
//		oExample.setOffset(pageIndex * pageSize);
//		List<User> lstEntity = userMapper.selectByExample(oExample);
//
//		PagingData<User> oData = new PagingData<User>();
//		oData.setPageSize(pageSize);
//		oData.setPageIndex(pageIndex);
//		oData.setTotalRecords(iTotalRecords);
//		oData.setEntities(lstEntity);
//		return oData;
//	}
//
//	public User findById(Long id) {
//		User oEntity = null;// userMapper.selectByPrimaryKey(id);
//		return oEntity;
//	}
//
//	public User findByAccount(String account) {
//		UserExample ex = new UserExample();
//		ex.createCriteria().andAccountEqualTo(account);
//		List<User> lstEntity = userMapper.selectByExample(ex);
//		if (lstEntity == null || lstEntity.isEmpty()) {
//			return null;
//		} else {
//			return lstEntity.get(0);
//		}
//	}
//}
