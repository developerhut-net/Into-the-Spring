package com.developerhut.spring.cache.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developerhut.spring.cache.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
