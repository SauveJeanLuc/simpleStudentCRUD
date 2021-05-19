package rca.cat.example.student.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Mark {

    //No arg constructor

    public Mark() {
    }

    //All-args-id constructor

    public Mark(Student student, Course course, Float score, Float maximum) {
        this.student = student;
        this.course = course;
        this.score = score;
        this.maximum = maximum;
    }

    //All args constructor


    public Mark(Long id, Student student, Course course, Float score, Float maximum) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.score = score;
        this.maximum = maximum;
    }

    //Properties
    @Id
    private Long id;
    @NotNull
    @OneToOne
    private Student student;
    @NotNull
    @OneToOne
    private Course course;
    @NotNull
    private Float score;
    @NotNull
    private Float maximum;


    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Float getMaximum() {
        return maximum;
    }

    public void setMaximum(Float maximum) {
        this.maximum = maximum;
    }
}
