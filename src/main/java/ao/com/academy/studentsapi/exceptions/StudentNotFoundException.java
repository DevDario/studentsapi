package ao.com.academy.studentsapi.exceptions;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(Long studentID){
        super(String.format("The student with the ID: %s was not found !", studentID));
    }
}
