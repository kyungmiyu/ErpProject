package com.oracle.erpProject.dao.lhsdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.model.lhsmodel.Employee;
import com.oracle.erpProject.model.lhsmodel.Product;
import com.oracle.erpProject.model.lhsmodel.Stock;

import lombok.RequiredArgsConstructor;
 
@Repository
@RequiredArgsConstructor
public class LHS_DaoImpl implements LHS_Dao {
	
	private final SqlSession session;
 
	// 테스트용 사원리스트 조회
	@Override
	public List<Employee> getListEmp() {
		List<Employee> listEmp = null;
		System.out.println("lhsDaoImpl getListEmp start...");
		
		try {
			// 쿼리문 미완성 -> model dept_name 추가 + dept와 쿼리해서 dept_name까지 select하기
			listEmp = session.selectList("lhsGetListEmp");
			System.out.println("lhsDaoImpl getListEmp listEmp.size()-> " + listEmp.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listEmp;
	}

	// 사원정보 조회
	@Override
	public Employee getDataEmp(int emp_no) {
		Employee empData = null;
		System.out.println("lhsDaoImpl getDataEmp start...");
		
		try {
			empData = session.selectOne("lhsGetDataEmp", emp_no);
			System.out.println("lhsDaoImpl getDataEmp empData.emp_name-> " + empData.getEmp_name());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empData; 
	}
	
	// 월 재고 total수 조회
	@Override
	public int getTotalStock(Stock stock) {
		int totalStock = 0;
		System.out.println("lhsDaoImpl getTotalStock start...");
		
		try {
			totalStock = session.selectOne("lhsGetTotalStock", stock);
			System.out.println("lhsDaoImpl getTotalStock totalStock-> " + totalStock);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalStock;
	}

	// 월 재고리스트 조회
	@Override
	public List<Stock> getListStock(Stock stock) {
		List<Stock> listStock = null;
		System.out.println("lhsDaoImpl getListStock start...");
		
		try {
			listStock = session.selectList("lhsGetListStock", stock);
			System.out.println("lhsDaoImpl getListStock listStock.size()-> " + listStock.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStock;
	}

	// 신제품 구매테이블 조회
	@Override
	public Product checkProductBuy(Product product) {
		Product checkProduct = null;
		System.out.println("lhsDaoImpl checkProductBuy start...");
		
		try {
			checkProduct = session.selectOne("lhsCheckProductBuy", product);
			System.out.println("lhsDaoImpl checkProductBuy checkProduct-> "+ checkProduct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return checkProduct;
	}

	// 신제품 생산테이블 조회
	@Override
	public Product checkProductMake(Product product) {
		Product checkProduct = null;
		System.out.println("lhsDaoImpl checkProductMake start...");
		
		try {
			checkProduct = session.selectOne("lhsCheckProductMake", product);
			System.out.println("lhsDaoImpl checkProductMake checkProduct-> "+ checkProduct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return checkProduct;
	}
	
	


}
