package com.oracle.erpProject.service.Yhs;

import java.util.List;

import com.oracle.erpProject.model.Board;

public interface Yhs_Service_Interface {
	
	int totalBoard(Board board);
	
	List<Board> listBoard(Board board);

}
