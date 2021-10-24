package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Dept;
import com.example.demo.entity.Emp;

public interface DeptRepository extends JpaRepository<Dept, Integer> {
	
	// 전체 보기(부서번호 내림차순)
	@Query("select d from Dept d order by d.deptno desc")
	public List<Dept> readAll();
	
	// 부서번호로 검색
	@Query("select e as emp from Emp e inner join Dept d on d.deptno=?1 and d.deptno =  e.deptno")
	public List<Emp> readEmpByDno(Integer deptno);

	// 부서 이름으로 검색
	@Query("select e as ename from Emp e inner join Dept d on d.dname=?1 and d.deptno =  e.deptno")
	public List<Emp> readEmpByName(String dname);

}
