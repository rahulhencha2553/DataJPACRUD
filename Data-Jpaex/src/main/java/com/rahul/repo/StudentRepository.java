package com.rahul.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
