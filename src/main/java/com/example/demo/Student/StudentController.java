package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class StudentController {
    private final StudentService studentService;

 @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping("/v1/api/getStudents")
    public List<Student> getStudents() {
       return studentService.getStudents();
    }

    @PostMapping ("/v1/api/addStudent")
    public void registerNewStudent(@RequestBody Student student){
     studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
     studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
           @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String lastName
    ) {
     studentService.updateStudent(studentId,name,lastName);
    }

}
