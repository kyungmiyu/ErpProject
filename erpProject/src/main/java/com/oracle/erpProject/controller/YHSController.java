package com.oracle.erpProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		 
		model.addAttribute("listBoard" , listBoard); model.addAttribute("page",
		page); model.addAttribute("totalBoard",totalBoard);
		 
		
		return "Yhs/board";
	}
	
	// 자유 게시판 상세내용
		@GetMapping(value = "boardContents")
		public String boardContents(HttpServletRequest request, Model model, YhsBoard board) {
			int b_no = Integer.parseInt(request.getParameter("b_no"));
			
			System.out.println("boardFreeContents cboard_no : " + b_no);
			YhsBoard boardContents = yhs_Service_Interface.boardContents(b_no);
			System.out.println("LslController replyBoardFreeList Start..");

			// 자유게시판 조회수
			int boardViewCnt = yhs_Service_Interface.boardViewCnt(board);

			// 자유 게시판 댓글수
			int boardReplyCnt = yhs_Service_Interface.boardReplyCnt(b_no);
			
			// 파일 첨부 된 글
//			List<YhsBoard> boardFile = yhs_Service_Interface.boardFile(b_no);
			
//			model.addAttribute("boardFile",boardFile);
			model.addAttribute("boardReplyCnt", boardReplyCnt);
			model.addAttribute("boardViewCnt", boardViewCnt);
			model.addAttribute("boardContents", boardContents);
			return "Yhs/boardContents";
		}
	
	
	
//	게시판 글쓰기	
	@GetMapping(value = "boardForm")
	public String askForm(HttpServletRequest request, Model model) {
		System.out.println("BoardController Start boardForm...");
		
		String bregdate = request.getParameter("b_regdate");
	 // 세션에서 보내는 사람의 아이디 가져오기
        Long empNo = (Long) request.getSession().getAttribute("user_no");
        
     // 모델에 데이터 추가 (세션ID, 유저리스트)
        model.addAttribute("empNo", empNo);

		return "yhs/askForm";
	}
}
