package com.oracle.erpProject.dao.mkdao;

import java.util.List;

import com.oracle.erpProject.model.mkmodel.mkProduct;

public interface MK_Dao_Interface {

	List<mkProduct> productList(mkProduct product);

	mkProduct productDetail(mkProduct product);

}
