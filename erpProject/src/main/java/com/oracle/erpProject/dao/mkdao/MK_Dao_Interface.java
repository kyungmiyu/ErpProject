package com.oracle.erpProject.dao.mkdao;

import java.util.List;

import com.oracle.erpProject.model.mkmodel.MK_Product;

public interface MK_Dao_Interface {

	List<MK_Product> productList(MK_Product product);

	MK_Product productDetail(MK_Product product);

}
