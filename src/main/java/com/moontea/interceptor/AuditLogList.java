package com.moontea.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component("AuditLogList")
@RequestScope
public class AuditLogList {

	public AuditLogList() {
		this.list = new ArrayList<>();
	}

	private List<AuditLog> list;

	private AuditLog auditLog;

	public AuditLog generateNewInstance() {
		this.auditLog = new AuditLog();
		this.list.add(auditLog);
		return auditLog;
//		if (auditLog != null)
//			this.list.add(auditLog);
//		this.auditLog = new AuditLog();
//		return auditLog;
	}

	public AuditLog getInstance() {
		return this.auditLog;
	}

	public List<AuditLog> getList() {
		return list;
	}

	public void setList(List<AuditLog> list) {
		this.list = list;
	}

	public AuditLog getAuditLog() {
		return auditLog;
	}

	public void setAuditLog(AuditLog auditLog) {
		this.auditLog = auditLog;
	}

}
