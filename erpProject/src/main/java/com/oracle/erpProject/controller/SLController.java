package com.oracle.erpProject.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.oracle.erpProject.model.Buying;
import com.oracle.erpProject.service.slservice.SL_Service_Interface;
import com.oracle.erpProject.service.slservice.buyingPaging;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SLController {

	private final SL_Service_Interface slService;
	
	
	
	// 구매 페이지
	@GetMapping(value = "buying")
	public String buying(Buying buying, Model model) {
		System.out.println("SlController buying Start >>>>>>");
		int totalbuyingCnt = slService.totalbuyingCnt();
		
		
		List<Buying> buyAlllist = slService.buyAlllist(buying);
		System.out.println("SlController buying buyAlllist >>>>" + buyAlllist);
		
		// paging 처리
		buyingPaging buypage = new buyingPaging(totalbuyingCnt, buying.getCurrentPage());
		buying.setStart(buying.getStart());
		buying.setEnd(buying.getEnd());
		
	
		
		model.addAttribute("buyAlllist",buyAlllist);
		model.addAttribute("totalbuyingCnt",totalbuyingCnt);	
		model.addAttribute("buypage",buypage);
		
		return "sl/buying";
	}
	
	
	
	@GetMapping("/selectedDateSearch")
	public String selectedDate(@RequestParam("buy_date") String buy_date, Buying buying, Model model) {
	    System.out.println("buy_date : " + buy_date);
	    
	    // 검색에 사용할 데이터 설정
	    buying.setBuy_date(buy_date);
	   
	
	    
	    // 검색 결과의 총 개수
	   int dateSearchtotCnt = slService.dateSearchtotCnt(buying);
	   
	    
	 
	    // 검색 결과를 가져옴
	    List<Buying> buyAlllist = slService.dateSearchAllList(buying);
	    System.out.println("selectedDate buying" + buying);
	    
	 // paging 처리
 		buyingPaging buypage = new buyingPaging(dateSearchtotCnt, buying.getCurrentPage());
 		buying.setStart(buying.getStart());
 		buying.setEnd(buying.getEnd());
   
		
		model.addAttribute("buyAlllist",buyAlllist);
		model.addAttribute("dateSearchtotCnt",dateSearchtotCnt);	
		model.addAttribute("buypage",buypage);
	    
	   
	   

	    
	    
	

	    return "sl/buying";
	}


	
	
	
	
	
	
	
	// 구매 등록 페이지
	@GetMapping(value = "buyingApply")
	public String buyingApply() {
		
		return "sl/buyingApply";
	}
	
	// 구매 상세 페이지
	@GetMapping(value = "buyDetail")
	public String buyDetail() {
		return "sl/buyDetail";
	}
	
}
