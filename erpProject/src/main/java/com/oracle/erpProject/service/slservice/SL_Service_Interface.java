package com.oracle.erpProject.service.slservice;

import java.util.List;

import com.oracle.erpProject.model.Buying;
import com.oracle.erpProject.model.Product;
import com.oracle.erpProject.model.slmodel.SLBuying;
import com.oracle.erpProject.model.slmodel.SLBuying_detail;
import com.oracle.erpProject.model.slmodel.SLProduct;

public interface SL_Service_Interface {

	int totalbuyingCnt();

	List<SLBuying> buyAlllist(SLBuying buying);
	
	
	// 날짜 검색 
	int dateSearchtotCnt(SLBuying buying);
	List<SLBuying> dateSearchAllList(SLBuying buying);
	
	
	// 구매 상세 페이지
	SLBuying buyingDetail(SLBuying buying);
	// 구매 상세 페이지 제품 리스트
	List<SLBuying> productDetail(SLBuying buying);
	
	// 구매 제품 리스트
	List<SLProduct> productList();

	
	// 구매 제품 추가
	int addProduct(SLBuying_detail sLBuying_detail);
	

}
