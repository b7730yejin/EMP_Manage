package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Emp;
import com.example.demo.service.DeptService;

@SpringBootTest
public class ServiceTest {
	@Autowired
	private DeptService service;
	
	@Test
	public void readTest() {
		service.readDname("SALSE");
	}
}
