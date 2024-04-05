package com.oracle.erpProject.dao.Yhsdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.model.Board;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class Yhs_DaoImpl implements Yhs_Dao_Interface {
	
	// Mybatis DB 연동 
    private final SqlSession session;
	@Override
	public int totalBoard(Board board) {
		int totBoardCount = 0;
		System.out.println("AskDaoImpl Start total..." );

		try {
			totBoardCount = session.selectOne("askTotal",board);
			System.out.println("AskDaoImpl totalAsk totAskCount->" +totBoardCount);
		} catch (Exception e) {
			System.out.println("AskDaoImpl totalAsk Exception->"+e.getMessage());
		}
		return totBoardCount;	
	}
	
	@Override
	public List<Board> listBoard(Board board) {
		List<Board> askList = null;
		System.out.println("AskDaoImpl listAsk Start ..." );
		try {
			//                             Map ID        parameter
			askList = session.selectList("yhsAskListAll", board);
			System.out.println("AskDaoImpl listAsk askList.size()->"+askList.size());
		} catch (Exception e) {
			System.out.println("AskDaoImpl listAsk e.getMessage()->"+e.getMessage());
		}
		return askList;
	}

}
