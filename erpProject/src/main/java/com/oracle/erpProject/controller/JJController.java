package com.oracle.erpProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.erpProject.model.Work_order_detail;
import com.oracle.erpProject.service.jj.JJ_Paging;
import com.oracle.erpProject.service.jj.JJ_Service_Interface;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class JJController {
	
	private final JJ_Service_Interface js;
	
	// 생산 - 메인 리스트 페이지
	@RequestMapping(value = "makeMain")
	public String jjmakeMain(Work_order_detail wod, Model model) {
		System.out.println("JJController's makeMain Go!");
		
		// 게시글 전체 개수 조회
		int cntMake = js.cntMake();
		System.out.println("JJController's cntMake -> " + cntMake);
		
		// 페이징 주기
		JJ_Paging page = new JJ_Paging(cntMake, wod.getCurrentPage());
		wod.setStart(page.getStart());
		wod.setEnd(page.getEnd());
		System.out.println("JJController's page ->" + page);
		
		// 게시글들을의 리스트 불러오기
		List<Work_order_detail> makeList = js.makeList(wod);
		System.out.println("JJController's makeList ->" + makeList);
		
		model.addAttribute("cntMake", cntMake);
		model.addAttribute("makeList", makeList);
		model.addAttribute("page", page);
		
		return "jj/makeMain";
	}
	
	// 생산 - 생산요청 페이지
	@RequestMapping(value = "makeFormRequest")
	public String makeFormRequest(Model model, HttpSession session) {
		if(session.getAttribute("emp_no")!=null) { // 로그인 된 상태
			System.out.println("JJController's makeFormRequest Go!");
			
			List<Work_order_detail> makeList = js.makeList();
			System.out.println("JJController's makeFormRequest makeList.size ->" + makeList.size());
			System.out.println("JJController's makeFormRequest makeList ->" + makeList);
			model.addAttribute("makeList", makeList);
			
			return "jj/makeFormRequest";
		} else { // 로그인이 안된 상태
			return "/";
		}
	}
	
	
	// 생산 - 메인 리스트 페이지 - 카테고리+검색어로 게시글을 조회
	
	
	
}
