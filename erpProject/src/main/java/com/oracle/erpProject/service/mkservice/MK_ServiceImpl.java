package com.oracle.erpProject.service.mkservice;

import java.util.List;

import org.springframework.stereotype.Service;


import com.oracle.erpProject.dao.mkdao.MK_Dao_Interface;
import com.oracle.erpProject.model.mkmodel.mkProduct;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MK_ServiceImpl implements MK_Service_interface {
	
	private final MK_Dao_Interface mk_Dao_Interface;
	
	@Override
	public List<mkProduct> listProduct(mkProduct product) {
		List<mkProduct> productList = null;
		System.out.println("MKServiceImpl productList Start");
		productList = mk_Dao_Interface.productList(product);
		System.out.println("product->"+productList);
		return productList;
	}

	@Override
	public mkProduct getProductDetail(mkProduct product) {
		System.out.println("MKServiceImpl getProductDetail Start"); 
		System.out.println("MKServiceImpl getProductDetail->"+product);
		mkProduct productDetail = null;
		productDetail=mk_Dao_Interface.productDetail(product);
		return productDetail;
	}

	//페이징을 위한 product count
	
	@Override
	public int totalProduct(mkProduct product) {
		System.out.println("MKServiceImpl start totalProduct");
		int totProductCnt=mk_Dao_Interface.totalProduct(product);
		System.out.println("MK_servieImpl totalProductCnt->"+totProductCnt);
		return totProductCnt;
	}

	// 제품 등록 
	@Override
	public int insertProduct(mkProduct product) {
		int result=0;
		System.out.println("MKServiceImpl insertProduct Start");
		result = mk_Dao_Interface.insertProduct(product);
		return result;
	}

	

	 

}
