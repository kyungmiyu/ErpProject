package com.oracle.erpProject.service.Yhsservice;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.erpProject.dao.Yhsdao.Yhs_Dao_Interface;
import com.oracle.erpProject.model.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class Yhs_ServiceImpl implements Yhs_Service_Interface{
	
	private final Yhs_Dao_Interface yhs_Dao_Interface;
	
	@Override
	public int totalBoard(Board board) {
		System.out.println("AskServiceImpl Start total...");
		int totBoardCnt = yhs_Dao_Interface.totalBoard(board);
		System.out.println("AskSeviceImpl totalAsk totAskCnt->"+ totBoardCnt);
		return totBoardCnt;
	}
	
	@Override
	public List<Board> listBoard(Board board) {
		List<Board> boardList = null;
		System.out.println("AskServiceImp1 listManager start...");
		boardList = yhs_Dao_Interface.listBoard(board);
		System.out.println("AskServiceImp1 listAsk askList.size()->"+boardList.size());
		return boardList;
	}
	
}