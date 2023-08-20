package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherTest() {
        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Ahmad")
                .lastName("Ali")
                //.courses(List.of(courseJava, courseDBA))
                .build();

        teacherRepository.save(teacher);
    }
}