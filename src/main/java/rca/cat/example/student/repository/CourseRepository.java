package rca.cat.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rca.cat.example.student.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
