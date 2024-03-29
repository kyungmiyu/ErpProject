package com.oracle.erpProject.service.jjservice;

import java.util.List;

import com.oracle.erpProject.model.Make_detail;

public interface JJ_Service_Interface {

	int cntMake();
	List<Make_detail> makeList(Make_detail wod);

}
