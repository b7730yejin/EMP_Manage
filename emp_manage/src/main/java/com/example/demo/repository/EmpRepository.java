package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{
	
	//사번, 이름으로 직무 검색(로그인)
	@Query("select distinct e.job from Emp e where e.empno=?1")
	public String findJob(int empno);
	
	//전체 보기(사번 내림차순)
	@Query("select e from Emp e order by e.empno desc")
	public List<Emp> readAll();
	
	//사번으로 검색
	@Query("select e from Emp e where e.empno=?1")
	public List<Emp> readById(int empno);
	
	//이름으로 검색
	@Query("select e from Emp e where e.ename=?1")
	public List<Emp> readByName(String ename);
	
}
