package com.oracle.erpProject.dao.jjdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.oracle.erpProject.model.jjmodel.JJ_Make_detail;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JJ_DaoImpl implements JJ_Dao_Interface {
	
	// Mybatis DB 연동
	private final SqlSession session;

	// 생산게시판 List페이지 - 총 게시물 count
	@Override
	public int cntMake() {
		int cntMake = 0;
		System.out.println("JJ_DaoImpl's cntMake Go!");
		try {
			cntMake = session.selectOne("jjcntMake");
			System.out.println("JJ_DaoImpl's cntMake -> " + cntMake);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cntMake;
	}

	// 생산게시판 List페이지 - 게시물 list
	@Override
	public List<JJ_Make_detail> makeList(JJ_Make_detail md) {
		List<JJ_Make_detail> makeList = null;
		System.out.println( "JJ_DaoImpl's makeList Go!");
		try {
			makeList = session.selectList("jjMakeList", md);
			System.out.println("JJ_DaoImpl's makeList.size() -> " + makeList.size());
		} catch (Exception e) {
			System.out.println("JJ_DaoImpl's makeList Exception -> " + e.getMessage());
		}
		return makeList;
	}

	// 생산게시판 생산 요청 페이지
	@Override
	public List<JJ_Make_detail> requestMakeList() {
		List<JJ_Make_detail> requestMakeList = null;
		System.out.println("JJ_DaoImpl's requestMakeList Go!");
		try {
			requestMakeList = session.selectList("jjRequestMakeList");
			System.out.println("JJ_DaoImpl's requestMakeList.size() -> " + requestMakeList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestMakeList;
	}

	@Override
	public int makeRequest(JJ_Make_detail md) {
		int makeRequest = 0;
		System.out.println("JJ_DaoImpl's makeRequest Go!");
		try {
			makeRequest = session.insert("jjMakeRequestInsert", md);
			System.out.println("JJ_DaoImpl's makeRequest -> " + makeRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return makeRequest;
	}
}
