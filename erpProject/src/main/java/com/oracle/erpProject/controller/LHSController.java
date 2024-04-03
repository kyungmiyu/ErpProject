package com.oracle.erpProject.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.erpProject.model.lhsmodel.Employee;
import com.oracle.erpProject.model.lhsmodel.Product;
import com.oracle.erpProject.model.lhsmodel.Stock;
import com.oracle.erpProject.service.lhsservice.LHSPaging;
import com.oracle.erpProject.service.lhsservice.LHS_Serivce;

import lombok.RequiredArgsConstructor;

@Controller 
@RequiredArgsConstructor
public class LHSController {
	
	private final LHS_Serivce lhs;
	
	// 테스트용 사원리스트 조회
	@RequestMapping(value="lhs")
	public String lhsListEmp(Model model) {
		
		System.out.println("lhsController lhsListEmp start...");
		
		List<Employee> listEmp = lhs.getListEmp();
		
		model.addAttribute("listEmp", listEmp);
		
		return "lhs/listEmp";
	}
	
	// 테스트용 사원 인덱스
	@RequestMapping(value="lhsIndex")
	public String lhsIndex(Employee emp, Model model) {
		
		System.out.println("lhsController lhsIndex start...");
		
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		model.addAttribute("empData", empData);

		return "lhs/index";
	} 
	
	
/* ************************************************************************** */
	/*  월 재고조회 */
	
	// 월 재고조회 (기초기말)
	@RequestMapping(value="lhsListStock")
	public String lhsListStock (Stock stock, Employee emp, Model model) {
		
		System.out.println("lhsController lhsListStock start...");
		
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		// sysdate 년월만 string으로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String formattedDate = dateFormat.format(new Date());
		
		//  if 날짜 = null -> set sysdate, else -> set data
		if (stock.getSt_year_month() == null) {
			stock.setSt_year_month(formattedDate);
		}
		
		System.out.println("check: " + stock.getSt_year_month());
		System.out.println("check: " + stock.getSt_begin_end());
		// 월 재고 total수 조회
		int totalStock = lhs.getTotalStock(stock);
		
		// pagingg
		LHSPaging page = new LHSPaging(totalStock, stock.getCurrentPage());
		stock.setStart(page.getStart());
		stock.setEnd(page.getEnd());
		
		// 재고 리스트 가져오기
		List<Stock> listStock = lhs.getListStock(stock);
		
		model.addAttribute("empData", empData);
		model.addAttribute("stock", stock);
		model.addAttribute("totalStock", totalStock);
		model.addAttribute("listStock", listStock);
		model.addAttribute("page", page);
		
		return "lhs/listStock";
		
	}

		
		
/* ************************************************************************** */
	/*  재고등록 */
		
	// 재고등록 관리 ((폼 따로 x -> 폼 이동만 관리)
	@RequestMapping(value="lhsManageFormRegistStock")
	public String lhsManageFormRegistStock(Employee emp, Model model) {
		
		System.out.println("lhsController lhsManageFormRegistStock start...");
		
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		LocalDate currentDate = LocalDate.now();

	    // 현재 날짜가 25일보다 작은지 확인
	    if (currentDate.getDayOfMonth() < 25) {
	        // 25일 미만인 경우
	        return "redirect:lhsFormRegistStockBegin?emp_no=" + emp.getEmp_no();
	    } else {
	        // 25일 이상인 경우
	        return "redirect:lhsFormRegistStockSurvey?emp_no=" + emp.getEmp_no();
	    }
		
	}
	
	// 기초재고 등록 폼
	@RequestMapping(value="lhsFormRegistStockBegin")
	public String lhsResgistStockBegin(Stock stock, Employee emp, Model model) {
		
		System.out.println("lhsController lhsFormRegistStockBegin start...");
		
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		// sysdate 년월만 string으로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String formattedDate = dateFormat.format(new Date());
		
		//  if 날짜 = null -> set sysdate, else -> set data
		if (stock.getSt_year_month_day() == null) {
			stock.setSt_year_month_day(formattedDate);
		}
		
		model.addAttribute("stock", stock);
		model.addAttribute("empData", empData);
		
		return "lhs/formRegistStockBegin";
		
/* 
formRegistStockBegin ㅡ 기초재고 등록버튼 클릭 -> href: lhsFormRegistStockBegin
                        실사재고조사 등록버튼 클릭 -> href: lhsFormRegistStockSurvey
                        날짜선택 -> #selectMonth by ajax (lhsFormRegistStockBegin)
                        등록버튼 클릭 -> #registTemporary by ajax
                        저장버튼 클릭 -> #registReal by ajax (lhsRegistStockBegin)
*/
	}
	
	// 제품등록 확인
	@ResponseBody
	@RequestMapping(value="lhsCheckNewItem")
	public String lhsCheckNewItem(Product product, Employee emp, Model model) {
		
		System.out.println("lhsController lhsCheckNewItem start...");
		
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		// 신제품이 구매로 들어온건지 생산으로 들어온건지 체크
		// 구매 table에 있는지 먼저 체크 -> null이면 생산table과 조인한 데이터 받기
		// 								not null이면 구매table과 조인한 데이터 받기
		
		System.out.println("check itemcode: " + product.getP_itemcode());
		Product checkProduct = lhs.checkProductBuy(product);
		if (checkProduct == null) {
			checkProduct = lhs.checkProductMake(product);
		}
		
		ObjectMapper mapper = new ObjectMapper();
	    String jsonData = "";
	    try {
	        // product 객체를 JSON 문자열로 변환
	        jsonData = mapper.writeValueAsString(checkProduct);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return jsonData;
	}
	
	// 기초재고 등록
	@RequestMapping(value="lhsRegistStockBegin")
	public String lhsRegistStockBegin(Employee emp, Model model) {
		
		// 민경님 신제품 데이터 받아서 사용
		
		/* 
		lhs.insertStock();
		*/
		
		return "redirect:lhsListStock";
	}
	
	// 실사재고조사 등록 폼
	@RequestMapping(value="lhsFormRegistStockSurvey")
	public String lhsFormRegistStockSurvey(Employee emp, Model model) {
		
		System.out.println("lhsController lhsFormRegistStockBegin start...");
		
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		//  if 날짜 = null -> set sysdate, else -> set data
		
		model.addAttribute("empData", empData);
		// if 날짜 = null -> set sysdate, else -> set data
		
		/*
		lhs.getListStock // 조건: 날짜, 구분=1 (기말)
		*/
		
		return "lhs/formRegistStockSurvey";
		
		/*
formRegistStockSurvey ㅡ // RnP_closing status=1 체크 -> alert로 경고
         기초재고 등록버튼 클릭 -> href: lhsFormRegistStockBegin
                         실사재고조사 등록버튼 클릭 -> href: lhsFormRegistStockSurvey
                         날짜선택 -> #selectMonth by ajax (lhsFormRegistStockSurvey)
                         등록버튼 클릭 -> #registTemporary by ajax
                         저장버튼 클릭 -> #registReal by ajax (lhsRegistStockSurvey) 
                         					// RnP_closing status=1 아니면 ajax fail처리
*/
	}
	
	// 실사재고조사 등록
	@RequestMapping(value="lhsRegistStockSurvey")
	public String lhsRegistStockSurvey(Employee emp, Model model) {
		
		// RnP_closing status=1 체크
		
/*
프로시져 패키시 실행?
if select StockSurvey = null -> insertStockSurvey
                       	else if select StockSurvey != null -> updateStockSurvey // 조건: 날짜
                       redirect: lhsListRnpCondBuy (월말마감 누르려고)

*/
		return "redirect: lhsListRnpCondBuy"; // 월말마감 버튼 누르려고
	}
	
	
	
/* ************************************************************************** */
	/* 수불 일일내역 */
	
	// 수불 일일내역1 (구매)
	@RequestMapping(value="lhsListRnPCondBuy")
	public String lhsListRnPCondBuy() {
		
		//  if 날짜 = null -> set sysdate, else -> set data
		
		/*
        getListRnPCondBuy // 조건: 날짜
		*/
		
		return "lhs/listRnPCondBuy";
		
/*
listRnPCondBuy ㅡ 날짜선택 ->#selectMonth by ajax (lhsListRnPCondBuy)
                상단버튼 클릭 -> href: 각 버튼 폼으로 이동 (재고조사 버튼은 sysdate > 25일일때만 visible)
                마감버튼 클릭 -> href: lhsDailyClosing
                해제버튼 클릭 -> href: lhsClosingCancel
                월말마감버튼 클릭 -> href: lhsMonthlyClosing
*/
	}
	
	// 수불 일일내역2 (판매)
	@RequestMapping(value="lhsListRnPCondSale")
	public String lhsListRnPCondSale() {
		
		//  if 날짜 = null -> set sysdate, else -> set data
		
		/*
        getListRnPCondBuy // 조건: 날짜
		*/
		
		return "lhs/listRnPCondSale";
		
/*
listRnPCondBuy ㅡ 날짜선택 ->#selectMonth by ajax (lhsListRnPCondBuy)
                상단버튼 클릭 -> href: 각 버튼 폼으로 이동 (재고조사 버튼은 sysdate > 25일일때만 visible)
                마감버튼 클릭 -> href: lhsDailyClosing
                해제버튼 클릭 -> href: lhsClosingCancel
                월말마감버튼 클릭 -> href: lhsMonthlyClosing
*/
	}

	// 수불 일일내역3 (생산)
	@RequestMapping(value="lhsListRnPCondMake")
	public String lhsListRnPCondMake() {
		
		//  if 날짜 = null -> set sysdate, else -> set data
		
		/*
        getListRnPCondBuy // 조건: 날짜
		*/
		
		return "lhs/listRnPCondMake";
		
/*
listRnPCondBuy ㅡ 날짜선택 ->#selectMonth by ajax (lhsListRnPCondBuy)
                상단버튼 클릭 -> href: 각 버튼 폼으로 이동 (재고조사 버튼은 sysdate > 25일일때만 visible)
                마감버튼 클릭 -> href: lhsDailyClosing
                해제버튼 클릭 -> href: lhsClosingCancel
                월말마감버튼 클릭 -> href: lhsMonthlyClosing
*/
	}
	
	// 수불 일일내역4 (재고조사)
	@RequestMapping(value="lhsListRnPCondSurvey")
	public String lhsListRnPCondSurvey() {
		
		//  if 날짜 = null -> set sysdate, else -> set data
		
		/*
        getListRnPCondBuy // 조건: 날짜
		*/
		
		return "lhs/listRnPCondSurvey";
		
/*
listRnPCondBuy ㅡ 날짜선택 ->#selectMonth by ajax (lhsListRnPCondBuy)
                상단버튼 클릭 -> href: 각 버튼 폼으로 이동 (재고조사 버튼은 sysdate > 25일일때만 visible)
                마감버튼 클릭 -> href: lhsDailyClosing
                해제버튼 클릭 -> href: lhsClosingCancel
                월말마감버튼 클릭 -> href: lhsMonthlyClosing
*/
	}
	
	// 일일마감 버튼
	@RequestMapping(value="lhsDailyClosing")
	public String lhsDailyClosing() {
		
		/*
		lhs.dailyClosing (프로시져 패키지 실행)
		-> 1. 구매, 판매, 생산 status update (일반완료 -> 수불완료) --- updateStatusBuy5
					// 조건: 날짜, status=일반완료
	        2. if select 수불마감 = null -> insert 수불마감 (구분=1) --- insertRnPClosing
	         	  else if select 수불마감 != null -> update 수불마감 (구분 0->1) --- updateStatusRnPClosing1
	        3. select 구매내역 -> Stock 수량 update --- getListRnpCondBuy -> updateStockBuyQuantity
	           select 판매내역 -> Stock 수량 update --- getListRnpCondSale -> updateStockSaleQuantity
	           select 생산내역 -> Stock 수량 update --- getListRnpCondMake -> updateStockMakeQuantity
		*/
		
		return "redirect: lhsListStock";
	}
	
	// 마감취소 버튼
	@RequestMapping(value="lhsClosingCancel")
	public String lhsClosingCancel() {
		
		/*
		lhs.closingCancel (프로시져 패키시 실행)
		 -> 1. 구매, 판매, 생산 status update (수불완료 -> 일반완료) --- updateStatusBuy4
				  	  // 조건: 날짜, status=수불완료
	          2. update 수불마감 (구분 1,2->0) --- updateStatusRnPClosing0
	          3. select 구매내역 -> Stock 수량 update --- getListRnpCondBuy -> restoreStockBuyQuantity
	             select 판매내역 -> Stock 수량 update --- getListRnpCondSale -> restoreStockSaleQuantity
	             select 생산내역 -> Stock 수량 update --- getListRnpCondMake -> restoreStockMakeQuantity
		*/
		
		return "redirect: lhsListStock";
	}
	
	// 월말마감 버튼
	@RequestMapping(value="lhsMonthlyClosing")
	public String lhsMonthlyClosing() {
		
		/*
		lhs.monthlyClosing (프로시져 패키지 실행) // 수불마감구분=1인지 체크
		-> 구매, 판매, 생산 stauts=5인지 체크
	        수불마감구분=1인지 체크
	         1. 수불마감구분 update --- updateStatusRnPClosing2
	         2. 재고조사 조회 --- getListStockSurvey
			 3. 재고수량 update --- updateStockAllQuantity
	         4. 다음달 재고 insert --- insertStockNextMonth
		*/
		
		return "redirect: lhsListStock";
	}
	

} // class
