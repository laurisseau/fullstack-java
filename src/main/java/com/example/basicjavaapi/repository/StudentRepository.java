package com.example.basicjavaapi.repository;
import com.example.basicjavaapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


}
// get info ex get student by id