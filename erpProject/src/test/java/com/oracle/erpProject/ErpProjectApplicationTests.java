package com.oracle.erpProject;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.oracle.erpProject.domain.Department;
import com.oracle.erpProject.domain.QDepartment;
import com.oracle.erpProject.repository.DepartmentRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
class ErpProjectApplicationTests {
	
	@Autowired
	EntityManager em;

	@Autowired
	DepartmentRepository deptRepo;
	
	JPAQueryFactory queryFactory;
	
	@Test
	public void testInsertDept() {
		
		/*
		Department dept = new Department();
		dept.setDept_name("물류");
		dept.setDept_phone("1515");
		dept.setDept_enabled("Y");
		
		deptRepo.save(dept);
		
		dept = new Department();
		dept.setDept_name("판매");
		dept.setDept_phone("2525");
		dept.setDept_enabled("Y");
		
		deptRepo.save(dept);
		
		dept = new Department();
		dept.setDept_name("영업");
		dept.setDept_phone("3535");
		dept.setDept_enabled("Y");// 그거 어떻게하는데요..?	
		
		deptRepo.save(dept);
		*/
		
		/*
		// 리스트 
		Iterable<Department> deptList = deptRepo.findAll();
		System.out.println(deptList);
		*/
		
		/*
		// 수정
		Department dept = deptRepo.findById(952).get();
		dept.setDept_name("인사");
		deptRepo.save(dept);
		*/
		
		/*
		// 삭제
		deptRepo.deleteById(954);
		*/
		
		/*
		// 한 건 조회
		Department dept = deptRepo.findById(952).get();
		System.out.println(dept);
		*/
		
		/*
		// 검색 dept_enabled 가 Y인것
		BooleanBuilder builder = new BooleanBuilder();
		QDepartment qdepartment = QDepartment.department;
		if(dept_enabled.equals("Y")) {
			builder.and(qdepartment.dept_enabled.like("Y"));
		}
		List<Department> deptList = new JPAQueryFactory(em).selectFrom(qdepartment).where(builder).fetch();
		System.out.println(deptList);
		*/
		
		/* 
		// 테스트용 데이터 생성
		for (int i=0; i<100; i++) {
			Department dept = new Department();
			dept.setDept_name("물류"+i);
			dept.setDept_phone("1515"+i);
			dept.setDept_enabled("Y");
			
			deptRepo.save(dept);
		}
		*/
		/*
		// 페이징
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "deptNo");
		Page<Department> pageInfo = deptRepo.findAll(paging);
		System.out.println(pageInfo.getSize());
		System.out.println(pageInfo.getTotalPages());
		System.out.println(pageInfo.getTotalElements());
		System.out.println(pageInfo.nextPageable());
		List<Department> deptList = pageInfo.getContent();
		System.out.println(deptList);
		*/
	}
	
}






