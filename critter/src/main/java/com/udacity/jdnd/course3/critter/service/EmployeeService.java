package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.Repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.*;

@Service
public class EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        Employee employee1 = employeeRepository.save(employee);
        System.out.println("Saved Employee: id is " + employee1.getId());
        return employee1;
    }
    public Employee getEmployeeById(Long id){
        return employeeRepository.getOne(id);
    }
    public List<Employee> getEmployeesBySkillAndDay(Set<EmployeeSkill> skills, DayOfWeek dayOfWeek){
        List<Employee> employees = employeeRepository.findAllBySkillsInAndDaysAvailableContains(skills, dayOfWeek);
        List<Employee> employeeList = new ArrayList<>();
        employees.forEach(thisEmployee ->{
            if(thisEmployee.getSkills().containsAll(skills)){
                employeeList.add(thisEmployee);
            }
        });
        return employeeList;
    }
}
