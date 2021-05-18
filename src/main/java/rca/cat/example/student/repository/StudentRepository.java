package rca.cat.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rca.cat.example.student.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
