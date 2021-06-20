package com.moontea.interceptor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class CustomInterceptor extends EmptyInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);

	@Override
	public String onPrepareStatement(String sql) {
		logger.info("onPrepareStatement ====================");
		logger.info("sql = " + sql);
		AuditLogList auditLogList = (AuditLogList) SpringContextUtil.getBean("AuditLogList");
		AuditLog auditLog = auditLogList.generateNewInstance();
		auditLog.setSql(sql);
		auditLog.setLogTime(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(new Date()));
		return super.onPrepareStatement(sql);
	}

	@Override
	public int[] findDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		logger.info("findDirty ====================");
		logger.info("entity ====================" + entity.getClass());
		AuditLogList auditLogList = (AuditLogList) SpringContextUtil.getBean("AuditLogList");
		AuditLog auditLog = auditLogList.getAuditLog();
		auditLog.setBeforeState(previousState.toString());
		auditLog.setAfterState(currentState.toString());
		int[] intAry = super.findDirty(entity, id, currentState, previousState, propertyNames, types);
		if (null != intAry) {
			auditLog.setChangeCount(intAry.length);
		}
		return intAry;
	}

//	@Override
//	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
//		logger.info("onDelete ====================");
//		logger.info("entity ====================" + entity.getClass());
//		super.onDelete(entity, id, state, propertyNames, types);
//	}
//
//	@Override
//	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
//			String[] propertyNames, Type[] types) {
//		logger.info("onFlushDirty ====================");
//		logger.info("entity ====================" + entity.getClass());
//		return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
//	}
//
//	@Override
//	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
//		logger.info("onLoad ====================");
//		logger.info("entity ====================" + entity.getClass());
//		return super.onLoad(entity, id, state, propertyNames, types);
//	}
//
//	@Override
//	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
//		logger.info("onSave ====================");
//		logger.info("entity ====================" + entity.getClass());
//		return super.onSave(entity, id, state, propertyNames, types);
//	}
//
//	@Override
//	public void postFlush(Iterator entities) {
//		logger.info("postFlush ====================");
//		while (entities.hasNext()) {
//			logger.info("entity ====================" + entities.next().getClass());
//		}
//		super.postFlush(entities);
//	}
//
//	@Override
//	public void preFlush(Iterator entities) {
//		logger.info("preFlush ====================");
//		while (entities.hasNext()) {
//			logger.info("entity ====================" + entities.next().getClass());
//		}
//		super.preFlush(entities);
//	}

}