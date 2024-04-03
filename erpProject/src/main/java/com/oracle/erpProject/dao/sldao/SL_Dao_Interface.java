package com.oracle.erpProject.dao.sldao;

import java.util.List;

import com.oracle.erpProject.model.Buying;
import com.oracle.erpProject.model.Product;
import com.oracle.erpProject.model.slmodel.SLBuying;
import com.oracle.erpProject.model.slmodel.SLBuying_detail;
import com.oracle.erpProject.model.slmodel.SLProduct;

public interface SL_Dao_Interface {

	int totalbuyingCnt();

	List<SLBuying> buyAlllist(SLBuying buying);

	// 날짜 검색 
	int dateSearchtotCnt(SLBuying buying);

	// 날짜 검색 리스트 
	List<SLBuying> dateSearchAllList(SLBuying buying);

	
	// 구매 상세 페이지
	SLBuying buyingDetail(SLBuying buying);

	// 구매 상세 페이지 제품 리스트 
	List<SLBuying> productDetail(SLBuying buying);

	List<SLProduct> productList();

	int addProduct(SLBuying_detail slBuying_detail);

}
