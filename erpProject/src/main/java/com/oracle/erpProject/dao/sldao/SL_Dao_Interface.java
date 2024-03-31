package com.oracle.erpProject.dao.sldao;

import java.util.List;

import com.oracle.erpProject.model.Buying;

public interface SL_Dao_Interface {

	int totalbuyingCnt();

	List<Buying> buyAlllist(Buying buying);

}
