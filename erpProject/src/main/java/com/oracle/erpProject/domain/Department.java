package com.oracle.erpProject.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "empList")
public class Department { /* KM_Department */

	@Id
	@GeneratedValue
	@Column(name="DEPT_NO")
	Integer deptNo; // 부서번호(코드)
	String dept_name; // 부서명
	String dept_phone; // 부서전화번호
	// @Column(columnDefinition = "defalut 'Y'")
	String dept_enabled; // 부서존재여부

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Employee> empList = new ArrayList<Employee>();

}
