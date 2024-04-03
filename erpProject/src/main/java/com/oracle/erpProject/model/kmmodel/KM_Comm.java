package com.oracle.erpProject.model.kmmodel;

import lombok.Data;

@Data
public class KM_Comm {

	int comm_bcd; // 대분류
	int comm_mcd; // 중분류
	String comm_content; // 내용
	
	/*
	200
	10 사장
	20 부장
	30 차장
	40 과장
	50 대리
	60 사원
	*/
}
