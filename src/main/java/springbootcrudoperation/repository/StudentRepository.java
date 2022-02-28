package springbootcrudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootcrudoperation.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);
}
