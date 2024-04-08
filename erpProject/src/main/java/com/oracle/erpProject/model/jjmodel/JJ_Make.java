package com.oracle.erpProject.model.jjmodel;

import java.util.Date;

import lombok.Data;

@Data
public class JJ_Make {
	private int m_num;				// 작업지시번호
	private String m_status;		// 작업지시상태	(0. 작업요청, 1. 영업생산요청, 2. 생산중, 3. 생산완료, 4. 수불완료)
	private String m_type;			// 작업지시유형	(1.생산, 2.재조립, 3.영업요청)
	private String m_manager;		// 작업지시담당자
	private String m_sdate;			// 작업지시_요청일자
	private String m_due_date;		// 작업완료일자
	private String m_isDeleted;	// 삭제여부
	private String m_note;			// 비고
	
	// 조회용
	private String search;				private String keyword;					
	private int start;					private int end;
	private String p_name;				// Product의 제품명 조회
	
  	// Page 정보
    private String currentPage;    
	
}
