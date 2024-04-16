package com.oracle.erpProject.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.erpProject.model.jjmodel.JJ_Make;
import com.oracle.erpProject.model.jjmodel.JJ_Make_detail;
import com.oracle.erpProject.model.mkmodel.mkProduct;
import com.oracle.erpProject.service.jjservice.JJ_Paging;
import com.oracle.erpProject.service.jjservice.JJ_Service_Interface;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class JJController {
	
	private final JJ_Service_Interface js;	
	
	// 생산 상세 - 리스트 페이지
	@GetMapping("makeMain")
	public String jjmakeMain(JJ_Make m, JJ_Make_detail md, Model model, HttpSession session) {
		System.out.println("JJController's makeMain Go!");
		System.out.println("session-->"+session.getAttribute("emp_no"));
		System.out.println("session-->"+session.getAttribute("dept_no"));
		System.out.println("session-->"+session.getAttribute("emp_role"));
		
		// 게시글 전체 개수 조회
		int cntMake = js.cntMake();
		System.out.println("JJController's cntMake -> " + cntMake);
		
		// 페이징 주기
		JJ_Paging page = new JJ_Paging(cntMake, md.getCurrentPage());
		md.setStart(page.getStart());
		md.setEnd(page.getEnd());
		System.out.println("JJController's page ->" + page);

		// JJ_Make_detail의 리스트 불러오기
		List<JJ_Make_detail> makedetailList = js.makedetailList(md);
		System.out.println("JJController's makeList ->" + makedetailList);
		
		model.addAttribute("cntMake", cntMake);
		model.addAttribute("makeList", makedetailList);
		model.addAttribute("page", page);
		
		return "jj/makeMain";
	}
	
	// 생산 상세 페이지
	@GetMapping("makeDetail")
	public String jjmakeDetail(mkProduct mp, JJ_Make_detail md, Model model) {
		System.out.println("JJController's jjmakeDetail Go!");
		System.out.println("JJController's jjmakeDetail product->"+mp);
		System.out.println("JJController's jjmakeDetail md->"+md);
		
		//제품 리스트 불러오기
		List<mkProduct> jjproductList = js.jjproductList(mp);
		System.out.println("JJController's jjmakeDetail jjproductList ->" + jjproductList);
		
		// 게시글 1개 조회하기
		JJ_Make_detail jjmakeDetail = js.jjmakeDetail(md.getM_num());
		System.out.println("JJController's jjmakeDetail -> " + jjmakeDetail);
		
		
		model.addAttribute("jjmakeDetail", jjmakeDetail);
		model.addAttribute("productList", jjproductList);
		
		return "jj/makeDetail";
	}
	
	
	
	// 생산 - 생산요청 페이지
	@GetMapping(value = "makeFormRequest")
	public String makeFormRequest(mkProduct mp, Model model, HttpSession session) {
//		if(session.getAttribute("emp_no")!=null) { // 로그인 된 상태
			System.out.println("JJController's makeFormRequest Go!");
			
			//제품 리스트 불러오기
			List<mkProduct> jjproductList = js.jjproductList(mp);
			
			List<JJ_Make_detail> requestMakeList = js.requestMakeList();
			System.out.println("JJController's makeFormRequest makeList.size ->" + requestMakeList.size());
			System.out.println("JJController's makeFormRequest makeList ->" + requestMakeList);
			model.addAttribute("requestMakeList", requestMakeList);
			model.addAttribute("productList", jjproductList);
			
			return "jj/makeFormRequest";
//		} else { // 로그인이 안된 상태
//			return "/";
//		}
	}

	
	// 생산 - 생산요청 페이지 - 입력 적용
	@PostMapping("JJmakeRequest")
	public String makeRequest3(JJ_Make m, JJ_Make_detail md) {
		System.out.println("JJController's makeRequest Go!");
			int makeRequest1 = js.makeRequest1(m);
			System.out.println("JJController's makeRequest1 -> " + makeRequest1);
			
			int makeRequest2 = js.makeRequest2(md);
			System.out.println("JJController's makeRequest2 -> " + makeRequest2);
		
		return "redirect:makeMain";
	}
// 원인: 타입 변환시 int -> String, 또는 String -> Date 타입 변환간 오류 발생
//	md.setF_id(md.getF_id());
//	md.setMd_status(md.getMd_status());
//	md.setRpnc_gubun(md.getRpnc_gubun());
//	md.setMd_date(md.getMd_date());
	
	
	
	// 생산 - 메인 리스트 페이지 - 검색어로 게시글을 조회
	@GetMapping("jjmakeSearch")
	public String jjmakeSearch(JJ_Make_detail md, Model model) {
		System.out.println("JJController's jjmakeSearch Go!");
		
		System.out.println("JJController's jjmakeSearch -> " + md);
		//search count
		int makeSearchCnt = js.makeSearchCnt(md);
		System.out.println("JJController's jjmakeSearch makeSearchCnt -> " + makeSearchCnt);
		
		//search paging
		JJ_Paging page = new JJ_Paging(makeSearchCnt, md.getCurrentPage());
		System.out.println("JJController's jjmakeSearch page ->" + page);
		
		md.setStart(page.getStart());
		md.setEnd(page.getEnd());
		System.out.println("JJController's jjmakeSearch page ->" + page);
		
		//search List Load
		List<JJ_Make_detail> makeSearchList = js.makeSearchList(md);
		System.out.println("JJController's jjmakeSearch makeSearchList.size()->" + makeSearchList.size());
		
		model.addAttribute("cntMake", makeSearchCnt);
		model.addAttribute("makeList", makeSearchList);
		model.addAttribute("page", page);
		model.addAttribute("md", md);
		
		return "jj/makeMain";
	}

	
	
	// 게시글 삭제 적용
	@RequestMapping("jjmakeDelete")
	public String jjmakeDelete(JJ_Make m, JJ_Make_detail md) {
		System.out.println("JJController's jjmakeDelete Go!");
		//make_detail 삭제
		int jjmakeDelete = js.jjmakeDelete(md.getM_num());
		//make 삭제
		int jjmakeDelete2 = js.jjmakeDelete2(m.getM_num());
		
		return "redirect:makeMain";
	}
	
	
	
	// 게시글 업데이트
	@RequestMapping("jjmakeUpdate")
	public String jjmakeUpdate(JJ_Make m, JJ_Make_detail md) {
		System.out.println("JJController's jjmakeUpdate Go!");
		
		System.out.println("JJController's jjmakeUpdate m->"+ m);
		// make 업데이트
		int jjmakeUpdate = js.jjmakeUpdate(m);
		System.out.println("JJController's jjmakeUpdate jjmakeUpdate->" + jjmakeUpdate);
		
		// make_detail 업데이트
		int jjmakeDetailUpdate = js.jjmakeDetailUpdate(md);
		System.out.println("JJController's jjmakeUpdate jjmakeDetailUpdate->" + jjmakeDetailUpdate);
		
		return "redirect:makeMain";
	}
	
}
