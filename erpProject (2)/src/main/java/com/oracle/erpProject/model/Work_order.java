package com.oracle.erpProject.model;

import java.util.Date;

import lombok.Data;

@Data
public class Work_order {
	private int wo_num;				// 작업지시번호
	private String wo_status;		// 작업지시상태	(0. 작업요청, 1. 영업생산요청, 2. 생산중, 3. 생산완료, 4. 수불완료)
	private String wo_type;			// 작업지시유형	(1.생산, 2.재조립, 3.영업요청)
	private String wo_manager;		// 작업지시담당자
	private Date wo_sdate;			// 작업지시_요청일자
	private Date wo_due_date;		// 작업완료일자
	private String wo_isDeleted;	// 삭제여부
	private String wo_note;			// 비고
	
}
