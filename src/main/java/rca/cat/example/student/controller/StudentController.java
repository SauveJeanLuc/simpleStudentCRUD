package rca.cat.example.student.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import rca.cat.example.student.domain.Student;
import rca.cat.example.student.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController

public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //Add student
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //Get student by Id
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentRepository.findById(id)
                .orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    //Get all students
    @GetMapping("/students")
    public List<Student> getALlStudents(){
        return studentRepository.findAll();
    }

    //Update Student by Id
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id, @RequestBody Student student){
        Optional<Student> StudentData = studentRepository.findById(id);

        if(StudentData.isPresent()){
            Student _student = StudentData.get();
            _student.setId(student.getId());
            _student.setNames(student.getNames());
            _student.setAge(student.getAge());
            _student.setEmail(student.getEmail());
            _student.setGender(student.getGender());

            return new ResponseEntity<>(studentRepository.save(_student),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete student by ID
    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentRepository.deleteById(id);
    }




}