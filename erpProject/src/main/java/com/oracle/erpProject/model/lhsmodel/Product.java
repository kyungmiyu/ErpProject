package com.oracle.erpProject.model.lhsmodel;

import java.util.Date;

import lombok.Data;

@Data
public class Product {
	
		private int p_itemcode;				//제품 코드
		private int f_id;							// 공장 코드
		private int pro_category;			//제품 대분류	
		private int pro_midcategory;		//제품 중분류
		private String p_name;				// 제품명
		private String p_content;			// 제품내용
		private int p_buyprice;				//매입가격
		private int p_saleprice;				//매출가격
		private String p_image;				// 제품사진
		private Date p_enddate;			//판매종료일
		private Date p_udtdatd;				//수정날자
		private String p_regdate;			//등록날자
		private String p_fac_gubun;		//공장구분
		private int p_isdeleted;				//취급여부 

		// Paging
	    private String 	pageNum;  			private String 	currentPage;		
	    private int 	start;              private int 	end;
	  	private int 	prevPage;		  	private int 	nextPage;
		private String gubun;
		
		// 0402 현승 - 신제품체크 파라미터 (lhsCheckNewItem)
		private String new_item_manager;
		private String new_item_quantity;
		
		// 0403 현승 - 실사 재고조사 물품 상세정보조회 파라미터 (lhsGetDataProduct)
		private String st_regdate;
		private int st_quantity;
		
	
}
