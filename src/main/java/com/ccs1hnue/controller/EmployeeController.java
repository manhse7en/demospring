package com.ccs1hnue.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ccs1hnue.config.component.ParentBean;
import com.ccs1hnue.model.mongodb.Employee;
import com.ccs1hnue.service.EmployeeService;

@RestController
@RequestMapping("employees/")
public class EmployeeController {

	@Autowired
    private ApplicationContext applicationContext;
	
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "list", params = "token", method = RequestMethod.GET)
    public HttpEntity<List<Employee>> getAllEmployees(@RequestParam("token") String token) {
    	ParentBean parentBean = applicationContext.getBean(ParentBean.class);
        parentBean.test();
        System.out.println(token);
        List<Employee> employees = employeeService.findAll();
        if (employees.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            employees.forEach(e -> e.add(linkTo(methodOn(EmployeeController.class).getAllEmployees(token)).withRel("employees")));
            employees.forEach(e -> e.add(linkTo(methodOn(EmployeeController.class).getEmployeeById(e.getEmployeeId())).withSelfRel()));
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public HttpEntity<Employee> getEmployeeById(@PathVariable("id") String employeeId) {
        Employee byEmployeeId = employeeService.findByEmployeeId(employeeId);
        if (byEmployeeId == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            byEmployeeId.add(linkTo(methodOn(EmployeeController.class).getEmployeeById(byEmployeeId.getEmployeeId())).withSelfRel());
            return new ResponseEntity<>(byEmployeeId, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "employee", method = RequestMethod.POST)
    public HttpEntity<?> saveEmployee(@RequestBody Employee e) {
    	System.out.println(e.toString());
        if (employeeService.employeeExists(e)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            Employee employee = employeeService.saveEmployee(e);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/employees/employee/{id}")
                    .buildAndExpand(employee.getEmployeeId()).toUri();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(location);
            return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "employee/{id}", method = RequestMethod.PUT)
    public HttpEntity<?> updateEmployee(@PathVariable("id") String id, @RequestBody Employee e) {
        Employee byEmployeeId = employeeService.findByEmployeeId(id);
        if(byEmployeeId == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            byEmployeeId.setAge(e.getAge());
            byEmployeeId.setFirstName(e.getFirstName());
            byEmployeeId.setLastName(e.getLastName());
            employeeService.updateEmployee(byEmployeeId);
            byEmployeeId.add(linkTo(methodOn(EmployeeController.class).getEmployeeById(byEmployeeId.getEmployeeId())).withSelfRel());
            return new ResponseEntity<>(byEmployeeId, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String employeeId) {
        employeeService.deleteByEmployeeId(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "employee/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAll() {
        employeeService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
