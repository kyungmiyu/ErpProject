package com.oracle.erpProject.service.lhsservice;

import java.util.List;

import com.oracle.erpProject.model.Employee;

public interface LHS_Serivce_Interface {
	
	// 테스트용 인덱스
	List<Employee> getListEmp();

	Employee getDataEmp(int emp_no);

}
