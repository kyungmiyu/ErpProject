package com.oracle.erpProject.dao.jjdao;

import java.util.List;

import com.oracle.erpProject.model.jjmodel.JJ_Make_detail;

public interface JJ_Dao_Interface {

	int 					cntMake();
	List<JJ_Make_detail> 	makeList(JJ_Make_detail md);
	List<JJ_Make_detail> 	requestMakeList();
	int 					makeRequest(JJ_Make_detail md);
	JJ_Make_detail 			jjmakeDetail(int m_num);			// 생산 상세 페이지

}
