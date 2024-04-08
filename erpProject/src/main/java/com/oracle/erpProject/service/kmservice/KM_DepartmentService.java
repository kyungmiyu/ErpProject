package com.oracle.erpProject.service.kmservice;

import java.util.List;

import com.oracle.erpProject.domain.Department;

public interface KM_DepartmentService {

	Department insertDepartment(Department department);

	List<Department> listDepartment(String searchType, String searchKeyword, 
									Integer start, Integer count, String sort, String Direction);

	Department updateDepartment(Department department);

	Department deleteDepartment(Department department);
}
