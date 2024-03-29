package com.oracle.erpProject.dao.jjdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.model.Make_detail;

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
			System.out.println("JJ_DaoImpl's cntMake Exception -> " + e.getMessage());
		}
		return cntMake;
	}

	// 생산게시판 List페이지 - 게시물 list
	@Override
	public List<Make_detail> makeList(Make_detail wod) {
		List<Make_detail> makeList = null;
		System.out.println( "JJ_DaoImpl's makeList Go!");
		try {
			makeList = session.selectList("jjMakeList", wod);
			System.out.println("JJ_DaoImpl's makeList.size() -> " + makeList.size());
		} catch (Exception e) {
			System.out.println("JJ_DaoImpl's makeList Exception -> " + e.getMessage());
		}
		return null;
	}
}
