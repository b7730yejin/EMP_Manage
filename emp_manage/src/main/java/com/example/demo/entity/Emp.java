package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain =true)
@Entity
@DynamicUpdate
public class Emp {
	@PrePersist
	public void init() {
		comm =0;
	}
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private LocalDate hiredate;
	private Integer sal;
	private Integer comm;
	private Integer deptno;
}
