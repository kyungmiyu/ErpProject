package com.oracle.erpProject.dao.Yhsdao;

import java.util.List;

import com.oracle.erpProject.model.Board;
import com.oracle.erpProject.model.yhsmodel.YhsBoard;


public interface Yhs_Dao_Interface {

	int totalBoard(YhsBoard board);
	
	List<YhsBoard> listBoard(YhsBoard board);

}
