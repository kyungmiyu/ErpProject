package com.oracle.erpProject.service.slservice;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.erpProject.dao.sldao.SL_Dao_Interface;
import com.oracle.erpProject.model.slmodel.SLBuying;
import com.oracle.erpProject.model.slmodel.SLBuying_detail;
import com.oracle.erpProject.model.slmodel.SLProduct;

import lombok.RequiredArgsConstructor;
@Transactional
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
	public List<SLBuying> buyAlllist(SLBuying buying) {
		System.out.println("SL_ServiceImpl buyAlllist Start ->>>>>>");
		List<SLBuying> buyAlllist = slDao.buyAlllist(buying);
		System.out.println("SL_ServiceImpl buyAlllist buyAlllist ->>>>>>" + buyAlllist);
		return buyAlllist;
	}

	// 날짜 검색
	@Override
	public int dateSearchtotCnt(SLBuying buying) {
		System.out.println("SL_ServiceImpl dateSearchtotCnt Start ->>>>>>");
		
		int dateSearchtotCnt = slDao.dateSearchtotCnt(buying);
		return dateSearchtotCnt;
	}
	

	// 날짜 검색 리스트
	@Override
	public List<SLBuying> dateSearchAllList(SLBuying buying) {
		System.out.println("SL_ServiceImpl dateSearchAllList Start ->>>>>>");
		List<SLBuying> dateSearchAllList = slDao.dateSearchAllList(buying);
		
		System.out.println("SL_ServiceImpl dateSearchAllList  ->>>>>>" + dateSearchAllList);
		
		return dateSearchAllList;
	}

	// 구매 상세 페이지
	@Override
	public SLBuying buyingDetail(SLBuying buying) {
		
		System.out.println("SL_ServiceImpl buyingDetail Start ->>>>>>");
		SLBuying buyingDetail =  slDao.buyingDetail(buying);
		 
		 
		return buyingDetail;
	}

	// 구매 상세페이지 상품 리스트 
	@Override
	public List<SLBuying> productDetail(SLBuying buying) {
		System.out.println("SL_ServiceImpl productDetail Start ->>>>>>");
		List<SLBuying> productDetail = slDao.productDetail(buying);
		
		return productDetail;
	}

	@Override
	public List<SLProduct> productList() {
		List<SLProduct> productList = slDao.productList();
		
		return productList;
	}

	

	@Override
	public List<SLBuying_detail> getProductList(SLBuying_detail slBuying_detail) {
		
		List<SLBuying_detail> getProductList = slDao.getProductList(slBuying_detail);
		
		return getProductList;
	}

	
	@Override
	public int deleteProduct(SLBuying_detail sLBuying_detail) {
		
		int deleteProduct = slDao.deleteProduct(sLBuying_detail);
		
		return deleteProduct;
	}

	@Override
	public int buyingModify(SLBuying buying) {
		
		int buyingModify = slDao.buyingModify(buying);
		return buyingModify;
	}

	@Override
	public int productCntModify(SLBuying_detail sLBuying_detail) {
		
		int productCntModify = slDao.productCntModify(sLBuying_detail);
		
		
		return productCntModify;
	}

	@Override
	public int buyStatusChange(SLBuying buying) {
		
		int buyStatusChange = slDao.buyStatusChange(buying);
		
		return buyStatusChange;
	}

	@Override
	public SLBuying customerSearch(SLBuying buying) {
		SLBuying customerSearch = slDao.customerSearch(buying);
		return customerSearch;
	}
	
	@Override
	public List<SLBuying> getManagerList(SLBuying buying) {
		
		List<SLBuying> getManagerList = slDao.getManagerList(buying);
		
		return getManagerList;
	}
	
	

	@Override
	public int addProduct(SLBuying_detail slBuying_detail) {
		int addProduct = slDao.addProduct(slBuying_detail);
		
		return addProduct;
	}
	
	
	@Override
	public int buyingApplyWrite(SLBuying buying) {
	    // 부모 테이블에 데이터 추가
	    int buyingApplyWrite = slDao.buyingApplyWrite(buying);
	          
	        return buyingApplyWrite;
	   
	}
	
	
	@Override
	public int buyingApplyAddDetail(SLBuying buying) {
		int buyingApplyAddDetail = slDao.buyingApplyAddDetail(buying);
		return buyingApplyAddDetail;
	}

	

	
	

	
	
	
	
	
	
	
	
	
}
