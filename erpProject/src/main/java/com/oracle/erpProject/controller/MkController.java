package com.oracle.erpProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.erpProject.model.Product;
import com.oracle.erpProject.service.mkservice.MK_Service_interface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MkController {

	private final MK_Service_interface mk_Service_interface;
	//제품 조회, 수정
	@GetMapping("/productR")
	public String productR(Product product,Model model) {
		System.out.println("MK Controller productR Start...");
		  List<Product> listProduct = mk_Service_interface.listProduct(product);
		  System.out.println("MKController listProduct.size->"+listProduct.size());
		  
		  model.addAttribute("listProduct",listProduct); 
		  return "mk/productRu";
		  } 
	
	// 제품등록
		  
		  @GetMapping("/productC") 
		  public String productC() {
		  System.out.println("MK Controller productC start");
		 
		return "mk/productRu";
	}
	// 공장 조회
	@GetMapping("/factoryR")
	public String factoryR() {
		System.out.println("MK Controller factoryR start");
		return "mk/factoryR";
	}
	
	// 공장 등록
	@GetMapping("/factoryC")
	public String factoryC() {
		System.out.println("MK Controller factoryC start");
		return "mk/factoryC";
	}
	
	
	// 공장 수정
	@GetMapping("/factoryU")
	public String factoryU() {
		System.out.println("MK Controller factoryU start");
		return "mk/factoryU";
	}
	
	// 거래처 조회
	@GetMapping("/customerR")
	public String custromerR() {
		System.out.println("MK Controller customerR start");
		return "mk/customerR";
	}
	
	// 거래처 등록
	@GetMapping("/customerC")
	public String custromerC() {
		System.out.println("MK Controller customerC start");
		return "mk/customerC";
	}
	
	// 거래처 수정
	@GetMapping("/customerU")
	public String custromerU() {
		System.out.println("MK Controller custromerU start");
		return "mk/customerU";
	}
}
