package com.uj.webflux.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee implements Persistable<Long> {

	@Id
	@Column(value = "empid")
	private Long empId;

	@Column(value = "empname")
	private String empName;

	@Column(value = "address")
	private String address;

	@Column(value = "esalary")
	private BigDecimal eSalary;

	public Employee(Long empId, String empName, String address, BigDecimal eSalary) {
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.eSalary = eSalary;
	}

	@JsonIgnore
	@Transient
	private boolean newEmployee;

	@JsonIgnore
	@Override
	public boolean isNew() {
		return this.newEmployee || empId == null;
	}

	@JsonIgnore
	@Override
	public Long getId() {
		return this.empId;
	}

	public Employee setAsNew() {
		this.newEmployee = true;
		return this;
	}

}
