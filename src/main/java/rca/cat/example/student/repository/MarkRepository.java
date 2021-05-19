package rca.cat.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rca.cat.example.student.domain.Mark;

@Repository
public interface MarkRepository extends JpaRepository<Mark,Long> {
}
