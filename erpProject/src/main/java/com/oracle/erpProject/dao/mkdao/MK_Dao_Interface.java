package com.oracle.erpProject.dao.mkdao;

import java.util.List;

import com.oracle.erpProject.model.mkmodel.mkProduct;

public interface MK_Dao_Interface {

	List<mkProduct> productList(mkProduct product);

	mkProduct productDetail(mkProduct product);

	int totalProduct(mkProduct product);

	int insertProduct(mkProduct product);

	int searchedProductTotal(mkProduct product);

	List<mkProduct> productSearchList(mkProduct product);

	int UpdataProduct(mkProduct product);

//	void saveProductImagePath(mkProduct product);

}
