package com.oracle.erpProject.service.mkservice;

import java.util.List;

import com.oracle.erpProject.model.mkmodel.Product;

public interface MK_Service_interface {

	List<Product> listProduct(Product product);

	Product getProductDetail(Product product);

}
