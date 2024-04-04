package com.oracle.erpProject.dao.lhsdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.oracle.erpProject.model.lhsmodel.Employee;
import com.oracle.erpProject.model.lhsmodel.Product;
import com.oracle.erpProject.model.lhsmodel.RnP_closing;
import com.oracle.erpProject.model.lhsmodel.Stock;

import lombok.RequiredArgsConstructor;
 
@Repository
@RequiredArgsConstructor
public class LHS_DaoImpl implements LHS_Dao {
	
	private final SqlSession session;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
 
	// 테스트용 사원리스트 조회
	@Override
	public List<Employee> getListEmp() {
		List<Employee> listEmp = null;
		
		try {
			// 쿼리문 미완성 -> model dept_name 추가 + dept와 쿼리해서 dept_name까지 select하기
			listEmp = session.selectList("lhsGetListEmp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listEmp;
	}
	
	
	/****************************************************************************/
		/* 공통 */

	
	// 사원정보 조회
	@Override
	public Employee getDataEmp(int emp_no) {
		Employee empData = null;
		
		try {
			empData = session.selectOne("lhsGetDataEmp", emp_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empData; 
	}
	
	
	/****************************************************************************/
		/* 월 재고조회 */
	
	
	// 월 재고 total수 조회
	@Override
	public int getTotalStock(Stock stock) {
		int totalStock = 0;
		
		try {
			totalStock = session.selectOne("lhsGetTotalStock", stock);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalStock;
	}

	// 월 재고리스트 조회
	@Override
	public List<Stock> getListStock(Stock stock) {
		List<Stock> listStock = null;
		
		try {
			listStock = session.selectList("lhsGetListStock", stock);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStock;
	}

	
	/****************************************************************************/
		/* 기초재고조사 등록 */
	
	
	// 신제품 등록여부 확인
	@Override
	public Product checkExistenceNewItem(Product product) {
		Product checkProduct = null;
		Stock checkStock = null;
		
		try {
			checkProduct = session.selectOne("lhsCheckExistenceNewItem", product);
			checkStock = session.selectOne("lhsCheckExistenceStock", product);
			
			if (checkStock != null) {
				checkProduct.setP_name("already");
			}
			
		} catch (NullPointerException npe) {
			System.out.println("등록되지 않은 제품입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkProduct;
	}

	// 신제품 기초재고 등록
	@Override
	public int registStockNewItem(Stock stock) {
		int resultRegist = 0;
		
		try {
			resultRegist = session.insert("lhsRegistStockNewItem", stock);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultRegist;
	}
	
	// 신제품 수불마감 등록
	@Override
	public int registRnPClosingNewItem(Stock stock) {
		int resultRegist = 0;
		
		try {
			resultRegist = session.insert("lhsRegistRnPClosingNewItem", stock);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return resultRegist;
	}

	
	/****************************************************************************/
		/* 실사 재고조사 등록 */
	
	
	// 실사 재고조사 물품 상세정보 조회
	@Override
	public Product getDataProduct(Product product) {
		Product productData = null;
		
		try {
			productData = session.selectOne("lhsGetDataProduct", product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productData;
	}



	/****************************************************************************/
		/* 수불 일일내역 조회 */
	
	
		// 수불 일일내역1 total수 조회 (구매)
		@Override
		public int getTotalRnPCondBuy(RnP_closing rnpc) {
			int totalRnPClosing = 0;
			
			try {
				totalRnPClosing = session.selectOne("lhsGetTotalRnPCondBuy", rnpc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return totalRnPClosing;
		}

		// 수불 일일내역1 리스트 조회 (구매)
		@Override
		public List<RnP_closing> getListRnPCondBuy(RnP_closing rnpc) {
			List<RnP_closing> listRnPClosing = null;
			
			try {
				listRnPClosing = session.selectList("lhsGetListRnpCondBuy", rnpc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return listRnPClosing;
		}
		
		
		// 수불 일일내역2 total수 조회 (판매)
		@Override
		public int getTotalRnPCondSale(RnP_closing rnpc) {
			int totalRnPClosing = 0;
			
			try {
				totalRnPClosing = session.selectOne("lhsGetTotalRnPCondSale", rnpc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return totalRnPClosing;
		}
		
		// 수불 일일내역2 리스트 조회 (판매)
		@Override
		public List<RnP_closing> getListRnPCondSale(RnP_closing rnpc) {
			List<RnP_closing> listRnPClosing = null;
			
			try {
				listRnPClosing = session.selectList("lhsGetListRnPCondSale", rnpc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return listRnPClosing;
		}
		
		
		// 수불 일일내역3 total수 조회 (생산)
		@Override
		public int getTotalRnPCondMake(RnP_closing rnpc) {
			int totalRnPClosing = 0;
			
			try {
				totalRnPClosing = session.selectOne("lhsGetTotalRnPCondMake", rnpc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return totalRnPClosing;
		}
		
		// 수불 일일내역3 리스트 조회 (생산)
		@Override
		public List<RnP_closing> getListRnPCondMake(RnP_closing rnpc) {
			List<RnP_closing> listRnPClosing = null;
			
			try {
				listRnPClosing = session.selectList("lhsGetListRnPCondMake", rnpc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return listRnPClosing;
		}

		
		// 수불 일일내역4 total수 조회 (재고조사)
		@Override
		public int getTotalRnPCondSurvey(RnP_closing rnpc) {
			int totalRnPClosing = 0;
			
			try {
				totalRnPClosing = session.selectOne("lhsGetTotalRnPCondSurvey", rnpc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return totalRnPClosing;
		}
		
		// 수불 일일내역4 리스트 조회 (재고조사)
		@Override
		public List<RnP_closing> getListRnPCondSurvey(RnP_closing rnpc) {
			List<RnP_closing> listRnPClosing = null;
			
			try {
				listRnPClosing = session.selectList("lhsGetListRnPCondSurvey", rnpc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return listRnPClosing;
		}



}
