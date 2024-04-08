package com.oracle.erpProject.service.Yhsservice;

import java.util.List;

import com.oracle.erpProject.model.yhsmodel.YhsBoard;

public interface Yhs_Service_Interface {
	
	int totalBoard(YhsBoard board);
	
	List<YhsBoard> listBoard(YhsBoard board);
	
	// 게시판 상세 페이지 
	YhsBoard boardContents(int b_no);
	
	
	// 게시판 글 조회수 
	int boardViewCnt(YhsBoard board);
	
	
	// 게시판 상세 페이지 댓글 카운트
	int boardReplyCnt(int b_no);
	
	// 게시판 상세페이지 파일 조회
	List<YhsBoard> boardFile(int b_no);

}

