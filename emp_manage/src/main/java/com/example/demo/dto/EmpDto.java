package com.example.demo.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmpDto {
	@Data
	public static class Login{
		//아이디
		private String ename;
		//패스워드
		private Integer empno;
	}
	@Data
	public static class Update{
		private String job;
		private Integer mgr;
		private Integer sal;
		private Integer comm;
		private Integer deptno;
	}
}
