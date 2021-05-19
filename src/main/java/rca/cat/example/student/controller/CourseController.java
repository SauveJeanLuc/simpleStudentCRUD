package rca.cat.example.student.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import rca.cat.example.student.domain.Course;
import rca.cat.example.student.domain.Mark;
import rca.cat.example.student.domain.Student;
import rca.cat.example.student.repository.CourseRepository;
import rca.cat.example.student.repository.MarkRepository;
import rca.cat.example.student.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController

public class CourseController {

    @Autowired
    private CourseRepository markRepository;

    //Add student
    @PostMapping("/mark")
    public Course addCourse(@RequestBody Course mark){
        return markRepository.save(mark);
    }

    //Get mark by Id
    @GetMapping("/mark/{id}")
    public Course getCourseById(@PathVariable Long id){
        return markRepository.findById(id)
                .orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    //Get all marks
    @GetMapping("/marks")
    public List<Course> getALlCourse(){
        return markRepository.findAll();
    }

    //Update mark by Id
    @PutMapping("/student/{id}")
    public ResponseEntity<Course> updateCourseById(@PathVariable Long id, @RequestBody Course mark){
        Optional<Mark> CourseData = markRepository.findById(id);

        if(CourseData.isPresent()){
            Course _mark = CourseData.get();
            _mark.setId(mark.getId());
            _mark.setStudent(mark.getStudent());
            _mark.setCourse(mark.getCourse());
            _mark.setScore(mark.getScore());
            _mark.setMaximum(mark.getMaximum());

            return new ResponseEntity<>(markRepository.save(_mark),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete student by ID
    @DeleteMapping("/student/{id}")
    public void deleteCourseById(@PathVariable Long id){
        markRepository.deleteById(id);
    }




}