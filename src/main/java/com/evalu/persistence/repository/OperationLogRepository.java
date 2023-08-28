package com.evalu.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.evalu.persistence.entity.OperationLog;
 
@Repository
public interface OperationLogRepository extends JpaRepository<OperationLog,Long>{

}
