package com.swoolf.lego.services;

import com.swoolf.lego.model.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long id);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, MultipartFile file, String firstName,
                            String lastName, String emailId) throws IOException;

    Employee saveEmployeeToDB(MultipartFile file, String firstName,
                              String lastName, String emailId) throws IOException;
}
