package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Emp;
import com.example.demo.repository.DeptRepository;
import com.example.demo.repository.EmpRepository;

@SpringBootTest
public class DaoTest {
	@Autowired
	private EmpRepository empDao;
	@Autowired
	private DeptRepository deptDao;
	
	//@Test
	public void test1() {
		System.out.println(empDao.findJob(7369));
		
	}
	@Test
	public void test2() {
		//System.out.println(deptDao.readEmpByDno(20));
		System.out.println(deptDao.readEmpByName("SALES"));
		
	}
}
