package com.oracle.erpProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.erpProject.model.Board;
import com.oracle.erpProject.service.Yhs.Yhs_ServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class YHSController {
	
	@GetMapping("board")
	public String board() {
		return "Yhs/board";
	}
	
	/*
	 * @GetMapping("boardList") public String boardList(HttpServletRequest request ,
	 * Model model, Board board) {
	 * System.out.println("YHSController boardList start..."); HttpSession session =
	 * request.getSession(); int EMP_NO = (int)session.getAttribute("EMP_NO");
	 * System.out.println("YHSController boardList user_no->"+EMP_NO);
	 * board.setEMP_NO(EMP_NO); int totalBoard = Yhs_ServiceImpl.totalBoard(board);
	 * System.out.println("YHSController Start totalAsk->"+totalBoard ); // //
	 * Paging 작업 Paging page = new Paging(totalBoard board.getCurrentPage());
	 * System.out.println("test page : " + page ); // // Parameter ask --> Page만 추가
	 * Setting board.setStart(page.getStart()); // 시작시 1
	 * board.setEnd(page.getEnd()); // 시작시 10
	 * System.out.println("YHSController boardList board->"+board);
	 * 
	 * List<Board> listAsk = Yhs_ServiceImpl.listBoard(board);
	 * System.out.println("AskController  listAsk.size()=>" + listAsk.size());
	 * 
	 * model.addAttribute("listAsk" , listAsk); model.addAttribute("page", page);
	 * 
	 * return "yhs/ask"; }
	 */

}
