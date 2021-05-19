package rca.cat.example.student.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Course {

    //No arg constructor

    public Course() {
    }

    //All-args-id constructor

    public Course(String name, String courseCode) {
        this.name = name;
        this.courseCode = courseCode;
    }

    //All args constructor

    public Course(Long id, String name, String courseCode) {
        this.id = id;
        this.name = name;
        this.courseCode = courseCode;
    }

    //Properties
    @Id
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String courseCode;

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
