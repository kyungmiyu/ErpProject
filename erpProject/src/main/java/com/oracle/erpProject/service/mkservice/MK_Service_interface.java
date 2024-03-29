package com.oracle.erpProject.service.mkservice;

import java.util.List;

import com.oracle.erpProject.model.mkmodel.MK_Product;

public interface MK_Service_interface {

	List<MK_Product> listProduct(MK_Product product);

	MK_Product getProductDetail(MK_Product product);

}
