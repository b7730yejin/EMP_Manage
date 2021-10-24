package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	private DeptService service;
	
	//부서명으로 검색
	@PostMapping(path = "/dept/search_dname", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> dnameSearch(@RequestParam String dname){
		return ResponseEntity.ok(service.readDname(dname));
	}
	//부서번호로 검색
	@PostMapping(path = "/dept/search_dno", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> dnoSearch(@RequestParam Integer deptno){
		return ResponseEntity.ok(service.readDno(deptno));
	}
}
