package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EmpDto;
import com.example.demo.entity.Emp;
import com.example.demo.exception.EmpFail;
import com.example.demo.repository.EmpRepository;


@Service
public class EmpService {
	@Autowired
	private EmpRepository empDao;
	
	//로그인
	@Transactional(readOnly = true)
	public void login(EmpDto.Login dto){
		String job = empDao.findJob(dto.getEmpno());
		if(job.equals("MANAGER")==false) {
			throw new EmpFail.UserRejectAccessException();
		}
	}
	//사원 전체 조회
	@Transactional(readOnly = true)
	public Page<Emp> list(int pageno) {
		Pageable pageable = PageRequest.of(pageno - 1, 10, Sort.by(Sort.Direction.DESC, "empno"));
		return empDao.findAll(pageable);
	}
	//사원 사번으로 조회
	@Transactional(readOnly = true)
	public List<Emp> readEmpno(int empno){
	 	List<Emp> emp =  empDao.readById(empno);
	 	if(emp.size()==0) {
	 		throw new EmpFail.UserNotFoundException();
	 	}
		return emp;
	}
	//사원 이름으로 조회
	@Transactional(readOnly = true)
	public List<Emp> readName(String ename){ 
		List<Emp> emp = empDao.readByName(ename);
		if(emp.size()==0) {
	 		throw new EmpFail.UserNotFoundException();
	 	}
		return emp;
	}
	//사원 추가
	public Emp add(Emp emp){
		return empDao.save(emp);
	}
	//사원 삭제
	public void delete(int empno) {
		//Emp emp = empDao.findById(empno).orElseThrow(EmpFail.UserNotFoundException::new);
		//empDao.delete(emp);
		empDao.deleteById(empno);
	}
}
