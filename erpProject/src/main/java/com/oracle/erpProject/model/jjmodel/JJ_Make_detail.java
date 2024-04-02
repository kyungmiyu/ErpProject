package com.oracle.erpProject.model.jjmodel;

import java.util.Date;

import lombok.Data;

@Data
public class JJ_Make_detail {
	private int m_num;				// 작업지시번호
	private int md_num;			// 작업순번
	private int f_id;				// 공장코드
	private String md_status;		// 작업지시상태	(0. 작업요청, 1. 영업생산요청, 2. 생산중, 3. 생산완료, 4. 수불완료)
	private int p_itemcode;			// 제품코드
	private String md_worker;		// 작업자
	private Date md_date;			// 작업지시일자
	private Date md_work_date;		// 작업완료일자
	private int md_quantity;		// 지시수량
	private int md_pro_quantity;	// 생산수량
	private int rpnc_gubun;			// 수불마감구분
	private int md_worker_num;		// 작업인원
	private String md_note;		// 비고
	private String s_date;			// 매출일자
	private int cus_no;				// 거래처 코드

	// 조회용
	private int start;
	private int end;
	private String p_name;				// Product의 제품명 조회
	private String select_md_status; 	// 생산요청페이지 작업지시상태 선택사항
	private int select_rpnc_gubun; 	// 생산요청페이지 수불마감상태 선택사항
	private int select_f_id; 		// 생산요청페이지 공장아이디 선택사항
	
  	// Page 정보
    private String currentPage;
	
}
