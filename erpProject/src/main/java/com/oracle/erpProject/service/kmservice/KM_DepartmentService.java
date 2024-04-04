package com.oracle.erpProject.service.kmservice;

import java.util.List;

import com.oracle.erpProject.domain.Department;

public interface KM_DepartmentService {

	Department insertDepartment(Department department);
	
	// searchType : 검색타입
	// searchKeyword : 검색어
	// start : 페이징 시작번호
	// count : 페이징 전체 카운트
	// sort : 정렬 내용
	// sortDirection : 정렬 기준	
	List<Department> listDepartment(String searchType, String searchKeyword, 
									Integer start, Integer count, String sort, String Direction);

	Department updateDepartment(Department department);

	Department deleteDepartment(Department department);
}
