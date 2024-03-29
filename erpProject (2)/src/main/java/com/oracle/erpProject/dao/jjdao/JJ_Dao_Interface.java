package com.oracle.erpProject.dao.jjdao;

import java.util.List;

import com.oracle.erpProject.model.Work_order_detail;

public interface JJ_Dao_Interface {

	int cntMake();
	List<Work_order_detail> makeList(Work_order_detail wod);

}
