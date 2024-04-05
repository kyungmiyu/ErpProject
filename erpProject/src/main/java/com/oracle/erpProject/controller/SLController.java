package com.oracle.erpProject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.oracle.erpProject.model.Buying;
import com.oracle.erpProject.model.Product;
import com.oracle.erpProject.model.slmodel.SLBuying;
import com.oracle.erpProject.model.slmodel.SLBuying_detail;
import com.oracle.erpProject.model.slmodel.SLProduct;
import com.oracle.erpProject.service.slservice.SL_Service_Interface;
import com.oracle.erpProject.service.slservice.buyingPaging;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SLController {

	private final SL_Service_Interface slService;
	
	
	
	// 구매 페이지
	@GetMapping(value = "buying")
	public String buying(SLBuying buying, Model model) {
		System.out.println("SlController buying Start >>>>>>");
		int totalbuyingCnt = slService.totalbuyingCnt();
		
		
		
		
		// paging 처리
		buyingPaging buypage = new buyingPaging(totalbuyingCnt, buying.getCurrentPage());
		buying.setStart(buying.getStart());
		buying.setEnd(buying.getEnd());
		
		
		List<SLBuying> buyAlllist = slService.buyAlllist(buying);
		System.out.println("SlController buying buyAlllist@@@@ >>>>" + buyAlllist);
				
		
		model.addAttribute("buying",buying);
		model.addAttribute("buyAlllist",buyAlllist);
		model.addAttribute("totalbuyingCnt",totalbuyingCnt);	
		model.addAttribute("buypage",buypage);
		
		return "sl/buying";
	}
	
	
	
	@GetMapping("/selectedDateSearch")
	public String selectedDate(@RequestParam("buy_date") String buy_date, SLBuying buying, Model model) {
	    System.out.println("buy_date : " + buy_date);
	    
	    buying.setBuy_date(buy_date);
	    
	    int dateSearchtotCnt = slService.dateSearchtotCnt(buying);
	    System.out.println("dateSearchtotCnt>>>>>>>" + dateSearchtotCnt);
	 
	    // 검색 결과를 가져옴
	    List<SLBuying> buyAlllist = slService.dateSearchAllList(buying);
	    System.out.println("selectedDate buyAlllist->" + buyAlllist);
	    System.out.println("selectedDate buyAlllist.size->" + buyAlllist.size());
	    
	 // paging 처리
 		buyingPaging buypage = new buyingPaging(dateSearchtotCnt, buying.getCurrentPage());
 		buying.setStart(buying.getStart());
 		buying.setEnd(buying.getEnd());
 		
 		
 		// 목적 : 날짜 String --> Date형 String 로 변환하기 위해서
 	    // 포맷터        
 		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");        
 		// 문자열 -> Date        
 		try {
			Date date = formatter.parse(buying.getBuy_date());
			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			 String strBuy_date = format.format(date);
			 buying.setBuy_date(strBuy_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("buying.getBuy_date()->" + buying.getBuy_date());
		
		model.addAttribute("buyAlllist",buyAlllist);
		model.addAttribute("dateSearchtotCnt",dateSearchtotCnt);	
		model.addAttribute("buypage",buypage);
	    

	    return "sl/buying";
	}

	
	// 구매 상세 페이지
	@GetMapping(value = "buyDetail")
	public String buyDetail(HttpServletRequest request, SLBuying buying, Model model) {
		System.out.println("buyDetail Start ->>>>>>>>>>");
		int cust_no = Integer.parseInt(request.getParameter("cust_no"));
		String buy_date = request.getParameter("buy_date");
		
		buying.setCust_no(cust_no);
		buying.setBuy_date(buy_date);
		
		
		// 구매 상세 페이지 정보
		SLBuying buyingDetail = slService.buyingDetail(buying);
		System.out.println("buyingDetail >>>>>>" + buyingDetail);
		
		
		// 구매 제품 정보 리스트
		List<SLBuying> productDetail = slService.productDetail(buying);
		System.out.println("productDetail >>>>>>" + productDetail.size());
		System.out.println("productDetail @@@@@@" + productDetail);
		
		
		// 제품 리스트
		List<SLProduct> productList = slService.productList();

		System.out.println("buying->" + buying);

		
	
		model.addAttribute("buyingDetail",buyingDetail);
		model.addAttribute("productDetail",productDetail);
		model.addAttribute("productList",productList);
		return "sl/buyDetail";
	}
	
	

	
	// 구매 등록 페이지
	@GetMapping(value = "buyingApply")
	public String buyingApply(SLBuying buying, Model model) {
		


		// 제품 리스트
		List<SLProduct> productList = slService.productList();
		System.out.println("buying->" + buying);

	
		model.addAttribute("productList",productList);
				
		return "sl/buyingApply";
	}
	
	@PostMapping(value = "buyingApplyWrite")
	public String buyingApplyWrite(HttpServletRequest request, SLBuying buying) {
		
		String buy_date =request.getParameter("buy_date");
		int cust_no = Integer.parseInt(request.getParameter("cust_no"));
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		String buy_title = request.getParameter("buy_title");
		String buy_manager =request.getParameter("buy_manager");
		
		buying.setBuy_date(buy_date);
		buying.setCust_no(cust_no);
		buying.setEmp_no(emp_no);
		buying.setBuy_title(buy_title);
		buying.setBuy_manager(buy_manager);
		
		System.out.println("buyingApplyWrite buying *********" + buying);
	
		//int buyingApplyWrite = slService.buyingApplyWrite(buying);
		
		
	return "sl/buying";	
	}
	
	
	
	
	
}
