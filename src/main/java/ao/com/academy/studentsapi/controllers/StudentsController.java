package ao.com.academy.studentsapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.com.academy.studentsapi.domain.Student;
import ao.com.academy.studentsapi.exceptions.StudentNotFoundException;
import ao.com.academy.studentsapi.repository.StudentsRepository;


@RestController
@RequestMapping("/controller")
public class StudentsController {
    
    @Autowired
    StudentsRepository studentsRepository;

    // Get All Students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentsRepository.findAll();
    }

    // Create new student
    @PostMapping("/new/student")
    public void createStudent(@RequestBody Student student) {
        studentsRepository.save(student);
    }

    // Find a single student
    @GetMapping("/search/student/{id}")
    public Student findById(@PathVariable(value="id") Long studentID) throws StudentNotFoundException {
        return studentsRepository.findById(studentID).orElseThrow(() -> new StudentNotFoundException(studentID));
    }
    
    // Update Student
    @PutMapping("update/student/{id}")
    public Student updateStudent(@PathVariable(value="id") Long studentID, @RequestBody Student studentDetails) throws StudentNotFoundException {

        Student student = studentsRepository.findById(studentID).orElseThrow(() -> new StudentNotFoundException(studentID));

        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());

        Student newStudent = studentsRepository.save(student);

        return newStudent;
    }

    // Delete Student
    @DeleteMapping("/delete/student/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value="id") Long studentID) throws StudentNotFoundException{
        Student student = studentsRepository.findById(studentID).orElseThrow(() -> new StudentNotFoundException(studentID));

        studentsRepository.delete(student);

        return ResponseEntity.ok().build();
    }
    
    

}
