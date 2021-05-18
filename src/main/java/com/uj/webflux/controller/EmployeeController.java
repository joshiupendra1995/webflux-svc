package com.uj.webflux.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uj.webflux.entity.Employee;
import com.uj.webflux.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Employee> create(@RequestBody Employee e) {
		return employeeService.create(e);
	}

	@GetMapping(value = "/{empid}")
	public ResponseEntity<Mono<Employee>> findByEmpId(@PathVariable("empid") Long empId) {
		Mono<Employee> e = employeeService.findByEmpId(empId);
		HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(e, status);
	}

	@GetMapping(value = "/empname/{empname}")
	public Flux<Employee> findByName(@PathVariable("empname") String empName) {
		return employeeService.findByEmpName(empName);
	}

	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Employee> findAll() {
		return employeeService.findAll();
	}

	@PutMapping(value = "/update")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Employee> update(@RequestBody Employee e) {
		return employeeService.update(e);
	}

	@DeleteMapping(value = "/delete/{empid}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Employee> delete(@PathVariable("empid") Long empId) {
		return employeeService.delete(empId);
	}

}
