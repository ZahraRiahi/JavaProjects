package springbootcrudoperation.service;

import springbootcrudoperation.model.Student;

import java.util.List;

public interface StudentService {
    Student getByEmail(String email);
    void saveOrUpdate(Student student);
    void delete(Integer id);
    List<Student> getAll();

}
