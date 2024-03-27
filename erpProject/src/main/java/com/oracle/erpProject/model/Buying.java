package com.oracle.erpProject.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Buying {

	private String buy_date;				// 구매일자		
	private int cust_no;						// 거래처 코드
	private int emp_no;						// 사원번호
	private String buy_title;				// 구매 제목
	private int buy_status;					// 구매 상태
	private String buy_manager;			// 구매 담당자
	private String buy_note;				// 비고
	private Date buy_wdate;				//구매입력날짜
	
	

	// 조회용 수불 마감
	private String d_year_month;	// 년월일
	private int d_cubun;					// 수불마감구분
	
}
