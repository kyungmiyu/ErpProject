package com.oracle.erpProject.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Board {
	private int B_NO;
	private int EMP_NO;
	private int B_CATEGORY;
	private int BOARD_MID;
	private String B_NAME; 
	private String B_CONTENT;
	private String B_FILE;
	private int B_HIT;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date B_REGDATE;
	private int B_GROUP;
	private int B_REPLY_NO;
	private int B_INDENT;
	
	//조회용
	private String search;
	private String keyword;
	private String pageNum;
	private int start;
	private int end;
	
	//Page 정보
	private String currentPage;
	
	

}
