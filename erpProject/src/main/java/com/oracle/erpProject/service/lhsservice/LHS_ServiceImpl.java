package com.oracle.erpProject.service.lhsservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.erpProject.dao.lhsdao.LHS_Dao;
import com.oracle.erpProject.model.lhsmodel.Employee;
import com.oracle.erpProject.model.lhsmodel.Product;
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
		System.out.println("lhsServiceImpl getListEmp start...");
		
		listEmp = lhs.getListEmp();
		return listEmp;
	}

	// 사원정보 조회
	@Override
	public Employee getDataEmp(int emp_no) {
		Employee empData = null;
		System.out.println("lhsServiceImpl getDataEmp start...");
		
		empData = lhs.getDataEmp(emp_no);
		return empData;
	}

	// 월 재고 total수 조회
	@Override
	public int getTotalStock(Stock stock) {
		int totalStock = 0;
		System.out.println("lhsServiceImpl getTotalStock start...");
		
		totalStock = lhs.getTotalStock(stock);
		return totalStock;
	}
	
	// 월 재고리스트 조회
	@Override
	public List<Stock> getListStock(Stock stock) {
		List<Stock> listStock = null;
		System.out.println("lhsServiceImpl getListStock start...");
		
		listStock = lhs.getListStock(stock);
		return listStock;
	}

	// 신제품 구매테이블 조회
	@Override
	public Product checkProductBuy(Product product) {
		Product checkProduct = null;
		System.out.println("lhsServiceImpl checkProductBuy start...");
		
		checkProduct = lhs.checkProductBuy(product);
		return checkProduct;
	}

	// 신제품 생산테이블 조회
	@Override
	public Product checkProductMake(Product product) {
		Product checkProduct = null;
		System.out.println("lhsServiceImpl checkProductMake start...");
		
		checkProduct = lhs.checkProductMake(product);
		return checkProduct;
	}


}
