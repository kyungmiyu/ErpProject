package com.oracle.erpProject.model.slmodel;

import java.util.Date;

import lombok.Data;

@Data
public class SLSale {
	private String s_date; 		//매출일자
	private int cust_no;		//거래처코드
	private String s_title;		//판매제목
	private int s_status;		//판매상태
	private String s_note;		//비고
	private String s_manager;		//판매담당자 코드
	private Date s_wdate;		//판매날짜입력
	

	// 리스트 조회용 컬럼
	private String cust_name; // 거래처명 		
	private String sale_status_detail; // 판매 진행 상태
	private int productCnt; // 판매 제품 수
	private int totalMoney; // 판매 총 금액
	private int totalCnt; // 판매 제품 총 수량
	private String keyword; // 검색 키워드 
	
	
	// 조회용 수불 마감
	private String rnpc_year_month_day;	// 년월일
	private int rnpc_gubun;					// 수불마감구분
	
	
	// 페이징
	private int start;
	private int end;
	private String currentPage;
	private int pageBlock;
	private int rowPage;
	private int startPage;			private int endPage;
	private int total;				private int totalPage;
	
	
	
	
	
}
