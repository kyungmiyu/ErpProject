package com.oracle.erpProject.dao.jjdao;

import java.util.List;

import com.oracle.erpProject.model.Make_detail;

public interface JJ_Dao_Interface {

	int cntMake();
	List<Make_detail> makeList(Make_detail wod);

}
