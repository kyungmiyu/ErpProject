package com.oracle.erpProject.service.Yhsservice;

import java.util.List;

import com.oracle.erpProject.model.Board;

public interface Yhs_Service_Interface {
	
	int totalBoard(Board board);
	
	List<Board> listBoard(Board board);
	
	// 게시판 상세 페이지 
	Board boardContents(int b_no);
	
	
	// 게시판 글 조회수 
	int boardViewCnt(Board board);
	
	
	// 게시판 상세 페이지 댓글 카운트
	int boardReplyCnt(int b_no);

}
