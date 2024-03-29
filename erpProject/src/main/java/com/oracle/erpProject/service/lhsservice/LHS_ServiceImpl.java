package com.oracle.erpProject.service.lhsservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.erpProject.dao.lhsdao.LHS_Dao_Interface;
import com.oracle.erpProject.model.Employee;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LHS_ServiceImpl implements LHS_Serivce_Interface {
	
	private final LHS_Dao_Interface lhs;

	// 테스트용 인덱스
	@Override
	public List<Employee> getListEmp() {
		List<Employee> listEmp = null;
		listEmp = lhs.getListEmp();
		return listEmp;
	}

	@Override
	public Employee getDataEmp(int emp_no) {
		Employee empData = null;
		empData = lhs.getDataEmp(emp_no);
		
		return empData;
	}

}
