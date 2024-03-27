package com.oracle.erpProject.service.sl;

import org.springframework.stereotype.Service;

import com.oracle.erpProject.dao.sldao.SL_Dao_Interface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SL_ServiceImpl implements SL_Service_Interface {

	private final SL_Dao_Interface slDao;
}
