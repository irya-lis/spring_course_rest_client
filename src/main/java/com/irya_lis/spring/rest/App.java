package com.irya_lis.spring.rest;

import com.irya_lis.spring.rest.configuration.MyConfig;
import com.irya_lis.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

        // 1 - getAllEmployees()
//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);
//        System.out.println("----------");

        // 2 - getEmployee(int id)
        Employee empById = communication.getEmployee(1);
        System.out.println(empById);

        // 3.1 - save: saveEmployee(Employee employee)
        Employee emp = new Employee("Sveta", "Sokolova", "HR", 900);
        communication.saveEmployee(emp);
        // 3.2 - update: saveEmployee(Employee employee)
        Employee emp1 = new Employee("Sveta", "Sokolova", "IT", 1200);
        emp1.setId(18);
        communication.saveEmployee(emp1);

        // 4
        communication.deleteEmployee(18);
    }
}