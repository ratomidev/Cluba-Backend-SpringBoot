package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public List<Student> getStudents(){
       return studentRepository.findAll();

    }


    public void addNewStudent(Student student) {
      Optional<Student> studentOptional = studentRepository.findStudentByLastName(student.getLastName());
      if(studentOptional.isPresent())
       throw new IllegalThreadStateException("Email taken");
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {
        studentRepository.findById(studentId);
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("dosnt exist");
        }
        studentRepository.deleteById(studentId);
        }

    @Transactional
    public void updateStudent(Long studentId, String name, String lastName) {
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException(
                "No student with this id"
        ));
       student.setName(name);
       student.setLastName(lastName);
    }
}
