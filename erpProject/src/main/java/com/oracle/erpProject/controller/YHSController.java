package com.oracle.erpProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.erpProject.model.yhsmodel.YhsBoard;
import com.oracle.erpProject.service.Yhsservice.Paging;
import com.oracle.erpProject.service.Yhsservice.Yhs_Service_Interface;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class YHSController {
	private final Yhs_Service_Interface yhs_Service_Interface;
		
	@GetMapping(value = "board") 
	public String boardList(Model model, YhsBoard board) {
		System.out.println("YHSController boardList start..."); 
		int totalBoard = yhs_Service_Interface.totalBoard(board);
		System.out.println("YHSController Start totalBoard->"+totalBoard);
		 
		// Paging 작업 
		Paging page = new Paging(totalBoard, board.getCurrentPage());
		System.out.println("test page : " + page ); 
		// Parameter ask --> Page만 추가 Setting 
		board.setStart(page.getStart()); // 시작시 1
		board.setEnd(page.getEnd()); // 시작시 10
		System.out.println("YHSController boardList board->"+board);
		  
		List<YhsBoard> listBoard = yhs_Service_Interface.listBoard(board);
		System.out.println("YHSController  listBoard.size()=>" + listBoard.size());
		 
		model.addAttribute("listBoard" , listBoard); 
		model.addAttribute("page",page); 
		model.addAttribute("totalBoard",totalBoard);
		return "Yhs/board";
	}
	
	// 자유 게시판 상세내용
		@GetMapping(value = "boardContents")
		public String boardContents(HttpServletRequest request, Model model, YhsBoard board) {
			int b_no = Integer.parseInt(request.getParameter("b_no"));
			
			System.out.println("boardContents b_no : " + b_no);
			YhsBoard boardContents = yhs_Service_Interface.boardContents(b_no);
			System.out.println("YHSController boardContents Start..");

			// 게시판 조회수
			int boardViewCnt = yhs_Service_Interface.boardViewCnt(board);

			// 게시판 댓글수
//			int boardReplyCnt = yhs_Service_Interface.boardReplyCnt(b_no);
			// 파일 첨부 된 글
//			List<YhsBoard> boardFile = yhs_Service_Interface.boardFile(b_no);
			
//			model.addAttribute("boardFile",boardFile);
//			model.addAttribute("boardReplyCnt", boardReplyCnt);
			model.addAttribute("boardViewCnt", boardViewCnt);
			model.addAttribute("boardContents", boardContents);
//			System.out.println("boardReplyCnt" + boardReplyCnt);
			System.out.println("boardViewCnt" + boardViewCnt);
			System.out.println("boardContents" + boardContents);
			return "Yhs/boardContents";
			
		}
			
	// 자유 게시판 글 작성 페이지
		@GetMapping(value = "boardForm")
		public String boardWrite() {
			System.out.println("YHSController boardForm Start...");
			return "Yhs/boardForm";
		}

	// 자유 게시판 글쓰기
	@PostMapping(value = "boardWrite")
	public String boardWrite(HttpServletRequest request, YhsBoard board, Model model,HttpSession session ) {
		System.out.println("YHSController boardWrite Start...");
			
		try {
			String empNo = (String) session.getAttribute("emp_no");
			board.setEmp_no(Integer.parseInt(empNo));   
			System.out.println("emp_no"+ empNo); 	
			yhs_Service_Interface.boardWriteInsert(board);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("YHSController boardWrite Exception ->" + e.getMessage());
		}
		return "redirect:/board";
		}
	
	@RequestMapping("/deleteBoard")
	public String deleteBoard(@RequestParam("b_no") int b_no, YhsBoard board, Model model) {
		System.out.println("YHSController Start delete..." );
		System.out.println("YHSController b_no >>>>>>>>>>>"  + b_no);
		
		board.setB_no(b_no);
		// name -> Service, dao , mapper
		int result = yhs_Service_Interface.deleteBoard(board);
		
		return "redirect:/board";
	}
	
//	// 공지사항 글 삭제
//	@RequestMapping(value="deleteBoard")
//	public String deleteBoard(HttpServletRequest request, YhsBoard board) {
//		System.out.println("YHSController deleteBoard Start...");
//		int b_no = Integer.parseInt(request.getParameter("b_no"));
//		board.setB_no(b_no);
//		int deleteFreeBoard = yhs_Service_Interface.deleteBoard(board);
//
//		System.out.println("YHSController deleteBoard ->" + deleteFreeBoard);
//
//		return "forward:board";
//	}
}
