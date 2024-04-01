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
		System.out.println("SL_ServiceImpl buyAlllist Start ->>>>>>");
		List<Buying> buyAlllist = slDao.buyAlllist(buying);
		System.out.println("SL_ServiceImpl buyAlllist buyAlllist ->>>>>>" + buyAlllist);
		return buyAlllist;
	}

	// 날짜 검색
	@Override
	public int dateSearchtotCnt(Buying buying) {
		System.out.println("SL_ServiceImpl dateSearchtotCnt Start ->>>>>>");
		
		int dateSearchtotCnt = slDao.dateSearchtotCnt(buying);
		return dateSearchtotCnt;
	}
	

	@Override
	public List<Buying> dateSearchAllList(Buying buying) {
		System.out.println("SL_ServiceImpl dateSearchAllList Start ->>>>>>");
		List<Buying> dateSearchAllList = slDao.dateSearchAllList(buying);
		
		System.out.println("SL_ServiceImpl dateSearchAllList  ->>>>>>" + dateSearchAllList);
		
		return dateSearchAllList;
	}
	
}
