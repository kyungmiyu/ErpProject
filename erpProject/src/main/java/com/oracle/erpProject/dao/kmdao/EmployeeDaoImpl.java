package com.oracle.erpProject.dao.kmdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
		return employeeRepository.findAll(paging);
	}

	@Override
	public Employee getEmployee(int emp_no) {
		System.out.println("Dao emp_no ===> " + emp_no);
		return employeeRepository.findById(emp_no).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		employeeRepository.findById(employee.getEmpNo()).get();
		return employeeRepository.save(employee);
	}

}
