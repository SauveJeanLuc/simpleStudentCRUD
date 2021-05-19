package rca.cat.example.student.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Mark {

    //No arg constructor

    public Mark() {
    }

    //All-args-id constructor

    //All args constructor

    //Properties
    @Id
    private Long id;
    @NotNull
    @ManyToOne
    private Student student;
    @NotNull
    @ManyToOne
    private Course course;
    @NotNull
    private Float score;
    @NotNull
    private Float maximum;


    //Getters and Setters

}
