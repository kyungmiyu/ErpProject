package com.oracle.erpProject.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.oracle.erpProject.model.slmodel.SLBuying;
import com.oracle.erpProject.model.slmodel.SLBuying_detail;
import com.oracle.erpProject.service.slservice.SL_Service_Interface;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SLLestController {
	
	private final SL_Service_Interface slService;
	
	// 수불 마감 여부
	@GetMapping("/closingStatus")
	public int closingStatu(SLBuying buying) {
		
		LocalDate today = LocalDate.now(); 
		String formattedDate =today.format(DateTimeFormatter.BASIC_ISO_DATE);
		buying.setRnpc_year_month_day(formattedDate);
		 
		int closingStatu = slService.closingStatu(buying);
		
		System.out.println("수불 마감 여부 +++++++++++" + closingStatu);
		return closingStatu;
	}
	
	
	
	@GetMapping("/getProductList")
	public List<SLBuying_detail>getProductList(SLBuying_detail sLBuying_detail) {
		System.out.println("getProductList sLBuying_detail" + sLBuying_detail);
		List<SLBuying_detail> getProductList = slService.getProductList(sLBuying_detail);
		
		System.out.println("getProductList getProductList" + getProductList);
	
		return getProductList;
	}
	
	// 구매 상세페이지 수정
	@PostMapping("/buyingModify")
	public int buyingModify (@RequestBody  SLBuying buying) {
	//	public int buyingModify (SLBuying buying) {
		System.out.println("buyingModify buying ##########" + buying);
	int  buyingModify = slService.buyingModify(buying);
	System.out.println("RestController  buyingModify buying buyingModify->" + buyingModify);
	
	return buyingModify;	
	}
	
	
	
	// 구매 상세페이지 제품 추가
		@PostMapping("/addProduct")
		public int buyingDetailModify(SLBuying_detail sLBuying_detail  ) { 
			
			System.out.println("sLBuying_detail: " + sLBuying_detail);
		
			int addProduct = slService.addProduct(sLBuying_detail);
			return addProduct;
		}
	
	// 구매 상세페이지 제품 수정
	@PostMapping("/productCntModify")
	public int productCntModify(@RequestBody SLBuying_detail sLBuying_detail) {
		System.out.println("deleteProduct productCntModify >>>>>" + sLBuying_detail);
		int  productCntModify = slService.productCntModify(sLBuying_detail);
		System.out.println("deleteProduct productCntModify >>>>>" + productCntModify);
		
		return productCntModify;
	}
	
	
	
	// 구매 상세페이지 제품 삭제
	@PostMapping("/deleteProduct") 
	public int deleteProduct(SLBuying_detail sLBuying_detail ) {
		System.out.println("deleteProduct SLBuying_detail >>>>>" + sLBuying_detail);
		
		
		int deleteProduct = slService.deleteProduct(sLBuying_detail);
		
		return deleteProduct;
	}
	
	
	// 구매 진행 상태 변경
	@PostMapping("/buyStatusChange")
	public int buyStatusChange(@RequestBody SLBuying buying) {
		
		int buyStatusChange = slService.buyStatusChange(buying);
		
		return buyStatusChange;
	}
	
	
	// 구매 등록 페이지 거래처 검색
	@PostMapping("/customerSearch")
	public SLBuying customerSearch(@RequestBody SLBuying buying) {
		SLBuying customerSearch = slService.customerSearch(buying);
		
		System.out.println("customerSearch>>>>>>>>>" + customerSearch);
	
		return customerSearch;
	}
	
	// 구매 등록 페이지 매니저 옵션 
	@GetMapping("getManagerList")
	public List<SLBuying> getManagerList(SLBuying buying) {
		List<SLBuying> getManagerList = slService.getManagerList(buying);
		
		System.out.println("SLLestController getManagerList>>>>>>>>>" + getManagerList.size());
		
		return getManagerList;
	}

	
	/*
	 * @GetMapping("/checkBuyData") public SLBuying
	 * checkBuyData(@RequestParam("cust_no") int custNo) {
	 * 
	 * SLBuying buying = new SLBuying();
	 * 
	 * LocalDate today = LocalDate.now(); 
	 * String formattedDate =today.format(DateTimeFormatter.BASIC_ISO_DATE);
	 * buying.setBuy_date(formattedDate); buying.setCust_no(custNo);
	 * 
	 * 
	 * SLBuying checkBuyData = slService.checkBuyData(buying);
	 * System.out.println("SLLestController checkBuyData *********" + checkBuyData);
	 * 
	 * return checkBuyData; }
	 */
	
	
	
	@PostMapping("/buyingApplyWrite")
	public String buyingApplyWrite(@RequestBody SLBuying buying) {
	    
		System.out.println("SLLestController buyingApplyWrite Start >>>>>");

		
		 System.out.println("SLLestController buyingApplyWrite SLBuing >>>>>" +buying);
		 

	    int result = slService.buyingApplyWrite(buying);
	    
	    if (result > 0) {
	        return "redirect:/buying";
	    } else {
	        return "error";
	    }
	}
	
	   
 
 
    
	

}