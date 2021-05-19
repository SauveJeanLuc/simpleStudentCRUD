package rca.cat.example.student.dto;

import com.sun.istack.NotNull;
import rca.cat.example.student.domain.Course;
import rca.cat.example.student.domain.Student;

import javax.persistence.OneToOne;

public class MarkDTO {

    private Long id;
    private Long studentId;
    private Long courseId;
    private Float score;
    private Float maximum;

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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
