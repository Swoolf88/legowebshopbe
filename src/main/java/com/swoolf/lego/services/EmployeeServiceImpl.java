package com.swoolf.lego.services;

import com.swoolf.lego.entity.EmployeeEntity;
import com.swoolf.lego.model.Employee;
import com.swoolf.lego.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities
                = employeeRepository.findAll();
        List<Employee> employees = employeeEntities
                .stream()
                .map(emp -> new Employee(emp.getId()
                , emp.getFirstName(), emp.getLastName(), emp.getEmailId(), emp.getImage()))
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity =
                employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, MultipartFile file, String firstName,
                                   String lastName, String emailId) throws IOException {
        EmployeeEntity employeeEntity
                = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmailId(emailId);
        employee.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public Employee saveEmployeeToDB(MultipartFile file, String firstName,
                                     String lastName, String emailId) throws IOException {
        Employee employee = new Employee();
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employee.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmailId(emailId);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            employeeEntity.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        employeeEntity.setFirstName(firstName);
        employeeEntity.setLastName(lastName);
        employeeEntity.setEmailId(emailId);
        employeeRepository.save(employeeEntity);
        return employee;
    }
}
