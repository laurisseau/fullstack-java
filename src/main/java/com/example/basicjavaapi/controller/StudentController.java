package com.example.basicjavaapi.controller;
import com.example.basicjavaapi.exception.StudentNotFoundException;
import com.example.basicjavaapi.model.Student;
import com.example.basicjavaapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Create
    @PostMapping("/student")
    Student newStudent(@RequestBody Student newStudent){
        return studentRepository.save(newStudent);
    }

    // Get All
    @GetMapping("/students")
    List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    // Get By ID
    @GetMapping("/student/{studentId}")
    Student getStudentsById(@PathVariable int studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    // Delete By ID
    @DeleteMapping("/student/{studentId}")
    String deleteStudentById(@PathVariable int studentId) {

        if(!studentRepository.existsById(studentId)){
            throw new StudentNotFoundException(studentId);
        }
        studentRepository.deleteById(studentId);

        return "User with id "+ studentId +" has been deleted.";
    }

    // Update By ID
   @PutMapping("/student/{studentId}")
    Student updateStudentById(@PathVariable int studentId, @RequestBody Student updatedStudent) {
       // optional is used to see if a class is present
        return studentRepository.findById(studentId)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setAddress(updatedStudent.getAddress());
                    return studentRepository.save(student);
                }).orElseThrow(()-> new StudentNotFoundException(studentId));
    }

}
