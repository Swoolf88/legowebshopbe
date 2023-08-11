package com.swoolf.lego.controller;

import com.swoolf.lego.model.Employee;
import com.swoolf.lego.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/addEmployee")
    public Employee saveEmployee(@RequestParam("file") MultipartFile file,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("emailId") String emailId) throws IOException {
        return employeeService.saveEmployeeToDB(file, firstName, lastName, emailId);
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return  employeeService.getAllEmployees();
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = null;
        employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping(value = {"/employees/{id}"}, consumes = {MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestParam("file") MultipartFile file,
                                                   @RequestParam("firstName") String firstName,
                                                   @RequestParam("lastName") String lastName,
                                                   @RequestParam("emailId") String emailId) throws IOException {
        Employee employee = new Employee();
         employee = employeeService.updateEmployee(id, file, firstName, lastName, emailId);
         return ResponseEntity.ok(employee);
    }


}
