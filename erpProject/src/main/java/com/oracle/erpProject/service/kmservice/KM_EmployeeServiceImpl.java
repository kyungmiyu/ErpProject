package com.oracle.erpProject.service.kmservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Override
	public Employee findByEmpNo(int empNo) {
		return employeeDaoImpl.findByEmpNo(empNo);
	}
	
	@Override
	public List<Employee> getEmployeeList(int size, int offset, String searchType, String searchValue) {
		return employeeDaoImpl.getEmployeeList(size, offset, searchType, searchValue);
	}
	
	@Override
	public Integer countEmplyeeList() {
		return employeeDaoImpl.countEmplyeeList();
	};
	
	


}
