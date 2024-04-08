package com.oracle.erpProject.service.Yhsservice;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.erpProject.dao.Yhsdao.Yhs_Dao_Interface;
import com.oracle.erpProject.model.Board;
import com.oracle.erpProject.model.yhsmodel.YhsBoard;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class Yhs_ServiceImpl implements Yhs_Service_Interface{
	
	private final Yhs_Dao_Interface yhs_Dao_Interface;
	
	@Override
	public int totalBoard(YhsBoard board) {
		System.out.println("Yhs_ServiceImpl Start total...");
		int totBoardCnt = yhs_Dao_Interface.totalBoard(board);
		System.out.println("Yhs_ServiceImpl totalBoard totBoardCnt->"+ totBoardCnt);
		return totBoardCnt;
	}
	
	@Override
	public List<YhsBoard> listBoard(YhsBoard board) {
		List<YhsBoard> boardList = null;
		System.out.println("Yhs_ServiceImpl listManager start...");
		boardList = yhs_Dao_Interface.listBoard(board);
		System.out.println("Yhs_ServiceImpl listBoard boardList.size()->"+boardList.size());
		return boardList;
	}

//
//	public Board boardContents(int board_no) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public int boardViewCnt(Board board) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}