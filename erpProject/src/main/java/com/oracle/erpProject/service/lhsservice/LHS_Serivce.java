package com.oracle.erpProject.service.lhsservice;

import java.util.List;

import com.oracle.erpProject.model.lhsmodel.Employee;
import com.oracle.erpProject.model.lhsmodel.Product;
import com.oracle.erpProject.model.lhsmodel.RnP_closing;
import com.oracle.erpProject.model.lhsmodel.Stock;


public interface LHS_Serivce {
	
	// 테스트용 사원리스트 조회
	List<Employee> getListEmp();
	
	
	/********************************************/
		/* 공통 */
	
	
	// 사원정보 조회
	Employee getDataEmp(int emp_no);
	
	
	/********************************************/
		/* 월 재고조회 */
	
	
	// 월 재고 total수 조회
	int getTotalStock(Stock stock);
	// 월 재고리스트 조회
	List<Stock> getListStock(Stock stock);
	
	
	/********************************************/
		/* 기초재고조사 등록 */
	
	
	// 신제품 등록여부 확인
	Product checkExistenceNewItem(Product product);
	
	// 신제품 기초재고 등록
	int registStockNewItem(Stock stock);
	
	// 신제품 수불마감 등록
	int registRnPClosingNewItem(Stock stock);
	
	// 실사 재고조사 물품 상세정보 조회
	Product getDataProduct(Product product);


	
	/********************************************/
		/* 실사 재고조사 등록 */

	
	
	/********************************************/
		/* 수불 일일내역 조회 */
	
	// 수불 일일내역1 total수 조회 (구매)
	int getTotalRnPCondBuy(RnP_closing rnpc);
	// 수불 일일내역1 리스트 조회 (구매)
	List<RnP_closing> getListRnPCondBuy(RnP_closing rnpc);
		
	// 수불 일일내역2 total수 조회 (판매)
	int getTotalRnPCondSale(RnP_closing rnpc);
	// 수불 일일내역2 리스트 조회 (판매)
	List<RnP_closing> getListRnPCondSale(RnP_closing rnpc);
	
	// 수불 일일내역3 total수 조회 (생산)
	int getTotalRnPCondMake(RnP_closing rnpc);
	// 수불 일일내역3 리스트 조회 (생산)
	List<RnP_closing> getListRnPCondMake(RnP_closing rnpc);
	
	// 수불 일일내역4 total수 조회 (재고조사)
	int getTotalRnPCondSurvey(RnP_closing rnpc);
	// 수불 일일내역4 리스트 조회 (재고조사)
	List<RnP_closing> getListRnPCondSurvey(RnP_closing rnpc);

	
}
