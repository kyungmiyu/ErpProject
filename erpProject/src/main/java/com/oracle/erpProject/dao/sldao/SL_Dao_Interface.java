package com.oracle.erpProject.dao.sldao;

import java.util.List;

import com.oracle.erpProject.model.Buying;
import com.oracle.erpProject.model.Product;

public interface SL_Dao_Interface {

	int totalbuyingCnt();

	List<Buying> buyAlllist(Buying buying);

	// 날짜 검색 
	int dateSearchtotCnt(Buying buying);

	// 날짜 검색 리스트 
	List<Buying> dateSearchAllList(Buying buying);

	
	// 구매 상세 페이지
	Buying buyingDetail(Buying buying);

	// 구매 상세 페이지 제품 리스트 
	List<Buying> productDetail(Buying buying);

	List<Product> productList();

}
