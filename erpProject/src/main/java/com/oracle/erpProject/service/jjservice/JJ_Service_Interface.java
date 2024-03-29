package com.oracle.erpProject.service.jjservice;

import java.util.List;

import com.oracle.erpProject.model.Make_detail;
import com.oracle.erpProject.model.jjmodel.JJ_Make_detail;

public interface JJ_Service_Interface {

	int 					cntMake();
	List<JJ_Make_detail> 	makeList(JJ_Make_detail md);
	List<JJ_Make_detail> 	requestMakeList();

}
