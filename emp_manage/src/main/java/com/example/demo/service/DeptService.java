package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Emp;
import com.example.demo.repository.DeptRepository;

@Service
public class DeptService {
	@Autowired
	private DeptRepository dao;

	// 부서이름으로 사원 검색
	public List<Emp> readDname(String dname) {
		return dao.readEmpByName(dname);
	}
	//부서 번호로 사원 검색
	public List<Emp> readDno(Integer deptno) {
		return dao.readEmpByDno(deptno);
	}
}
