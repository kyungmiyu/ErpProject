package com.oracle.erpProject.service.mkservice;

import java.util.List;

import com.oracle.erpProject.model.mkmodel.mkFactory;
import com.oracle.erpProject.model.mkmodel.mkProduct;

public interface MK_Service_interface {

	List<mkProduct> listProduct(mkProduct product);

	mkProduct getProductDetail(mkProduct product);

	int totalProduct(mkProduct product);

	int insertProduct(mkProduct product);

	int searchedProductTotal(mkProduct product);

	List<mkProduct> listSearchProduct(mkProduct product);

	int UpdataProduct(mkProduct product);

	int totalFactory(mkFactory factory);

	List<mkFactory> listFactory(mkFactory factory);

	mkFactory factoryDetail(mkFactory factory);

//	void saveProductImagePath(mkProduct product);





}
