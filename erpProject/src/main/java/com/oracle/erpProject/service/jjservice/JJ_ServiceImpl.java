package com.oracle.erpProject.service.jjservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.erpProject.dao.jjdao.JJ_Dao_Interface;
import com.oracle.erpProject.model.Work_order_detail;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JJ_ServiceImpl implements JJ_Service_Interface {

	private final JJ_Dao_Interface jjDao;

	@Override
	public int cntMake() {
		System.out.println("JJ_ServiceImpl's cntMake Go!");
		int cntMake = jjDao.cntMake();
		System.out.println("JJ_ServiceImpl's cntMake ->" + cntMake);
		return cntMake;
	}

	@Override
	public List<Work_order_detail> makeList(Work_order_detail wod) {
		List<Work_order_detail> makeList = null;
		System.out.println("JJ_ServiceImpl's makeList Go!");
		makeList = jjDao.makeList(wod);
		System.out.println("JJ_ServiceImpl's makeList -> " + makeList);
		return makeList;
	}
}
