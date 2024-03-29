package com.oracle.erpProject.dao.mkdao;

import java.util.List;

import com.oracle.erpProject.model.Product;

public interface MK_Dao_Interface {

	List<Product> productList(Product product);

	Product productDetail(Product product);

}
