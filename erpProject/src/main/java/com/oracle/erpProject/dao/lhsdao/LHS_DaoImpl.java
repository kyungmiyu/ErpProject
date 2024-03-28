package com.oracle.erpProject.dao.lhsdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.model.Employee;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LHS_DaoImpl implements LHS_Dao_Interface {
	
	private final SqlSession session;

	@Override
	public List<Employee> getListEmp() {
		List<Employee> listEmp = null;
		
		try {
			// 쿼리문 미완성 -> model dept_name 추가 + dept와 쿼리해서 dept_name까지 select하기
			listEmp = session.selectList("com.oracle.erpProject.EmpMapper.lhsGetListEmp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listEmp;
	}

	@Override
	public Employee getDataEmp(int emp_no) {
		Employee empData = null;
		
		try {
			empData = session.selectOne("lhsGetDataEmp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empData; 
	}
	
	


}
