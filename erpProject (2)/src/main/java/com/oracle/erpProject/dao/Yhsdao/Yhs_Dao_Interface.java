package com.oracle.erpProject.dao.Yhsdao;

import java.util.List;

import com.oracle.erpProject.model.Board;


public interface Yhs_Dao_Interface {

	int totalBoard(Board board);
	
	List<Board> listBoard(Board board);

}
