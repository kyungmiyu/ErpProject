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

	// 신제품 등록여부 확인 
	@Override
	public Product checkExistenceNewItem(Product product) {
		Product checkProduct = null;
		System.out.println("lhsServiceImpl checkExistenceNewItem start...");
		checkProduct = lhs.checkExistenceNewItem(product);
		return checkProduct;
	}
	

	// 신제품 기초재고 등록
	@Override
	public int registStockNewItem(Stock stock) {
		int registResult = 0;
		System.out.println("lhsServiceImpl registStockNewItem start...");
		registResult = lhs.registStockNewItem(stock);
		return registResult;
	}

	// 실사 재고조사 물품 상세정보 조회
	@Override
	public Product getDataProduct(Product product) {
		Product productData = null;
		System.out.println("lhsServiceImpl getDataProduct start...");
		productData = lhs.getDataProduct(product);
		return productData;
	}



}
