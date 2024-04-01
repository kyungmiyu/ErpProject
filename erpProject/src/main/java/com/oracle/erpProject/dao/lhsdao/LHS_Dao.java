package com.oracle.erpProject.dao.lhsdao;

import java.util.List;

import com.oracle.erpProject.model.lhsmodel.Employee;
import com.oracle.erpProject.model.lhsmodel.Product;
import com.oracle.erpProject.model.lhsmodel.Stock;



public interface LHS_Dao {

	// 테스트용 사원리스트 조회
	List<Employee> getListEmp();

	// 사원정보 조회
	Employee getDataEmp(int emp_no);

	// 월 재고 total수 조회
	int getTotalStock(Stock stock);
	
	// 월 재고리스트 조회
	List<Stock> getListStock(Stock stock);

	// 신제품 구매테이블 조회
	Product checkProductBuy(Product product);

	// 신제품 생산테이블 조회
	Product checkProductMake(Product product);


}
