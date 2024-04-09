package com.oracle.erpProject.service.Yhsservice;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
	
//	// 게시판 글 상세 페이지 댓글 카운트 
//	@Override
//	public int boardReplyCnt(int b_no) {
//		int boardReplyCnt = yhs_Dao_Interface.boardReplyCnt(b_no);
//		return boardReplyCnt;
//	}
//	
	// 자유 게시판 리스트 조회수 
	@Override
	public int boardViewCnt(YhsBoard board) {
		int boardViewCnt = yhs_Dao_Interface.boardViewCnt(board);
		return boardViewCnt;
	}

	@Override
	public YhsBoard boardContents(int b_no) {
		System.out.println("Yhs_ServiceImpl boardContents Start...");
		YhsBoard boardContents = yhs_Dao_Interface.boardContents(b_no);
		System.out.println("Yhs_ServiceImpl boardContents -> " + boardContents);
		return boardContents;
	}

	@Override
	public List<YhsBoard> boardFile(int b_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardReplyCnt(int b_no) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	// 질문 게시판 파일 상세 내역 
//	@Override
//	public List<LslboardFile> boardFile(int cboard_no) {
//		List<LslboardFile> boardFreeFile = ld.boardFreeFile(cboard_no);
//		return boardFreeFile;
//	}


}