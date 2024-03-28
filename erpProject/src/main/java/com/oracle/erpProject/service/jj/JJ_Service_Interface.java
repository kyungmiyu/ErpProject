package com.oracle.erpProject.service.jj;

import java.util.List;

import com.oracle.erpProject.model.Work_order_detail;

public interface JJ_Service_Interface {

	int cntMake();
	List<Work_order_detail> makeList(Work_order_detail wod);

}
