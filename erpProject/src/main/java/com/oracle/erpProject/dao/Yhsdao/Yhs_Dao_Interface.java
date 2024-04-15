package com.oracle.erpProject.dao.Yhsdao;

import java.util.List;

import com.oracle.erpProject.model.yhsmodel.YhsBoard;


public interface Yhs_Dao_Interface {

	int totalBoard(YhsBoard board);
	
	List<YhsBoard> listBoard(YhsBoard board);
	
	YhsBoard boardContents(int b_no);
	
	int boardViewCnt(YhsBoard board);
	
	int insertBoard(YhsBoard board);

	int deleteBoard(int b_no);
	
//	int deleteBoard(YhsBoard board);

}
