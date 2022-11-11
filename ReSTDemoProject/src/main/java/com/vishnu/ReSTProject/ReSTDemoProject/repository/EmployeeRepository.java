package com.vishnu.ReSTProject.ReSTDemoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishnu.ReSTProject.ReSTDemoProject.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
