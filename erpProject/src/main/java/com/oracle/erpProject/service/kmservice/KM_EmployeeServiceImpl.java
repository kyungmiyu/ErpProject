package com.oracle.erpProject.service.kmservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oracle.erpProject.dao.kmdao.EmployeeDaoImpl;
import com.oracle.erpProject.domain.Employee;

@Service
public class KM_EmployeeServiceImpl implements KM_EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeDaoImpl;
		
	@Override
	public Employee registEmployee(Employee employee) {
		return employeeDaoImpl.registEmployee(employee);
	}

	@Override
	public List<Employee> listEmployee(Pageable paging) {
		return employeeDaoImpl.listEmployee(paging).getContent();
	}
	
	@Override
	public Employee getEmployee(int emp_no) {
		return employeeDaoImpl.getEmployee(emp_no);
	}
	
	
	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeDaoImpl.updateEmployee(employee);
	}

	@Override
	public Employee deleteEmployee(Employee employee) {
		return null;
	}

	



}
