package com.oracle.erpProject.service.jjservice;

import java.util.List;

import com.oracle.erpProject.model.jjmodel.JJ_Make;
import com.oracle.erpProject.model.jjmodel.JJ_Make_detail;

public interface JJ_Service_Interface {

	int 					cntMake();
	List<JJ_Make_detail> 	makedetailList(JJ_Make_detail md);
	List<JJ_Make_detail> 	requestMakeList();
	int 					makeRequest1(JJ_Make m);	// make table insert
	int 					makeRequest2(JJ_Make_detail md);	// make_dtail table insert
	JJ_Make_detail 			jjmakeDetail(int m_num);			// 생산 상세 페이지
	int 					makeSearchCnt(JJ_Make_detail md);	// 검색어 카운트 기능
	List<JJ_Make_detail> 	makeSearchList(JJ_Make_detail md);	// 검색어 리스트 조회
	int 					jjmakeDelete(int m_num);			// 생산 삭제 기능

}
