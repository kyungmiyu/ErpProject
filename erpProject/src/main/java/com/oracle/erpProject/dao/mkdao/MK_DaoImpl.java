package com.oracle.erpProject.dao.mkdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.model.mkmodel.mkProduct;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MK_DaoImpl implements MK_Dao_Interface {
	//Mybatis DB 연동 
	
	private final SqlSession session;
	
	// 제품 리스트 
	
	@Override
	public List<mkProduct> productList(mkProduct product) {
	
		List<mkProduct> productList = null;
		System.out.println("MK_Dao_Impl productList start...");
		
		try {
			productList=session.selectList("mkproductList", product);
			System.out.println("MKDaoImpl productList product.size()->"+productList.size());
		}catch (Exception e) {
			System.out.println("MKDaoImpl productList e.getMessage()->"+e.getMessage());
		}
		return productList;
	}

	// 제품 상세 
	@Override
	public mkProduct productDetail(mkProduct product) {
		
		mkProduct productDetail = null;
	
		System.out.println("MK_DAO_IMPL productDetail Start  ");
		System.out.println("MK_DAO_IMPL productDetail->"+ product);
		try { 
			productDetail = session.selectOne("mkproductDetail",product);
			System.out.println("MKDaoImpl productDetail ProductDetail->"+productDetail);
		}catch (Exception e) {
			System.out.println("MKDaoImpl productDetail e.getMessage()->"+e.getMessage());
		}
		return productDetail;
	}

	@Override
	public int totalProduct(mkProduct product) {
		int totProductCount=0;
		System.out.println("MK_DaoImpl Start totalProductCount");
		
		try { 
			totProductCount=session.selectOne("mktotProduct");
			System.out.println("MK_DaoImpl total Product Count->"+totProductCount);
			System.out.println("insert 성공");
		} catch (Exception e) {
			System.out.println("MK_DaoImpl total Product Exception->"+e.getMessage());
		}
		return totProductCount;
	}

	@Override
	public int insertProduct(mkProduct product) {
		int insertResult=0;
		System.out.println("MkDaoImpl insert Produt Start");
		System.out.println("MK_DaoImpl mkinsertProduct ->" +product);
		try {
			insertResult = session.insert("mkinsertProduct",product);
		}catch (Exception e) {
			System.out.println("MkDaoImpl insertProduct Exception->"+e.getMessage());
		}
		return insertResult;
	}

	@Override
	public int searchedProductTotal(mkProduct product) {
		int totProductCount=0;
		System.out.println("MKDaoImpl start searchedProductTotal Start");
		System.out.println("MK DaoImpl Start mkProduct->"+product);
		
		try {
			totProductCount = session.selectOne("searchedProductTotal",product);
			System.out.println("MKServiceImpl totalsearchedProduct -> " + totProductCount);
		} catch (Exception e) {
			System.out.println("MKServiceImpl totProductCount Exception->"+e.getMessage());
		}
		return totProductCount;
	}

	@Override
	public List<mkProduct> productSearchList(mkProduct product) {
		List<mkProduct> productSearchList = null;
		System.out.println("MKDaoImpl start productSearchList start");
		System.out.println("MKDaoImpl Start product->"+product);
		try { 
			productSearchList= session.selectList("productSearchList",product);
			
		}catch (Exception e) {
			System.out.println("MKDaoImpl productSearchList exception->"+ e.getMessage());
		}
		return productSearchList;
	}

	/*
	 * @Override public void saveProductImagePath(mkProduct product) {
	 * 
	 * System.out.println("MkDaoImpl saveProductImagePath Start");
	 * System.out.println("MK_DaoImpl saveProductImagePath ->" +product); try {
	 * session.insert("saveProductImagePath",product); }catch (Exception e) {
	 * System.out.println("MkDaoImpl saveProductImagePath Exception->"+e.getMessage(
	 * )); }
	 * 
	 * }
	 */
		
	}


