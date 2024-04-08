package com.oracle.erpProject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.erpProject.model.lhsmodel.Employee;
import com.oracle.erpProject.model.lhsmodel.Product;
import com.oracle.erpProject.model.lhsmodel.RnP_closing;
import com.oracle.erpProject.model.lhsmodel.Stock;
import com.oracle.erpProject.model.lhsmodel.Stock_survey;
import com.oracle.erpProject.service.lhsservice.LHSPaging;
import com.oracle.erpProject.service.lhsservice.LHS_Serivce;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LHSController {

	private final LHS_Serivce lhs;

	// 테스트용 사원리스트 조회
	@RequestMapping(value = "lhs")
	public String lhsListEmp(Model model) {

		System.out.println("lhsController lhsListEmp start...");

		// 사원리스트 조회
		List<Employee> listEmp = lhs.getListEmp();

		model.addAttribute("listEmp", listEmp);

		return "lhs/listEmp";
	}

	// 테스트용 사원 인덱스
	@RequestMapping(value = "lhsIndex")
	public String lhsIndex(Employee emp, Model model) {

		System.out.println("lhsController lhsIndex start...");

		// 사원데이터 조회
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		System.out.println("getDataEmp emp_name-> " + empData.getEmp_name());

		model.addAttribute("empData", empData);

		return "lhs/index";
	}

	
	/****************************************************************************/
		/* 월 재고조회 */

	
	// 월 재고조회 (기초기말)
	@RequestMapping(value = "lhsListStock")
	public String lhsListStock(Stock stock, Employee emp, Model model) {

		System.out.println("lhsController lhsListStock start...");
		
		// 사원데이터 조회
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		// sysdate 년월만 string으로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String formattedDate = dateFormat.format(new Date());

		// 날짜 = null이면 sysdate 세팅
		if (stock.getSt_year_month() == null) {
			stock.setSt_year_month(formattedDate);
		}

		// 월 재고 total수 조회
		int totalStock = lhs.getTotalStock(stock);
		System.out.println("getTotalStock totalStock-> " + totalStock);
		
		// pagingg
		LHSPaging page = new LHSPaging(totalStock, stock.getCurrentPage());
		stock.setStart(page.getStart());
		stock.setEnd(page.getEnd());

		// 재고 리스트 가져오기
		List<Stock> listStock = lhs.getListStock(stock);
		System.out.println("getListStock listSize-> " + listStock.size());
		
		model.addAttribute("empData", empData);
		model.addAttribute("stock", stock);
		model.addAttribute("listStock", listStock);
		model.addAttribute("page", page);

		return "lhs/listStock";

	}

	
	/****************************************************************************/
		/* 재고등록 관리 */

	
	// 재고등록 관리 ((폼 따로 x -> 폼 이동만 관리)
	@RequestMapping(value = "lhsManageFormRegistStock")
	public String lhsManageFormRegistStock(Employee emp, Model model) {

		System.out.println("lhsController lhsManageFormRegistStock start...");

		// 사원데이터 조회
		Employee empData = lhs.getDataEmp(emp.getEmp_no());

		LocalDate currentDate = LocalDate.now();

		// 현재 날짜가 25일보다 작은지 확인
		if (currentDate.getDayOfMonth() < 25) {
			// 25일 미만인 경우
			return "redirect:lhsFormRegistStockNewItem?emp_no=" + emp.getEmp_no();
		} else {
			// 25일 이상인 경우
			return "redirect:lhsFormRegistStockSurvey?emp_no=" + emp.getEmp_no();
		}

	}

	
	/****************************************************************************/
		/* 기초재고조사 등록 */
	
	
	// 기초재고 등록 폼
	@RequestMapping(value = "lhsFormRegistStockNewItem")
	public String lhsResgistStockBegin(Stock stock, Employee emp, Model model) {

		System.out.println("lhsController lhsFormRegistStockNewItem start...");

		// 사원데이터 조회
		Employee empData = lhs.getDataEmp(emp.getEmp_no());

		// sysdate 년월일만 string으로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String formattedDate = dateFormat.format(new Date());

		// 날짜 = null이면 sysdate 세팅
		if (stock.getSt_year_month_day() == null) {
			stock.setSt_year_month_day(formattedDate);
		}

		model.addAttribute("stock", stock);
		model.addAttribute("empData", empData);

		return "lhs/formRegistStockNewItem";

		/*
		 * formRegistStockBegin ㅡ 기초재고 등록버튼 클릭 -> href: lhsFormRegistStockBegin 실사재고조사
		 * 등록버튼 클릭 -> href: lhsFormRegistStockSurvey 날짜선택 -> #selectMonth by ajax
		 * (lhsFormRegistStockBegin) 등록버튼 클릭 -> #registTemporary by ajax 저장버튼 클릭 ->
		 * #registReal by ajax (lhsRegistStockBegin)
		 */
	}

	// 신제품 등록여부 확인
	@ResponseBody
	@RequestMapping(value = "lhsCheckExistenceNewItem")
	public Product lhsCheckNewItem(Product product, Employee emp, Model model) {

		System.out.println("lhsController lhsCheckExistenceNewItem start...");

		// 신제품 등록여부 조회
		Product checkProduct = lhs.checkExistenceNewItem(product);
		System.out.println("checkExistenceNewItem p_name-> " + checkProduct.getP_name());
		
		return checkProduct;
	}

	// 신제품 기초재고 등록
	@RequestMapping(value = "lhsRegistStockNewItem")
	public String lhsRegistStockNewItem(@RequestBody List<Stock> listStock, Employee emp, Model model) {

		System.out.println("lhsController lhsRegistStockNewItem start...");

		int resultRegistStock = 0;
		int resultCntRegistStock = 0;
		
		int resultRegistRnPClosing = 0;
		int resultCntRegistRnPClosing = 0;
		
		// 신제품 기초재고, 수불마감 등록 확인
		for (Stock stock : listStock) { 
			resultRegistStock = lhs.registStockNewItem(stock);
			if (resultRegistStock == 1) resultCntRegistStock+=1; 
			
			resultRegistRnPClosing = lhs.registRnPClosingNewItem(stock);
			if (resultRegistRnPClosing == 1) resultCntRegistRnPClosing+=1;
		}
		  
		System.out.println("registStockNewItem resultCnt-> " + resultCntRegistStock);
		System.out.println("registRnPClosingNewItem resultCnt-> " + resultCntRegistRnPClosing);

		return "redirect:lhsListStock?emp_no=" + emp.getEmp_no();
	}
	
	
	/****************************************************************************/
		/* 실사 재고조사 등록 */

	
	// 실사재고조사 등록 폼
	@RequestMapping(value = "lhsFormRegistStockSurvey")
	public String lhsFormRegistStockSurvey(Stock stock, Employee emp, Model model) {

		System.out.println("lhsController lhsFormRegistStockSurvey start...");

		// 사원데이터 조회
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		// sysdate 년월일만 string으로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String formattedDate = dateFormat.format(new Date());

		// 날짜 = null이면 sysdate 세팅
		if (stock.getSt_year_month_day() == null) {
			stock.setSt_year_month_day(formattedDate);
		}

		model.addAttribute("stock", stock);
		model.addAttribute("empData", empData);

		return "lhs/formRegistStockSurvey";
	}
	
	// 실사재고조사용 물품리스트 조회
	@ResponseBody
	@RequestMapping(value = "lhsListItem")
	public List<Stock> lhsListItem(Stock stock, Employee emp, Model model) {
		
		System.out.println("lhsController lhsListItem start...");
		
		// 월 재고 total수 조회
		int totalStock = lhs.getTotalStock(stock);
		System.out.println("getTotalStock totalStock-> " + totalStock);
		
		// paging
		stock.setStart(1);
		stock.setEnd(totalStock);

		// 재고리스트 조회
		List<Stock> listStock = lhs.getListStock(stock);
		System.out.println("getListStock listSize-> " + listStock.size());
		
		return listStock;
	}
	
	// 실사재고조사용 물품 상세정보 조회
	@ResponseBody
	@RequestMapping(value = "lhsGetDataProduct")
	public Product lhsGetDataProduct(Product product, Model model) {
		System.out.println("lhsController lhsGetDataProduct start...");
		
		// 제품정보 조회
		Product productData = lhs.getDataProduct(product);
		System.out.println("getDataProduct p_itemcode-> " + productData.getP_itemcode());
		
		return productData; 
		
	}

	// 실사재고조사 등록	-- 미완
	@RequestMapping(value = "lhsRegistStockSurvey")
	public String lhsRegistStockSurvey(@RequestBody List<Stock_survey> listSurvey, Stock stock, Employee emp, Model model) {

		System.out.println("lhsController lhsRegistStockSurvey start...");
		System.out.println("check listSurvey: " + listSurvey);
		
		// 사원데이터 조회
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		// 1. RnP_closing status=1 체크

		// sysdate 년월일만 string으로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String formattedDate = dateFormat.format(new Date());
		stock.setSt_year_month_day(formattedDate);
		stock.setSt_year_month(formattedDate.substring(0, formattedDate.length() - 2));
		
		// 1. 오늘 수불마감 여부 체크 (선택한날짜 x)
		int checkStatus = lhs.checkStatusRnPClosing(stock);
		System.out.println("checkStatusRnPClosing checkStatus->" + checkStatus);
		
		if (checkStatus == 0) {
			System.out.println("수불마감 먼저해");
		} else if (checkStatus == 1) {
			
			// 2. 재고조사 데이터가 이미 있는지 체크
			// 2. if select StockSurvey = null -> insertStockSurvey 
			//    else if select StockSurvey != null -> updateStockSurvey

			Stock_survey checkStockSurvey = lhs.checkExistenceStockSurvey(stock);
			System.out.println("checkExistenceStockSurvey checkStockSurvey-> " + checkStockSurvey);
			
			// 넣는 값 일일이 넣기
			if (checkStockSurvey == null) {
				int registResult = lhs.registStockSurvey(listSurvey);
				System.out.println("registStockSurvey registResult-> " + registResult);
			}
			else if (checkStockSurvey != null) {
				int updateResult = lhs.updateStockSurvey(listSurvey);
			}
			
		}
		
		
		
		/*
		 * 프로시져 패키시 실행? if select StockSurvey = null -> insertStockSurvey else if select
		 * StockSurvey != null -> updateStockSurvey // 조건: 날짜 redirect:
		 * lhsListRnpCondBuy (월말마감 누르려고)
		 * 
		 */
		return "redirect:lhsListStock?emp_no=" + emp.getEmp_no();// 월말마감 버튼 누르려고
	}
	
	/*
	 * formRegistStockSurvey ㅡ // RnP_closing status=1 체크 -> alert로 경고 기초재고 등록버튼 클릭
	 * -> href: lhsFormRegistStockBegin 실사재고조사 등록버튼 클릭 -> href:
	 * lhsFormRegistStockSurvey 날짜선택 -> #selectMonth by ajax
	 * (lhsFormRegistStockSurvey) 등록버튼 클릭 -> #registTemporary by ajax 저장버튼 클릭 ->
	 * #registReal by ajax (lhsRegistStockSurvey) // RnP_closing status=1 아니면 ajax
	 * fail처리
	 */

	
	/****************************************************************************/
		/* 수불 일일내역 조회 */

	
	// 수불 일일내역1 조회 (구매)
	@RequestMapping(value = "lhsListRnPCondBuy")
	public String lhsListRnPCondBuy(RnP_closing rnpc, Employee emp, Model model) {

		System.out.println("lhsController lhsListRnPCondBuy start...");

		// 사원데이터 조회
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		// sysdate 년월일만 string으로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String formattedDate = dateFormat.format(new Date());

		// 날짜 = null이면 sysdate 세팅
		if (rnpc.getRnpc_year_month_day() == null) {
			rnpc.setRnpc_year_month_day(formattedDate);
		}
		
		// date타입 날짜 가져오기
		try {
			rnpc.setRnpc_date(dateFormat.parse(rnpc.getRnpc_year_month_day()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// 현재날짜 25일 이상인지 체크
		LocalDate currentDate = LocalDate.now();
		int today = currentDate.getDayOfMonth();
	
		// 수불 일일내역(구매) total수 조회
		int totalRnPClosing = lhs.getTotalRnPCondBuy(rnpc);
		System.out.println("getTotalRnPCondBuy totalRnPClosing-> " + totalRnPClosing);
		
		// paging
		LHSPaging page = new LHSPaging(totalRnPClosing, rnpc.getCurrentPage());
		rnpc.setStart(page.getStart());
		rnpc.setEnd(page.getEnd());
		
		// 수불 일일내역(구매) 리스트 조회
		List<RnP_closing> listRnPClosing = lhs.getListRnPCondBuy(rnpc);
		System.out.println("getListRnPCondBuy listSize-> " + listRnPClosing.size());
		
		model.addAttribute("rnpc", rnpc);
		model.addAttribute("today", today);
		model.addAttribute("empData", empData);
		model.addAttribute("listRnPClosing", listRnPClosing);
		model.addAttribute("page", page);
		
		return "lhs/listRnPCondBuy";

		/*
		 * listRnPCondBuy ㅡ 날짜선택 ->#selectMonth by ajax (lhsListRnPCondBuy) 상단버튼 클릭 ->
		 * href: 각 버튼 폼으로 이동 (재고조사 버튼은 sysdate > 25일일때만 visible) 마감버튼 클릭 -> href:
		 * lhsDailyClosing 해제버튼 클릭 -> href: lhsClosingCancel 월말마감버튼 클릭 -> href:
		 * lhsMonthlyClosing
		 */
	}
 
	// 수불 일일내역2 조회 (판매)
	@RequestMapping(value = "lhsListRnPCondSale")
	public String lhsListRnPCondSale(RnP_closing rnpc, Employee emp, Model model) {

		System.out.println("lhsController lhsListRnPCondSale start...");

		// 사원데이터 조회
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		// sysdate 년월일만 string으로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String formattedDate = dateFormat.format(new Date());

		// 날짜 = null이면 sysdate 세팅
		if (rnpc.getRnpc_year_month_day() == null) {
			rnpc.setRnpc_year_month_day(formattedDate);
		}
		
		// date타입 날짜 가져오기
		try {
			rnpc.setRnpc_date(dateFormat.parse(rnpc.getRnpc_year_month_day()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		rnpc.setRnpc_filter("판매");
		
		// 현재날짜 25일 이상인지 체크
		LocalDate currentDate = LocalDate.now();
		int today = currentDate.getDayOfMonth();
		
		// 수불 일일내역(판매) total수 조회
		int totalRnPClosing = lhs.getTotalRnPCondSale(rnpc);
		System.out.println("getTotalRnPCondSale totalRnPClosing-> " + totalRnPClosing);
		
		// paging
		LHSPaging page = new LHSPaging(totalRnPClosing, rnpc.getCurrentPage());
		rnpc.setStart(page.getStart());
		rnpc.setEnd(page.getEnd());
		
		// 수불 일일내역(판매) 리스트 조회
		List<RnP_closing> listRnPClosing = lhs.getListRnPCondSale(rnpc);
		System.out.println("getListRnPCondSale listSize-> " + listRnPClosing.size());
		
		model.addAttribute("rnpc", rnpc);
		model.addAttribute("today", today);
		model.addAttribute("empData", empData);
		model.addAttribute("listRnPClosing", listRnPClosing);
		model.addAttribute("page", page);

		return "lhs/listRnPCondSale";

		/*
		 * listRnPCondBuy ㅡ 날짜선택 ->#selectMonth by ajax (lhsListRnPCondBuy) 상단버튼 클릭 ->
		 * href: 각 버튼 폼으로 이동 (재고조사 버튼은 sysdate > 25일일때만 visible) 마감버튼 클릭 -> href:
		 * lhsDailyClosing 해제버튼 클릭 -> href: lhsClosingCancel 월말마감버튼 클릭 -> href:
		 * lhsMonthlyClosing
		 */
	}

	// 수불 일일내역3 조회 (생산)
	@RequestMapping(value = "lhsListRnPCondMake")
	public String lhsListRnPCondMake(RnP_closing rnpc, Employee emp, Model model) {

		System.out.println("lhsController lhsListRnPCondMake start...");

		// 사원데이터 조회
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		// sysdate 년월일만 string으로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String formattedDate = dateFormat.format(new Date());

		// 날짜 = null이면 sysdate 세팅
		if (rnpc.getRnpc_year_month_day() == null) {
			rnpc.setRnpc_year_month_day(formattedDate);
		}
		
		// date타입 날짜 가져오기
		try {
			rnpc.setRnpc_date(dateFormat.parse(rnpc.getRnpc_year_month_day()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		rnpc.setRnpc_filter("생산");
		
		// 현재날짜 25일 이상인지 체크
		LocalDate currentDate = LocalDate.now();
		int today = currentDate.getDayOfMonth();
		
		// 수불 일일내역(생산) total수 조회
		int totalRnPClosing = lhs.getTotalRnPCondMake(rnpc);
		System.out.println("getTotalRnPCondMake totalRnPClosing-> " + totalRnPClosing);
		
		// paging
		LHSPaging page = new LHSPaging(totalRnPClosing, rnpc.getCurrentPage());
		rnpc.setStart(page.getStart());
		rnpc.setEnd(page.getEnd());
		
		// 수불 일일내역(판매) 리스트 조회
		List<RnP_closing> listRnPClosing = lhs.getListRnPCondMake(rnpc);
		System.out.println("getListRnPCondMake listSize-> " + listRnPClosing.size());
		
		model.addAttribute("rnpc", rnpc);
		model.addAttribute("today", today);
		model.addAttribute("empData", empData);
		model.addAttribute("listRnPClosing", listRnPClosing);
		model.addAttribute("page", page);

		return "lhs/listRnPCondMake";

		/*
		 * listRnPCondBuy ㅡ 날짜선택 ->#selectMonth by ajax (lhsListRnPCondBuy) 상단버튼 클릭 ->
		 * href: 각 버튼 폼으로 이동 (재고조사 버튼은 sysdate > 25일일때만 visible) 마감버튼 클릭 -> href:
		 * lhsDailyClosing 해제버튼 클릭 -> href: lhsClosingCancel 월말마감버튼 클릭 -> href:
		 * lhsMonthlyClosing
		 */
	}

	// 수불 일일내역4 조회 (재고조사)
	@RequestMapping(value = "lhsListRnPCondSurvey")
	public String lhsListRnPCondSurvey(RnP_closing rnpc, Employee emp, Model model) {

		System.out.println("lhsController lhsListRnPCondSurvey start...");

		// 사원데이터 조회
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		// sysdate 년월일만 string으로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String formattedDate = dateFormat.format(new Date());

		// 날짜 = null이면 sysdate 세팅
		if (rnpc.getRnpc_year_month_day() == null) {
			rnpc.setRnpc_year_month_day(formattedDate);
		}
		
		// date타입 날짜 가져오기
		try {
			rnpc.setRnpc_date(dateFormat.parse(rnpc.getRnpc_year_month_day()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		rnpc.setRnpc_filter("재고조사");
		
		// 현재날짜 25일 이상인지 체크
		LocalDate currentDate = LocalDate.now();
		int today = currentDate.getDayOfMonth();
		
		// 수불 일일내역(재고조사) total수 조회
		int totalRnPClosing = lhs.getTotalRnPCondSurvey(rnpc);
		System.out.println("getTotalRnPCondSurvey totalRnPClosing-> " + totalRnPClosing);
		
		// paging
		LHSPaging page = new LHSPaging(totalRnPClosing, rnpc.getCurrentPage());
		rnpc.setStart(page.getStart());
		rnpc.setEnd(page.getEnd());
		
		// 수불 일일내역(재고조사) 리스트 조회
		List<RnP_closing> listRnPClosing = lhs.getListRnPCondSurvey(rnpc);
		System.out.println("getListRnPCondSurvey listSize-> " + listRnPClosing.size());
		
		model.addAttribute("rnpc", rnpc);
		model.addAttribute("today", today);
		model.addAttribute("empData", empData);
		model.addAttribute("listRnPClosing", listRnPClosing);
		model.addAttribute("page", page);

		return "lhs/listRnPCondSurvey";

		/*
		 * listRnPCondBuy ㅡ 날짜선택 ->#selectMonth by ajax (lhsListRnPCondBuy) 상단버튼 클릭 ->
		 * href: 각 버튼 폼으로 이동 (재고조사 버튼은 sysdate > 25일일때만 visible) 마감버튼 클릭 -> href:
		 * lhsDailyClosing 해제버튼 클릭 -> href: lhsClosingCancel 월말마감버튼 클릭 -> href:
		 * lhsMonthlyClosing
		 */
	}

	// 일일마감 버튼
	@RequestMapping(value = "lhsDailyClosing")
	public String lhsDailyClosing() {

		/*
		 * lhs.dailyClosing (프로시져 패키지 실행) -> 1. 구매, 판매, 생산 status update (일반완료 -> 수불완료)
		 * --- updateStatusBuy5 // 조건: 날짜, status=일반완료 2. if select 수불마감 = null ->
		 * insert 수불마감 (구분=1) --- insertRnPClosing else if select 수불마감 != null -> update
		 * 수불마감 (구분 0->1) --- updateStatusRnPClosing1 3. select 구매내역 -> Stock 수량 update
		 * --- getListRnpCondBuy -> updateStockBuyQuantity select 판매내역 -> Stock 수량
		 * update --- getListRnpCondSale -> updateStockSaleQuantity select 생산내역 -> Stock
		 * 수량 update --- getListRnpCondMake -> updateStockMakeQuantity
		 */

		return "redirect: lhsListStock";
	}

	// 마감취소 버튼
	@RequestMapping(value = "lhsClosingCancel")
	public String lhsClosingCancel() {

		/*
		 * lhs.closingCancel (프로시져 패키시 실행) -> 1. 구매, 판매, 생산 status update (수불완료 -> 일반완료)
		 * --- updateStatusBuy4 // 조건: 날짜, status=수불완료 2. update 수불마감 (구분 1,2->0) ---
		 * updateStatusRnPClosing0 3. select 구매내역 -> Stock 수량 update ---
		 * getListRnpCondBuy -> restoreStockBuyQuantity select 판매내역 -> Stock 수량 update
		 * --- getListRnpCondSale -> restoreStockSaleQuantity select 생산내역 -> Stock 수량
		 * update --- getListRnpCondMake -> restoreStockMakeQuantity
		 */

		return "redirect: lhsListStock";
	}

	// 월말마감 버튼
	@RequestMapping(value = "lhsMonthlyClosing")
	public String lhsMonthlyClosing() {

		/*
		 * lhs.monthlyClosing (프로시져 패키지 실행) // 수불마감구분=1인지 체크 -> 구매, 판매, 생산 stauts=5인지 체크
		 * 수불마감구분=1인지 체크 1. 수불마감구분 update --- updateStatusRnPClosing2 2. 재고조사 조회 ---
		 * getListStockSurvey 3. 재고수량 update --- updateStockAllQuantity 4. 다음달 재고 insert
		 * --- insertStockNextMonth
		 */

		return "redirect: lhsListStock";
	}

} // class
