package rca.cat.example.student.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Student {

    //No arg constuctor

    public Student() {
    }


    //All-args-id constructor

    public Student(String names, String email, String gender, Integer age) {
        this.names = names;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }


    //All args constructor


    public Student(Long id, String names, String email, String gender, Integer age) {
        this.id = id;
        this.names = names;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String names;
    @NotNull
    private String email;
    @NotNull
    private String gender;
    @NotNull
    private Integer age;

    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
