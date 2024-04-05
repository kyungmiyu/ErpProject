package com.oracle.erpProject.dao.Yhsdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.model.Board;
import com.oracle.erpProject.model.yhsmodel.YhsBoard;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class Yhs_DaoImpl implements Yhs_Dao_Interface {
	
	// Mybatis DB 연동 
    private final SqlSession session;
	@Override
	public int totalBoard(YhsBoard board) {
		int totBoardCount = 0;
		System.out.println("BoardDaoImpl Start total..." );

		try {
			totBoardCount = session.selectOne("boardTotal",board);
			System.out.println("Yhs_DaoImpl totalBoard totBoardCount->" +totBoardCount);
		} catch (Exception e) {
			System.out.println("Yhs_DaoImpl totalBoard Exception->"+e.getMessage());
		}
		return totBoardCount;	
	}
	
	@Override
	public List<YhsBoard> listBoard(YhsBoard board) {
		List<YhsBoard> boardList = null;
		System.out.println("Yhs_DaoImpl listBoard Start ..." );
		try {
			//                             Map ID        parameter
			boardList = session.selectList("yhsBoardListAll", board);
			System.out.println("Yhs_DaoImpl listBoard boardList.size()->"+boardList.size());
		} catch (Exception e) {
			System.out.println("Yhs_DaoImpl listBoard e.getMessage()->"+e.getMessage());
		}
		return boardList;
	}

}
