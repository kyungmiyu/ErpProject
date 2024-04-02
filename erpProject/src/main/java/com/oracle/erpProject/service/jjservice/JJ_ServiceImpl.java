package com.oracle.erpProject.service.jjservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.erpProject.dao.jjdao.JJ_Dao_Interface;
import com.oracle.erpProject.model.jjmodel.JJ_Make_detail;

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
	public List<JJ_Make_detail> makeList(JJ_Make_detail md) {
		List<JJ_Make_detail> makeList = null;
		System.out.println("JJ_ServiceImpl's makeList Go!");
		makeList = jjDao.makeList(md);
		System.out.println("JJ_ServiceImpl's makeList -> " + makeList);
		return makeList;
	}

	@Override
	public List<JJ_Make_detail> requestMakeList() {
		List<JJ_Make_detail> requestMakeList = null;
		System.out.println("JJ_ServiceImpl's requestMakeList Go!");
		requestMakeList = jjDao.requestMakeList();
		System.out.println("JJ_ServiceImpl's requestMakeList.size() ->" + requestMakeList.size());
		return requestMakeList;
	}

	@Override
	public int makeRequest(JJ_Make_detail md) {
		int makeRequest = 0;
		System.out.println("JJ_ServiceImpl's makeRequest Go!");
		makeRequest = jjDao.makeRequest(md);
		System.out.println("JJ_ServiceImpl's makeRequest -> " + makeRequest);
		return makeRequest;
	}

	// 생산 상세 페이지
	@Override
	public JJ_Make_detail jjmakeDetail(int m_num) {
		System.out.println("JJ_ServiceImpl's jjmakeDetail Go!");
		JJ_Make_detail jjmakeDetail = null;
		jjmakeDetail = jjDao.jjmakeDetail(m_num);
		System.out.println("JJ_ServiceImpl's jjmakeDetail -> " + jjmakeDetail);
		return jjmakeDetail;
	}
}
