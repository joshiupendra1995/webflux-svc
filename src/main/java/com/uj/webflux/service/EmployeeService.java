package com.uj.webflux.service;

import com.uj.webflux.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CreatedBy:- Upendra.Joshi
 */
public interface EmployeeService {

	Mono<Employee> create(Employee employee);

	Mono<Employee> findByEmpId(Long empId);

	Flux<Employee> findByEmpName(String empName);

	Flux<Employee> findAll();

	Mono<Employee> update(Employee employee);

	Mono<Employee> delete(Long empId);

}
