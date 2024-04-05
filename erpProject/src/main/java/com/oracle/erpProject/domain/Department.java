package com.oracle.erpProject.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "empList")
public class Department { /* KM_Department */

	@Id
	@GeneratedValue(generator = "DEPT_NO_SEQ")
	@SequenceGenerator(name = "DEPT_NO_SEQ", sequenceName = "DEPT_NO_SEQ", allocationSize = 1)
	private int dept_no; // 부서번호(코드)
	private String dept_name; // 부서명
	private String dept_phone; // 부서전화번호
	// @Column(columnDefinition = "defalut 'Y'")
	private String dept_enabled; // 부서존재여부

//	@OneToMany(mappedBy="department", fetch = FetchType.LAZY, orphanRemoval = true)
	@OneToMany(mappedBy="department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Employee> empList = new ArrayList<Employee>();
	
}
