package com.jpa.service

import com.jpa.model.Employee
import com.jpa.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.transaction.TransactionStatus
import org.springframework.transaction.support.TransactionCallback
import org.springframework.transaction.support.TransactionTemplate
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono
import java.util.*


@Service
class EmployeeService {
    @Autowired
    lateinit var employeeRepository: EmployeeRepository;

    @Autowired
    lateinit var transactionTemplate: TransactionTemplate


    fun registerEmployee(employ: Employee): Mono<Employee> {
        return employeeRepository.save(employ).toMono();
    }

    fun getAll():Flux<Employee>{
       // val employees:List<Employee> = employeeRepository.findAll().sortedBy { i -> i.id };

        //val employees: Flux<Employee> = Flux.fromIterable(employeeRepository.findAll());

        return Flux.fromIterable(employeeRepository.findAll()).
        sort{x,y -> x.firstName .compareTo(y.firstName)}
    }

    fun updateEmployee(employee: Employee, id:Int):Mono<Employee>{
       return employeeRepository.findById(id).map { i -> {
           var  update : Employee = i.copy(
               firstName = employee.firstName,
               lastName =  employee.lastName,
               price =  employee.price
           )
            employeeRepository.save(update)
        } }.get().toMono();
    }


}