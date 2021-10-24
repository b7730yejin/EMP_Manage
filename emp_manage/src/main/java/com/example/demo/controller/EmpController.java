package com.example.demo.controller;

import java.beans.PropertyEditor;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpDto;
import com.example.demo.entity.Emp;
import com.example.demo.service.EmpService;

@RestController
public class EmpController {
	@Autowired
	private EmpService service;
	@Autowired
	private PropertyEditor customLocalDatePropertyEditor;
	
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, customLocalDatePropertyEditor);
	}
	//===============로그인 처리======================//
	@PostMapping(path="/emp/login", produces = "text/plain; charset=utf-8")
	public ResponseEntity<?> login(@ModelAttribute @Valid EmpDto.Login dto, BindingResult bindingResult, HttpSession session) throws BindException {
		if(bindingResult.hasErrors())
			throw new BindException(bindingResult);
		service.login(dto);
		session.setAttribute("ename", dto.getEname());
		session.setAttribute("empno", dto.getEmpno());
		return ResponseEntity.ok("로그인 성공");
	}
	@PostMapping(path="/emp/logout", produces = "text/plain; charset=utf-8")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok("로그아웃 성공");
	}
	
	//============emp 리스트 출력==================//
	@GetMapping(path="/emp/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> list(@RequestParam(defaultValue = "1") int pageno){
		return ResponseEntity.ok(service.list(pageno));
	}
	
	//============emp 조회==================//
	//사번으로 검색
	@PostMapping(path = "/emp/empno_search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> empnoSearch(@RequestParam Integer empno){
		return ResponseEntity.ok(service.readEmpno(empno));
		
	}
	//사원명으로 검색
	@PostMapping(path = "/emp/ename_search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> enameSearch(@RequestParam String ename){
		return ResponseEntity.ok(service.readName(ename));
		
	}
	
	//============emp 추가==============//
	@PostMapping(path = "/emp/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> add(@ModelAttribute @Valid Emp emp, BindingResult bindingResult) throws BindException{
		if(bindingResult.hasErrors())
			throw new BindException(bindingResult);
		return ResponseEntity.ok(service.add(emp));
	}
	
	//================사원 삭제===================//
	@PostMapping(path="/emp/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@RequestParam int empno) {
		service.delete(empno);
		return ResponseEntity.ok(null);
	}
	
}
