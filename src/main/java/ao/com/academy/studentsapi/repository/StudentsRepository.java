package ao.com.academy.studentsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.com.academy.studentsapi.domain.Student;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
    
}
