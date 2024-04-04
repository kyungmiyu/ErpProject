package com.oracle.erpProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {	/* KM_Department */
	
	@Id
	@GeneratedValue
	int dept_no; 			// 부서번호(코드)
	String dept_name; 		// 부서명
	String dept_phone; 		// 부서전화번호
	String dept_enabled; 	// 부서존재여부
	
}