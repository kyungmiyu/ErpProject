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
		
		System.out.println("check day: " + stock.getSt_year_month());
		try {
			listStock = session.selectList("lhsGetListStock", stock);
			System.out.println("lhsDaoImpl getListStock listStock.size()-> " + listStock.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStock;
	}


	// 신제품 등록여부 확인
	@Override
	public Product checkExistenceNewItem(Product product) {
		Product checkProduct = null;
		Stock checkStock = null;
		System.out.println("lhsDaoImpl checkExistenceNewItem start...");
		
		try {
			checkProduct = session.selectOne("lhsCheckExistenceNewItem", product);
			checkStock = session.selectOne("lhsCheckExistenceStock", product);
			
			if (checkStock != null) {
				checkProduct.setP_name("no");
			}
			
			System.out.println("lhsDaoImpl checkExistenceNewItem checkProduct-> "+ checkProduct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkProduct;
	}

	// 신제품 기초재고 등록
	@Override
	public int registStockNewItem(Stock stock) {
		int registResult = 0;
		System.out.println("lhsDaoImpl registStockNewItem start...");
		
		try {
			registResult = session.insert("lhsRegistStockNewItem", stock);
			System.out.println("lhsDaoImpl registStockNewItem registResult-> " + registResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registResult;
	}

	// 실사 재고조사 물품 상세정보 조회
	@Override
	public Product getDataProduct(Product product) {
		Product productData = null;
		System.out.println("lhsDaoImpl getDataProduct start...");
		
		try {
			productData = session.selectOne("lhsGetDataProduct", product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productData;
	}
	


}
