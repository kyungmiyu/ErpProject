package com.oracle.erpProject.service.slservice;

import java.util.List;

import com.oracle.erpProject.model.Buying;

public interface SL_Service_Interface {

	int totalbuyingCnt();

	List<Buying> buyAlllist(Buying buying);

}