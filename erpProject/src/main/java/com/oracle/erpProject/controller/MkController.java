package com.oracle.erpProject.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.erpProject.model.Product;
import com.oracle.erpProject.model.mkmodel.mkProduct;
import com.oracle.erpProject.service.mkservice.MK_Service_interface;
import com.oracle.erpProject.service.mkservice.Paging;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;

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
	
	// 검색 조건 리스트 
	
	 @GetMapping("listSearch")
	 public String listSearch(mkProduct product, Model model) {
		 //total 
		 int totProduct = mk_Service_interface.searchedProductTotal(product);
		 System.out.println("MK_Controller listSearch totProduct->"+ totProduct);
		 
		 //paging 작업 
		 Paging page = new Paging(totProduct, product.getCurrentPage());
		 product.setStart(page.getStart());
		 product.setEnd(page.getEnd());
		 
		 List<mkProduct> listSearchProduct = mk_Service_interface.listSearchProduct(product);
		 System.out.println("MK_Controller listSearch listSearchProduct list size->"+ listSearchProduct.size());
		 
		 model.addAttribute("totalProduct",totProduct);
		 model.addAttribute("listProduct",listSearchProduct);
		 model.addAttribute("page",page);
		 
		 return "mk/productRu";
	 }

	
	
	// 제품등록 화면
		  
		  @GetMapping("/productC") 
		  public String productC() {
		  System.out.println("MK Controller productC start");
		 
		return "mk/productC";
	}
		  
	// 제품 등록 
		
		@PostMapping(value="writeProduct")
		public String writeProduct(@ModelAttribute mkProduct product, @RequestParam("uploadFile") MultipartFile file, HttpServletRequest request,  RedirectAttributes redirectAttributes) {
			
			System.out.println("MK_Controller WriteProduct start...");
			System.out.println("product data->"+product);
			
			//파일 저장 경로 설정 
			String uploadFolder = request.getSession().getServletContext().getRealPath("/upload/");
			
			if (!file.isEmpty()) {
				String originalFilename = file.getOriginalFilename(); // 원본 파일명
				String extension = originalFilename.substring(originalFilename.lastIndexOf(".")); // 파일 확장자
				String savedFilename = UUID.randomUUID().toString()+extension;
				
				//파일 저장 경로와 파일명을 합쳐 File 객체 생성 
				File saveFile = new File(uploadFolder,savedFilename);
				
				try {
					file.transferTo(saveFile); // 파일 저장 
					product.setP_image(savedFilename); 
				} catch (Exception e) {
					e.printStackTrace();
					redirectAttributes.addFlashAttribute("message","파일 업로드 실패");
					return "redirect:/productC";
				}
			}
			
			//제품 정보 저장 로직 구현 
			int insertResult = mk_Service_interface.insertProduct(product);
			if(insertResult>0)
				return"redirect:productR";
			else {
			
				return "forward:productC";
			}
		}
		
	//제품 등록 ->이미지 등록 
		
	/*
	 * @PostMapping(value="uploadAjaxAction") public String
	 * uploadAjaxPost(@RequestParam("uploadFile") MultipartFile uploadFile,
	 * HttpServletRequest request) { System.out.println("update ajax post");
	 * 
	 * String uploadFolder =
	 * request.getSession().getServletContext().getRealPath("/upload/");
	 * 
	 * System.out.println("---------------------------------");
	 * System.out.println("Upload File Name: " + uploadFile.getOriginalFilename());
	 * System.out.println("Upload File Size: " + uploadFile.getSize());
	 * 
	 * String uploadFileName = uploadFile.getOriginalFilename();
	 * 
	 * // IE에서는 파일 경로가 포함되어 있으므로, 마지막 '\' 이후의 이름만 추출 uploadFileName =
	 * uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
	 * System.out.println("only file name: " + uploadFileName);
	 * 
	 * File saveFile = new File(uploadFolder, uploadFileName);
	 * 
	 * try { uploadFile.transferTo(saveFile); // 여기서 데이터베이스에 저장하는 로직을 추가 mkProduct
	 * product = new mkProduct(); product.setP_image(uploadFolder);
	 * mk_Service_interface.saveProductImagePath(product); return
	 * "redirect:/productC"; } catch (Exception e) {
	 * System.out.println("file exception ->" + e.getMessage()); return
	 * "redirect:/productC"; } // end catch }
	 */
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
