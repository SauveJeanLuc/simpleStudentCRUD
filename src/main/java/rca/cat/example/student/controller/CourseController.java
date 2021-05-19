package rca.cat.example.student.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import rca.cat.example.student.domain.Course;
import rca.cat.example.student.repository.CourseRepository;


import java.util.List;
import java.util.Optional;

@RestController

public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    //Add course
    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    //Get course by Id
    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseRepository.findById(id)
                .orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    //Get all courses
    @GetMapping("/courses")
    public List<Course> getALlCourse(){
        return courseRepository.findAll();
    }

    //Update course by Id
    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updateCourseById(@PathVariable Long id, @RequestBody Course course){
        Optional<Course> CourseData = courseRepository.findById(id);

        if(CourseData.isPresent()){
            Course _course = CourseData.get();
            _course.setId(course.getId());
            _course.setName(course.getName());
            _course.setCourseCode(course.getCourseCode());

            return new ResponseEntity<>(courseRepository.save(_course),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete course by ID
    @DeleteMapping("/course/{id}")
    public void deleteCourseById(@PathVariable Long id){
        courseRepository.deleteById(id);
    }




}