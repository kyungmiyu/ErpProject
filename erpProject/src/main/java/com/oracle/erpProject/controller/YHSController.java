package com.oracle.erpProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.erpProject.model.Board;
import com.oracle.erpProject.service.Yhsservice.Paging;
import com.oracle.erpProject.service.Yhsservice.Yhs_ServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class YHSController {
	private final Yhs_ServiceImpl yhs_ServiceImpl;
		
	@GetMapping("board") 
	public String boardList(Model model, Board board) {
		System.out.println("YHSController boardList start...");
		int totalBoard = yhs_ServiceImpl.totalBoard(board);
		System.out.println("YHSController Start totalAsk->"+totalBoard);
		
		// Paging 작업
		Paging page = new Paging(totalBoard, board.getCurrentPage());
		System.out.println("test page : " + page );
		// Parameter ask --> Page만 추가 Setting
		board.setStart(page.getStart()); // 시작시 1
		board.setEnd(page.getEnd()); // 시작시 10
		System.out.println("YHSController boardList board->"+board);

		List<Board> listBoard = yhs_ServiceImpl.listBoard(board);
		System.out.println("YHSController  listBoard.size()=>" + listBoard.size());

		model.addAttribute("listBoard" , listBoard);
		model.addAttribute("page", page);
		model.addAttribute("totalBoard",totalBoard);
		
		return "Yhs/board";
	}
	
	// 자유 게시판 상세내용
	@GetMapping(value = "boardContents")
	public String boardFreeContents(HttpServletRequest request, Model model, Board board) {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		System.out.println("boardContents cboard_no : " + board_no);
		Board boardContents = yhs_ServiceImpl.boardContents(board_no);
		System.out.println("YHSController replyBoardList Start..");

		// 자유게시판 조회수
		int boardViewCnt = yhs_ServiceImpl.boardViewCnt(board);

		// 자유 게시판 댓글수
		//int boardReplyCnt = yhs_ServiceImpl.boardReplyCnt(b_no);
		
		// 파일 첨부 된 글
		// List<LslboardFile> boardFreeFile = ls.boardFreeFile(cboard_no);
		
		// model.addAttribute("boardFreeFile",boardFreeFile);
		//model.addAttribute("boardReplyCnt", boardReplyCnt);
		model.addAttribute("boardFreeViewCnt", boardViewCnt);
		model.addAttribute("boardFreeContents", boardContents);
		return "Yhs/boardContents";
	}
	
}
