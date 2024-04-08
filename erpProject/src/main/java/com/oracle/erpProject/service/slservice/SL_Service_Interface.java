package com.oracle.erpProject.service.slservice;

import java.util.List;

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

	List<SLBuying_detail> getProductList(SLBuying_detail sLBuying_detail);

	int deleteProduct(SLBuying_detail sLBuying_detail);

	
	
	
	int buyingModify(SLBuying buying);

	int productCntModify(SLBuying_detail sLBuying_detail);
	

	int buyStatusChange(SLBuying buying);

	SLBuying customerSearch(SLBuying buying);
	
	List<SLBuying> getManagerList(SLBuying buying);

	SLBuying checkBuyData(SLBuying buying);

	int buyingApplyWrite(SLBuying buying);

	int statusSearchtotCnt(SLBuying buying);

	List<SLBuying> StatusSearchAllList(SLBuying buying);

	



	



}
