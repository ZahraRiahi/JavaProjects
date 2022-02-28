package springbootcrudoperation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootcrudoperation.model.Student;
import springbootcrudoperation.service.StudentService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<Student> getByEmail(@RequestParam String email) {
        return ResponseEntity.ok(studentService.getByEmail(email));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity  deleteById(@PathVariable Integer id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Student> saveOrUpdate(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
        return ResponseEntity.ok().build();
    }

}
