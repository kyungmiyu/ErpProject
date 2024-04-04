package com.oracle.erpProject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.erpProject.model.slmodel.SLBuying;
import com.oracle.erpProject.model.slmodel.SLBuying_detail;
import com.oracle.erpProject.service.slservice.SL_Service_Interface;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SLLestController {
	
	private final SL_Service_Interface slService;
	
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
	public void buyingDetailModify( SLBuying_detail sLBuying_detail  ) { 
		
		System.out.println("sLBuying_detail: " + sLBuying_detail);
		
		int addProduct = slService.addProduct(sLBuying_detail);

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
	
	
	

}
