package com.oracle.erpProject.service.slservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.erpProject.dao.sldao.SL_Dao_Interface;
import com.oracle.erpProject.model.Buying;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SL_ServiceImpl implements SL_Service_Interface {
	
	private final SL_Dao_Interface slDao;

	@Override
	public int totalbuyingCnt() {
		int totalbuyingCnt = slDao.totalbuyingCnt();
		return totalbuyingCnt;
	}

	@Override
	public List<Buying> buyAlllist(Buying buying) {
		List<Buying> buyAlllist = slDao.buyAlllist(buying);
		return buyAlllist;
	}
	
}
