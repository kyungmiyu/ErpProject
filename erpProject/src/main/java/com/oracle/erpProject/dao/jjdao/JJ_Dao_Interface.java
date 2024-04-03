package com.oracle.erpProject.dao.jjdao;

import java.util.List;

import com.oracle.erpProject.model.jjmodel.JJ_Make_detail;

public interface JJ_Dao_Interface {

	int 					cntMake();
	List<JJ_Make_detail> 	makeList(JJ_Make_detail md);
	List<JJ_Make_detail> 	requestMakeList();
	int 					makeRequest(JJ_Make_detail md);
	JJ_Make_detail 			jjmakeDetail(int m_num);			// 생산 상세 페이지
	int 					makeSearchCnt(JJ_Make_detail md);	// 검색어 카운트 기능
	List<JJ_Make_detail> 	makeSearchList(JJ_Make_detail md);	// 검색어 리스트 로드
	int 					jjmakeDelete(int m_num);			// 생산 삭제 기능

}
