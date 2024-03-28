package com.oracle.erpProject.model;

import java.util.Date;

import lombok.Data;

@Data
public class Customer {
	
	private int cust_no;
	private int emp_no;
	private int cust_bcomm;
	private int cust_scomm;
	private String cust_type;
	private String cust_name;
	private String b_num;
	private String cust_tel;
	private String cust_email;
	private int cust_status;
	private int cust_isdeleted;
	private Date wdate;

}
