package ao.com.academy.studentsapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.com.academy.studentsapi.domain.Student;
import ao.com.academy.studentsapi.repository.StudentsRepository;



@RestController
@RequestMapping("/controller")
public class StudentsController {
    
    @Autowired
    StudentsRepository studentsRepository;

    //Get All Students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentsRepository.findAll();
    }

    //Create new student
    @PostMapping("/new/student")
    public void createStudent(@RequestBody Student student) {
        studentsRepository.save(student);
    }

    // Find a single student
    @GetMapping("/student/{id}")
    public Optional<Student> findById(@PathVariable(value="id") Long studentID) {
        return studentsRepository.findById(studentID);
    }
    
    
    

}
