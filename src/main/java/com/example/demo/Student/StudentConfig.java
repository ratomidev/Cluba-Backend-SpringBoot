package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
    StudentRepository repository){
        return args -> {
           Student rami = new Student("mich","toumi",20);
           Student ahmed = new Student("ahmed","salah",30);
           Student amir = new Student("amir","amine",20);
           List<Student> ll = new LinkedList<Student>() ;
           ll.add(rami);
           ll.add(ahmed);
           ll.add(amir);
           repository.saveAll(
                    ll
                );
        };

        };

    }

