package com.oracle.erpProject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.oracle.erpProject.domain.KmEmployee;

public interface KmEmployeeRepository extends PagingAndSortingRepository<KmEmployee, Integer>{

}