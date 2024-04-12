package com.oracle.erpProject.service.jjservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.erpProject.dao.jjdao.JJ_Dao_Interface;
import com.oracle.erpProject.model.jjmodel.JJ_Make;
import com.oracle.erpProject.model.jjmodel.JJ_Make_detail;
import com.oracle.erpProject.model.mkmodel.mkProduct;

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
	public List<JJ_Make_detail> makedetailList(JJ_Make_detail md) {
		List<JJ_Make_detail> makedetailList = null;
		System.out.println("JJ_ServiceImpl's makedetailList Go!");
		makedetailList = jjDao.makedetailList(md);
		System.out.println("JJ_ServiceImpl's makedetailList -> " + makedetailList);
		return makedetailList;
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
	public int makeRequest1(JJ_Make m) {
		int makeRequest1 = 0;
		System.out.println("JJ_ServiceImpl's makeRequest1 Go!");
		makeRequest1 = jjDao.makeRequest1(m);
		System.out.println("JJ_ServiceImpl's makeRequest1 -> " + makeRequest1);
		return makeRequest1;
	}
	
	@Override
	public int makeRequest2(JJ_Make_detail md) {
		int makeRequest2 = 0;
		System.out.println("JJ_ServiceImpl's makeRequest2 Go!");
		makeRequest2 = jjDao.makeRequest2(md);
		System.out.println("JJ_ServiceImpl's makeRequest2 -> " + makeRequest2);
		return makeRequest2;
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

	@Override
	public int makeSearchCnt(JJ_Make_detail md) {
		System.out.println("JJ_ServiceImpl's makeSearchCnt Go!");
		int makeSearchCnt = jjDao.makeSearchCnt(md);
		return makeSearchCnt;
	}

	@Override
	public List<JJ_Make_detail> makeSearchList(JJ_Make_detail md) {
		List<JJ_Make_detail> makeSearchList = null;
		System.out.println("JJ_ServiceImpl's makeSearchList Go!");
		makeSearchList = jjDao.makeSearchList(md);
		System.out.println("JJ_ServiceImpl's makeSearchList.size() -> " + makeSearchList.size());
		return makeSearchList;
	}

	// 삭제 기능
	@Override
	public int jjmakeDelete(int m_num) {
		int jjmakeDelete = 0;
		System.out.println("JJ_ServiceImpl's jjmakeDelete Go!");
		jjmakeDelete = jjDao.jjmakeDelete(m_num);
		return jjmakeDelete;
	}

	@Override
	public List<mkProduct> jjproductList(mkProduct mp) {
		List<mkProduct> jjproductList = null;
		System.out.println("JJ_ServiceImpl's jjproductList Go!");
		jjproductList = jjDao.jjproductList(mp);
		System.out.println("JJ_ServiceImpl's jjproductList.size() -> " + jjproductList.size());
		return jjproductList;
	}


}
