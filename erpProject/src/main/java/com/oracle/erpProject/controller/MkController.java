package com.oracle.erpProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.erpProject.model.Product;
import com.oracle.erpProject.model.mkmodel.mkProduct;
import com.oracle.erpProject.service.mkservice.MK_Service_interface;
import com.oracle.erpProject.service.mkservice.Paging;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MkController {

	private final MK_Service_interface mk_Service_interface;
	//제품 조회, 수정
	@GetMapping("/productR")
	public String productR(mkProduct product,Model model) {
		System.out.println("MK Controller productR Start...");
		//product count 
		int totalProduct = mk_Service_interface.totalProduct(product);
		System.out.println("MK_Controller Start totalProduct->"+totalProduct);
		
		//paging 작업 
		Paging page = new Paging(totalProduct, product.getCurrentPage());
		product.setStart(page.getStart()); //시작시 1 
		product.setEnd(page.getEnd()); // 시작시 10 
		
		  List<mkProduct> listProduct = mk_Service_interface.listProduct(product);
		  System.out.println("MKController listProduct.size->"+listProduct.size());
		  
		  model.addAttribute("listProduct",listProduct); 
		  model.addAttribute("page", page);
		  model.addAttribute("totalProduct",totalProduct);
		  return "mk/productRu";
		  } 
	
	
	//제품 상세 ajax 
	@ResponseBody
	@GetMapping("productDetail")
	public mkProduct productDetail(@RequestParam("p_itemcode") int itemCode ,mkProduct product, Model model ) {
		System.out.println("MK Controller productDetail Start");
	
		mkProduct ProductDetail =null;
		product.setP_itemcode(itemCode);
		
		System.out.println("MK Controller productDetail->"+product);
		ProductDetail = mk_Service_interface.getProductDetail(product);
		model.addAttribute("product",ProductDetail);
	
		return ProductDetail;
	}

	
	
	// 제품등록 화면
		  
		  @GetMapping("/productC") 
		  public String productC() {
		  System.out.println("MK Controller productC start");
		 
		return "mk/productC";
	}
		  
	// 제품 등록 
		  
		@PostMapping(value="writeProduct")
		public String writeProduct(mkProduct product, Model model) {
			System.out.println("MK_Controller WriteProduct start...");
			
			int insertResult = mk_Service_interface.insertProduct(product);
			if(insertResult>0)
				return"redirect:mk/productRu";
			else {
				model.addAttribute("msg","입력 실패 확인해 보세요");
				return "forward:mk/productC";
			}
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
