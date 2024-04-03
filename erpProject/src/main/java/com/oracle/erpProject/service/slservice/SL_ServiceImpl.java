package com.oracle.erpProject.service.slservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.erpProject.dao.sldao.SL_Dao_Interface;
import com.oracle.erpProject.model.Buying;
import com.oracle.erpProject.model.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SL_ServiceImpl implements SL_Service_Interface {
	
	private final SL_Dao_Interface slDao;

	@Override
	public int totalbuyingCnt() {
		int totalbuyingCnt = slDao.totalbuyingCnt();
		return totalbuyingCnt;
	}

	@Override
	public List<Buying> buyAlllist(Buying buying) {
		System.out.println("SL_ServiceImpl buyAlllist Start ->>>>>>");
		List<Buying> buyAlllist = slDao.buyAlllist(buying);
		System.out.println("SL_ServiceImpl buyAlllist buyAlllist ->>>>>>" + buyAlllist);
		return buyAlllist;
	}

	// 날짜 검색
	@Override
	public int dateSearchtotCnt(Buying buying) {
		System.out.println("SL_ServiceImpl dateSearchtotCnt Start ->>>>>>");
		
		int dateSearchtotCnt = slDao.dateSearchtotCnt(buying);
		return dateSearchtotCnt;
	}
	

	// 날짜 검색 리스트
	@Override
	public List<Buying> dateSearchAllList(Buying buying) {
		System.out.println("SL_ServiceImpl dateSearchAllList Start ->>>>>>");
		List<Buying> dateSearchAllList = slDao.dateSearchAllList(buying);
		
		System.out.println("SL_ServiceImpl dateSearchAllList  ->>>>>>" + dateSearchAllList);
		
		return dateSearchAllList;
	}

	// 구매 상세 페이지
	@Override
	public Buying buyingDetail(Buying buying) {
		
		System.out.println("SL_ServiceImpl buyingDetail Start ->>>>>>");
		Buying buyingDetail =  slDao.buyingDetail(buying);
		 
		 
		return buyingDetail;
	}

	// 구매 상세페이지 상품 리스트 
	@Override
	public List<Buying> productDetail(Buying buying) {
		System.out.println("SL_ServiceImpl productDetail Start ->>>>>>");
		List<Buying> productDetail = slDao.productDetail(buying);
		
		return productDetail;
	}

	@Override
	public List<Product> productList() {
		List<Product> productList = slDao.productList();
		
		return productList;
	}
	
}
