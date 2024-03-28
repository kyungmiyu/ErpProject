package com.oracle.erpProject.model;

import java.util.Date;

import lombok.Data;

@Data
public class Work_order_detail {
	private int wo_num;				// 작업지시번호
	private int wod_num;			// 작업순번
	private int f_id;				// 공장코드
	private String wod_status;		// 작업지시상태	(0. 작업요청, 1. 영업생산요청, 2. 생산중, 3. 생산완료, 4. 수불완료)
	private int p_itemcode;			// 제품코드
	private String wod_worker;		// 작업자
	private Date wod_date;			// 작업지시일자
	private Date wod_work_date;		// 작업완료일자
	private int wod_quantity;		// 지시수량
	private int wod_pro_quantity;	// 생산수량
	private int d_gubun;			// 수불마감구분
	private int wod_worker_num;		// 작업인원
	private String wod_note;		// 비고
	private Date s_date;			// 매출일자
	private int cus_no;				// 거래처 코드

	// 조회용
	private int start;
	private int end;
	private String p_name;			// Product의 제품명 조회
	
  	// Page 정보
    private String currentPage;
	
}
