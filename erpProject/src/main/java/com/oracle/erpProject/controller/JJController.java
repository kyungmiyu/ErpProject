package com.oracle.erpProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.erpProject.model.jjmodel.JJ_Make_detail;
import com.oracle.erpProject.service.jjservice.JJ_Paging;
import com.oracle.erpProject.service.jjservice.JJ_Service_Interface;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class JJController {
	
	private final JJ_Service_Interface js;
	
	// 생산 - 메인 리스트 페이지
	@GetMapping("makeMain")
	public String jjmakeMain(JJ_Make_detail md, Model model) {
		System.out.println("JJController's makeMain Go!");
		
		// 게시글 전체 개수 조회
		int cntMake = js.cntMake();
		System.out.println("JJController's cntMake -> " + cntMake);
		
		// 페이징 주기
		JJ_Paging page = new JJ_Paging(cntMake, md.getCurrentPage());
		md.setStart(page.getStart());
		md.setEnd(page.getEnd());
		System.out.println("JJController's page ->" + page);
		
		// 게시글들을의 리스트 불러오기
		List<JJ_Make_detail> makeList = js.makeList(md);
		System.out.println("JJController's makeList ->" + makeList);
		
		model.addAttribute("cntMake", cntMake);
		model.addAttribute("makeList", makeList);
		model.addAttribute("page", page);
		
		return "jj/makeMain";
	}
	
	// 생산 상세 페이지
	@GetMapping("makeDetail")
	public String jjmakeDetail(JJ_Make_detail md, Model model) {
		System.out.println("JJController's jjmakeDetail Go!");
		
		JJ_Make_detail jjmakeDetail = js.jjmakeDetail(md.getM_num());
		System.out.println("JJController's jjmakeDetail -> " + jjmakeDetail);
		
		model.addAttribute("jjmakeDetail", jjmakeDetail);
		
		return "jj/makeDetail";
	}
	
	
	
	// 생산 - 생산요청 페이지
	@GetMapping(value = "makeFormRequest")
	public String makeFormRequest(Model model, HttpSession session) {
//		if(session.getAttribute("emp_no")!=null) { // 로그인 된 상태
			System.out.println("JJController's makeFormRequest Go!");
			
			List<JJ_Make_detail> requestMakeList = js.requestMakeList();
			System.out.println("JJController's makeFormRequest makeList.size ->" + requestMakeList.size());
			System.out.println("JJController's makeFormRequest makeList ->" + requestMakeList);
			model.addAttribute("requestMakeList", requestMakeList);
			
			return "jj/makeFormRequest";
//		} else { // 로그인이 안된 상태
//			return "/";
//		}
	}
	
	// 생산 - 생산요청 페이지 - 입력 적용
	@PostMapping(value = "makeRequest")
	public String makeRequest(JJ_Make_detail md, Model model) {
		System.out.println("JJController's makeRequest Go!");
		int makeRequest = js.makeRequest(md);
		System.out.println("JJController's makeRequest -> " + makeRequest);
		
		return "foward:makeMain";
	}
	
	
	
	
	// 생산 - 메인 리스트 페이지 - 카테고리+검색어로 게시글을 조회
	
	
	
}
