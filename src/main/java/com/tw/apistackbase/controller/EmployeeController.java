package com.tw.apistackbase.controller;


import com.tw.apistackbase.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public ResponseEntity<List<Employee>> responseEntity() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(1,"小红",20,"女");
        Employee employee2 = new Employee(2,"小明",18,"男");
        Employee employee3 = new Employee(3,"小王",22,"男");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee( @PathVariable int id) {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(1,"小红",20,"女");
        Employee employee2 = new Employee(2,"小明",18,"男");
        Employee employee3 = new Employee(3,"小王",22,"男");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getid() == id) {
                return ResponseEntity.ok(employees.get(i));
            }
        }
        return null;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@RequestParam("name") String namelike) {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(1,"小红",20,"女");
        Employee employee2 = new Employee(2,"小明",18,"男");
        Employee employee3 = new Employee(3,"小王",22,"男");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        for (int i = 0; i < employees.size(); i++) {
            String str = employees.get(i).getName();
            if (str.contains(namelike)) {
                return ResponseEntity.ok(employees.get(i));
            }
        }
        return null;
    }
    
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
