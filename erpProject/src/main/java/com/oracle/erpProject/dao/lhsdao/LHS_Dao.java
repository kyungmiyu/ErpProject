package com.oracle.erpProject.dao.lhsdao;

import java.util.List;

import com.oracle.erpProject.model.lhsmodel.Employee;



public interface LHS_Dao {

	List<Employee> getListEmp();

	Employee getDataEmp(int emp_no);


}
