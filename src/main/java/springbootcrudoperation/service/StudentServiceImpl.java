package springbootcrudoperation.service;

import org.springframework.stereotype.Service;
import springbootcrudoperation.model.Student;
import springbootcrudoperation.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public void saveOrUpdate(Student student) {
        if (student.getId() != null) {
            Student oldStudent = studentRepository.findById(student.getId()).get();
            oldStudent.setName(student.getName());
            oldStudent.setFamily(student.getFamily());
            oldStudent.setEmail(student.getEmail());
            oldStudent.setAddress(student.getAddress());
            studentRepository.save(oldStudent);
        } else
            studentRepository.save(student);

    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);

    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

}
