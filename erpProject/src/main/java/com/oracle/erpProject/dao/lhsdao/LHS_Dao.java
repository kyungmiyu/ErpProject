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

	// 신제품 등록여부 확인
	Product checkExistenceNewItem(Product product);

	// 신제품 기초재고 등록
	int registStockNewItem(Stock stock);

	// 실사 재고조사 물품 상세정보 조회
	Product getDataProduct(Product product);



}
