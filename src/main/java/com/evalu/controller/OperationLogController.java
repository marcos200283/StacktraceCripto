package com.evalu.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evalu.persistence.entity.OperationLog;
import com.evalu.service.OperationLogService;
 

@RestController
@RequestMapping("/logs")
public class OperationLogController {
	private final OperationLogService operationLogService;
	
	public OperationLogController(OperationLogService operationLogService){
		this.operationLogService=operationLogService;
	}
	
 
	@GetMapping
	public List<OperationLog> findAll(){
		return this.operationLogService.findAll();
	}
	 
}
