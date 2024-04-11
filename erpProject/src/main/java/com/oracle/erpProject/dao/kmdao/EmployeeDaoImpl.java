package com.oracle.erpProject.dao.kmdao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.erpProject.domain.Employee;
import com.oracle.erpProject.repository.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	public EntityManager entityManager;

	@Override
	public Employee registEmployee(Employee employee) {
		return employeeRepository.save(employee);
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

	@Override
	public Employee findByEmpNo(int empNo) {
		return employeeRepository.findById(empNo).get();
	}
	
	// list count
	@Override
	public Integer countEmplyeeList() {
		return employeeRepository.findAll().size();
	}

	// list
	@Override
	public List<Employee> getEmployeeList(int size, int offset, String searchType, String searchValue) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

		Root<Employee> employee = criteriaQuery.from(Employee.class);
		Predicate searchPredicate = null;
		searchType = searchType==null ? "" : searchType;
		if (searchType.equals("E")) {
			searchPredicate = criteriaBuilder.equal(employee.get("empName"), searchValue);
		} else if (searchType.equals("D")) {
			searchPredicate = criteriaBuilder.equal(employee.get("deptNo"), searchValue);
		}
		criteriaQuery.where(searchPredicate, searchPredicate);
		criteriaQuery.orderBy(criteriaBuilder.desc(employee.get("empNo")));
		
		TypedQuery<Employee> typedQuery = entityManager.createQuery(criteriaQuery).setFirstResult(offset)
				.setMaxResults(size);
        return typedQuery.getResultList();
	}
	
}
