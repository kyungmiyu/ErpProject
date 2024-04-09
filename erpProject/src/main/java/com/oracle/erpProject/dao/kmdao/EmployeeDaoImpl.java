package com.oracle.erpProject.dao.kmdao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.oracle.erpProject.domain.Employee;
import com.oracle.erpProject.repository.EmployeeRepository;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee registEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Page<Employee> listEmployee(Pageable paging) {
		System.out.println("page ->"+ paging);
		return employeeRepository.findAll(paging);
	}

	@Override
	public Employee getEmployee(int empNo) {
		return employeeRepository.findById(empNo).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		employeeRepository.findById(employee.getEmpNo()).get();
		return employeeRepository.save(employee);
	}

	// test
	@Override
	public Page<Employee> listPage(Pageable pageable) {
		return employeeRepository.findAll(PageRequest.of(0, 10));
	}

	@Override
	public Employee findByEmpNo(int empNo) {
		return employeeRepository.findById(empNo).get();
	}

	
}
