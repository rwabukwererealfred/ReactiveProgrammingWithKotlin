package com.jpa.controller

import com.jpa.model.Employee
import com.jpa.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("api/")
class EmployeeController {

    @Autowired
    lateinit var employeeService: EmployeeService

    @PostMapping("registerEmployee")
    fun registerEmployee(@RequestBody employee: Employee):Mono<Employee>{
        return employeeService.registerEmployee(employee);
    }

    @GetMapping("findAllEmployee")
    fun findAll():Flux<Employee>{
        return employeeService.getAll().log();
    }

    @PutMapping("updateEmp/{id}")
    fun updateEmp(@PathVariable id: Int, @RequestBody employee: Employee): Mono<Employee>{
       return employeeService.updateEmployee(employee, id);
    }
}