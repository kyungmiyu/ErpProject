package com.oracle.erpProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.erpProject.model.lhsmodel.Employee;
import com.oracle.erpProject.service.lhsservice.LHS_Serivce_Interface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LHSController {
	
	private final LHS_Serivce_Interface lhs;
	 
	@RequestMapping(value="lhs")
	public String lhsListEmp(Model model) {
		
		System.out.println("lhsController lhsListEmp start...");
		
		List<Employee> listEmp = lhs.getListEmp();
		
		model.addAttribute("listEmp", listEmp);
		
		return "lhs/listEmp";
	}
	
	// 테스트용 인덱스
	@RequestMapping(value="lhsIndex")
	public String lhsIndex(Employee emp, Model model) {
		
		System.out.println("lhsController lhsIndex start...");
		
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		model.addAttribute("empData", empData);

		return "lhs/index";
	} 
	
	
	// 기초기말 재고 조회
	
	@RequestMapping(value="lhsListStock")
	public String lhsListStock () {
		
		return "lhs/listStock";
	}
	
	// 재고관리
	
	@RequestMapping(value="lhsManageRegistStock")
	public String lhsManageRegistStock() {
		
		// if로 lhsResgistStockBegin갈지 lhsRegistStockSurvey갈지 결정
		
		return "lhs/resgistStockBegin";
	}
	
	// 기초재고 등록
	
	@RequestMapping(value="lhsResgistStockBegin")
	public String lhsResgistStockBegin() {
		
		return "lhs/resgistStockBegin";
	}
	
	
	// 실사재고조사 등록
	
	@RequestMapping(value="lhsRegistStockSurvey")
	public String lhsRegistStockSurvey() {
		
		return "lhs/registStockSurvey";
	}
	
	
	// 수불내역1 (구매)
	
	@RequestMapping(value="lhsListRnPCondBuy")
	public String lhsListRnPCondBuy() {
		return "lhs/listRnPCondBuy";
	}
	
	// 수불내역2 (판매)

	// 수불내역3 (생산)
	
	// 수불내역4 (재고조사)
	
	

} // class
