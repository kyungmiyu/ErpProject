package com.oracle.erpProject.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.erpProject.model.Product;
import com.oracle.erpProject.model.mkmodel.mkFactory;
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
		  return "mk/productR";
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
		 
		 return "mk/productR";
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
		
		//제품 수정 폼 
		@GetMapping("productU")
		public String productU(mkProduct product,Model model) {
			System.out.println("MK Controller productR Start...");
			System.out.println("MK Controller productR ->"+product);
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
			
			return "mk/productU";
		}
	 
		// 제품 수정 로직 
		
		@PostMapping("updateProduct")
		public String updateProduct(@ModelAttribute mkProduct product, @RequestParam("uploadFile") MultipartFile file, HttpServletRequest request,  RedirectAttributes redirectAttributes) {
	
				System.out.println("MK_Controller UpdateProductProduct start...");
				System.out.println("product Update data->"+product);
				
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
				int updateResult = mk_Service_interface.UpdataProduct(product);
				if(updateResult>0)
					return"redirect:productU";
				else {
				
					return "forward:productU";
				}
			}
		
	// 공장 조회
	@GetMapping("/factoryR")
	public String factoryR(mkFactory factory,Model model) {
		System.out.println("MK Controller factoryR start");
		//product count 
				int totalFactory = mk_Service_interface.totalFactory(factory);
				System.out.println("MK_Controller Start totalFactory->"+totalFactory);
				
				//paging 작업 
				Paging page = new Paging(totalFactory, factory.getCurrentPage());
				factory.setStart(page.getStart()); //시작시 1 
				factory.setEnd(page.getEnd()); // 시작시 10 
				
				  List<mkFactory> listFactory = mk_Service_interface.listFactory(factory);
				  System.out.println("MKController listFactory.size->"+listFactory.size());
				  
				  model.addAttribute("listProduct",listFactory); 
				  model.addAttribute("page", page);
				  model.addAttribute("totalProduct",totalFactory);
			
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
