package com.oracle.erpProject.service.slservice;

import java.util.List;

import com.oracle.erpProject.model.Buying;

public interface SL_Service_Interface {

	int totalbuyingCnt();

	List<Buying> buyAlllist(Buying buying);
	
	
	// 날짜 검색 
	int dateSearchtotCnt(Buying buying);
	List<Buying> dateSearchAllList(Buying buying);
	
	
	// 구매 상세 페이지
	Buying buyingDetail(Buying buying);
	// 구매 상세 페이지 제품 리스트
	List<Buying> productDetail(Buying buying);
	

}
