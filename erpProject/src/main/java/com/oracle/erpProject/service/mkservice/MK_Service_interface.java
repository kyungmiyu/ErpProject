package com.oracle.erpProject.service.mkservice;

import java.util.List;

import com.oracle.erpProject.model.mkmodel.mkProduct;

public interface MK_Service_interface {

	List<mkProduct> listProduct(mkProduct product);

	mkProduct getProductDetail(mkProduct product);

	int totalProduct(mkProduct product);

	int insertProduct(mkProduct product);

	int searchedProductTotal(mkProduct product);

	List<mkProduct> listSearchProduct(mkProduct product);

//	void saveProductImagePath(mkProduct product);





}
