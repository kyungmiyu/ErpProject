package com.oracle.erpProject.dao.sldao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SL_DaoImpl implements SL_Dao_Interface{

	private final SqlSession session;
	
	
}
