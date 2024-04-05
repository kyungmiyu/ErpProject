package com.oracle.erpProject.model;

import lombok.Data;

@Data
public class Factory {
	private int f_id;						//	공장코드
	private String f_admin;			//	공장 관리자
	private String f_manager;		// 공장 담당자
	private String f_name;			// 공장명
	private String f_tel;				//	공장TEL
	private String f_info;				// 공장 특이사항 
}
