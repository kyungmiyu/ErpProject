package com.oracle.erpProject.dao.jjdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.model.jjmodel.JJ_Make;
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
	public int makeRequest1(JJ_Make m) {
		int makeRequest1 = 0;
		System.out.println("JJ_DaoImpl's makeRequest1 Go!");
		try {
			makeRequest1 = session.insert("jjMakeRequestInsert1", m);
			System.out.println("JJ_DaoImpl's makeRequest1 -> " + makeRequest1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return makeRequest1;
	}
	
	// 생산게시판 생산 요청 기능
	@Override
	public int makeRequest2(JJ_Make_detail md) {
		int makeRequest2 = 0;
		System.out.println("JJ_DaoImpl's makeRequest2 Go!");
		try {
			makeRequest2 = session.insert("jjMakeRequestInsert2", md);
			System.out.println("JJ_DaoImpl's makeRequest2 -> " + makeRequest2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return makeRequest2;
	}

	// 생산 상세 페이지
	@Override
	public JJ_Make_detail jjmakeDetail(int m_num) {
		System.out.println("JJ_DaoImpl's jjmakeDetail Go!");
		JJ_Make_detail jjmakeDetail = new JJ_Make_detail();
		try {
			jjmakeDetail = session.selectOne("jjmakeDetail", m_num);
			System.out.println("JJ_DaoImpl's jjmakeDetail -> " + jjmakeDetail);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return jjmakeDetail;
	}

	// 검색어 카운트 기능
	@Override
	public int makeSearchCnt(JJ_Make_detail md) {
		int makeSearchCnt = 0;
		System.out.println("JJ_DaoImpl's makeSearchCnt md->"+md);
		if(md.getKeyword()==null) md.setKeyword("%");
		try {
			makeSearchCnt = session.selectOne("makeSearchCnt", md);
			System.out.println("JJ_DaoImpl's makeSearchCnt ->" + makeSearchCnt);
		} catch(Exception e) {
			System.out.println("JJ_DaoImpl's makeSearchCnt Exception -> "+ e.getMessage());
		}
		return makeSearchCnt;
	}

	// 검색어 리스트 기능
	@Override
	public List<JJ_Make_detail> makeSearchList(JJ_Make_detail md) {
		List<JJ_Make_detail> makeSearchList = null;
		System.out.println("JJ_DaoImpl's makeSearchList Go!");
		try {
			makeSearchList = session.selectList("makeSearchList", md);
			System.out.println("JJ_DaoImpl's makeSearchList -> " + makeSearchList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return makeSearchList;
	}

	// 생산 삭제 기능
	@Override
	public int jjmakeDelete(int m_num) {
		System.out.println("JJ_DaoImpl's jjmakeDelete Go!");
		int jjmakeDelete = 0;
		System.out.println("JJ_DaoImpl's jjmakeDelete m_num ->" + m_num);
		try {
			jjmakeDelete = session.delete("jjmakeDelete", m_num);
			System.out.println("JJ_DaoImpl's jjmakeDelete -> " + jjmakeDelete);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jjmakeDelete;
	}

}
