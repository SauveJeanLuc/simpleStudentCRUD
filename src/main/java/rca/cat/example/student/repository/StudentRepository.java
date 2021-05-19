package rca.cat.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rca.cat.example.student.domain.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findStudentByFirstName();
}
