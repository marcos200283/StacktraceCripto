package com.evalu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evalu.persistence.entity.OperationLog;
import com.evalu.persistence.repository.OperationLogRepository;

@Service
public class OperationLogService {
	private final OperationLogRepository repository;

	public OperationLogService(OperationLogRepository repository) {
		this.repository = repository;
	}
	
	public OperationLog depositLog(OperationLog operationLog) {
		return this.repository.save(operationLog);
	}
	public List<OperationLog> findAll(){
		return this.repository.findAll();
	}
}
