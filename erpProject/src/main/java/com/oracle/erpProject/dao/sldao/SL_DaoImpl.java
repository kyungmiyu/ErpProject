package com.oracle.erpProject.dao.sldao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.model.Buying;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SL_DaoImpl implements SL_Dao_Interface{

	private final SqlSession session;

	@Override
	public int totalbuyingCnt() {
		int totalbuyingCnt = session.selectOne("LsltotalbuyingCnt");
		return totalbuyingCnt;
	}

	@Override
	public List<Buying> buyAlllist(Buying buying) {
		List<Buying> buyAlllist = session.selectList("buyAlllist", buying);
		return buyAlllist;
	}
	
	
	
}
