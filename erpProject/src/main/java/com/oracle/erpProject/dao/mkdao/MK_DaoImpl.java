package com.oracle.erpProject.dao.mkdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.model.Product;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MK_DaoImpl implements MK_Dao_Interface {
	//Mybatis DB 연동 
	
	private final SqlSession session;
	
	// 제품 리스트 
	
	@Override
	public List<Product> productList(Product product) {
	
		List<Product> productList = null;
		System.out.println("MK_Dao_Impl productList start...");
		
		try {
			productList=session.selectList("productList", product);
			System.out.println("MKDaoImpl productList product.size()->"+productList.size());
		}catch (Exception e) {
			System.out.println("MKDaoImpl productList e.getMessage()->"+e.getMessage());
		}
		return productList;
	}

	// 제품 상세 
	@Override
	public Product productDetail(Product product) {
		
		Product productDetail = null;
	
		System.out.println("MK_DAO_IMPL productDetail Start  ");
		System.out.println("MK_DAO_IMPL productDetail->"+ product);
		try { 
			productDetail = session.selectOne("productDetail",product);
			System.out.println("MKDaoImpl productDetail ProductDetail.size->"+productDetail);
		}catch (Exception e) {
			System.out.println("MKDaoImpl productDetail e.getMessage()->"+e.getMessage());
		}
		return productDetail;
	}

}
