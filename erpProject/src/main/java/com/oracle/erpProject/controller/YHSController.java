package com.oracle.erpProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.erpProject.model.yhsmodel.YhsBoard;
import com.oracle.erpProject.service.Yhsservice.Paging;
import com.oracle.erpProject.service.Yhsservice.Yhs_Service_Interface;

import jakarta.servlet.http.HttpServletRequest;
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
		
	
	
//	게시판 글쓰기	
	@GetMapping(value = "boardForm")
	public String boardForm(HttpServletRequest request, Model model) {
		System.out.println("BoardController Start boardForm...");
		
		String bregdate = request.getParameter("b_regdate");
	 // 세션에서 보내는 사람의 아이디 가져오기
//        Long empNo = (Long) request.getSession().getAttribute("emp_no");
        
     // 모델에 데이터 추가 (세션ID, 유저리스트)
//        model.addAttribute("empNo", empNo);

		return "Yhs/boardForm";
	}
	
	@PostMapping(value = "boardWrite")
	public String boardWrite(@ModelAttribute YhsBoard board ,Model model,HttpServletRequest request ) {
		System.out.println("YHSController Start boardWrite..." );
//		Long empNo = (Long) request.getSession().getAttribute("emp_no");
//		board.setEmp_no(empNo);
		System.out.println("YHSControllesr boardWrite ask->" + board);
		int insertResult = yhs_Service_Interface.insertBoard(board);
		System.out.println("YHSController insertResult insertResult->"+insertResult );
		return "redirect:/board";

	}
	
	@RequestMapping(value="deleteBoard")
	public String deleteBoard(YhsBoard board, Model model) {
		System.out.println("YHSController Start delete..." );
		// name -> Service, dao , mapper
		int result = yhs_Service_Interface.deleteBoard(board.getB_no());
		return "redirect:/board";
	}
	
//	// 자유 게시판 글 삭제
//	@RequestMapping(value="deleteBoard")
//	public String deleteBoard(HttpServletRequest request, YhsBoard board) {
//		System.out.println("YHSController deleteBoard Start...");
//		int b_no = Integer.parseInt(request.getParameter("b_no"));
//		board.setB_no(b_no);
//		int deleteBoard = yhs_Service_Interface.deleteBoard(board);
//
//		System.out.println("YHSController deleteBoard ->" + deleteBoard);
//
//		return "redirect:/board";
//	}
}
