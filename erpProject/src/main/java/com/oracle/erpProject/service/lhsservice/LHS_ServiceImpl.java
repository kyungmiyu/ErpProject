package com.oracle.erpProject.service.lhsservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.erpProject.dao.lhsdao.LHS_Dao;
import com.oracle.erpProject.model.lhsmodel.Employee;
import com.oracle.erpProject.model.lhsmodel.Product;
import com.oracle.erpProject.model.lhsmodel.RnP_closing;
import com.oracle.erpProject.model.lhsmodel.Stock;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LHS_ServiceImpl implements LHS_Serivce {
	 
	private final LHS_Dao lhs;
 
	// 테스트용 사원리스트 조회
	@Override
	public List<Employee> getListEmp() {
		List<Employee> listEmp = null;
		listEmp = lhs.getListEmp();
		return listEmp;
	}

	
	/****************************************************************************/
		/* 공통 */
	
	
	// 사원정보 조회
	@Override
	public Employee getDataEmp(int emp_no) {
		Employee empData = null;
		empData = lhs.getDataEmp(emp_no);
		return empData;
	}
	
	
	/****************************************************************************/
		/* 월 재고조회 */

	
	// 월 재고 total수 조회
	@Override
	public int getTotalStock(Stock stock) {
		int totalStock = 0;
		totalStock = lhs.getTotalStock(stock);
		return totalStock;
	}
	
	// 월 재고리스트 조회
	@Override
	public List<Stock> getListStock(Stock stock) {
		List<Stock> listStock = null;
		listStock = lhs.getListStock(stock);
		return listStock;
	}

	
	/****************************************************************************/
		/* 기초재고조사 등록 */
	
	
	// 신제품 등록여부 확인 
	@Override
	public Product checkExistenceNewItem(Product product) {
		Product checkProduct = null;
		checkProduct = lhs.checkExistenceNewItem(product);
		return checkProduct;
	}
	

	// 신제품 기초재고 등록
	@Override
	public int registStockNewItem(Stock stock) {
		int resultRegist = 0;
		resultRegist = lhs.registStockNewItem(stock);
		return resultRegist;
	}
	
	// 신제품 수불마감 등록
	@Override
	public int registRnPClosingNewItem(Stock stock) {
		int resultRegist = 0;
		resultRegist = lhs.registRnPClosingNewItem(stock);
		return resultRegist;
	}
	
	
	/****************************************************************************/
		/* 실사 재고조사 등록 */

	
	// 실사 재고조사 물품 상세정보 조회
	@Override
	public Product getDataProduct(Product product) {
		Product productData = null;
		productData = lhs.getDataProduct(product);
		return productData;
	}



	
	/****************************************************************************/
		/* 수불 일일내역 조회 */

	
	// 수불 일일내역1 total수 조회 (구매)
	@Override
	public int getTotalRnPCondBuy(RnP_closing rnpc) {
		int totalRnPClosing = 0;
		totalRnPClosing = lhs.getTotalRnPCondBuy(rnpc);
		return totalRnPClosing;
	}

	
	// 수불 일일내역1 리스트 조회 (구매)
	@Override
	public List<RnP_closing> getListRnPCondBuy(RnP_closing rnpc) {
		List<RnP_closing> listRnPClosing = null;
		listRnPClosing = lhs.getListRnPCondBuy(rnpc);
		return listRnPClosing;
	}
	
	// 수불 일일내역2 total수 조회 (판매)
	@Override
	public int getTotalRnPCondSale(RnP_closing rnpc) {
		int totalRnPClosing = 0;
		totalRnPClosing = lhs.getTotalRnPCondSale(rnpc);
		return totalRnPClosing;
	}
	
	
	// 수불 일일내역2 리스트 조회 (판매)
	@Override
	public List<RnP_closing> getListRnPCondSale(RnP_closing rnpc) {
		List<RnP_closing> listRnPClosing = null;
		listRnPClosing = lhs.getListRnPCondSale(rnpc);
		return listRnPClosing;
	}

	// 수불 일일내역3 total수 조회 (생산)
	@Override
	public int getTotalRnPCondMake(RnP_closing rnpc) {
		int totalRnPClosing = 0;
		totalRnPClosing = lhs.getTotalRnPCondMake(rnpc);
		return totalRnPClosing;
	}
	
	// 수불 일일내역3 리스트 조회 (생산)
	@Override
	public List<RnP_closing> getListRnPCondMake(RnP_closing rnpc) {
		List<RnP_closing> listRnPClosing = null;
		listRnPClosing = lhs.getListRnPCondMake(rnpc);
		return listRnPClosing;
	}
	
	// 수불 일일내역4 total수 조회 (재고조사)
	@Override
	public int getTotalRnPCondSurvey(RnP_closing rnpc) {
		int totalRnPClosing = 0;
		totalRnPClosing = lhs.getTotalRnPCondSurvey(rnpc);
		return totalRnPClosing;
	}

	// 수불 일일내역4 리스트 조회 (재고조사)
	@Override
	public List<RnP_closing> getListRnPCondSurvey(RnP_closing rnpc) {
		List<RnP_closing> listRnPClosing = null;
		listRnPClosing = lhs.getListRnPCondSurvey(rnpc);
		return listRnPClosing;
	}


}
