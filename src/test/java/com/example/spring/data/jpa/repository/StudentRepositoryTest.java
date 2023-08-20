package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Guardian;
import com.example.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest// this should not be used for testing but @DataJpaTest should be used, but we want to insert the
    // date into db so we are using SpingBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Student student = Student.builder()
                .emailId("mujahidali@gmail.com")
                .firstName("Mujahid")
                .lastName("Ali")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("Nikhil")
                .mobile("9999956324")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printFirstNameOfStudent() {
        List<Student> students = studentRepository.findByFirstName("Mujahid");

        System.out.println("student = " + students);
    }

    @Test
    public void printFirstNameOfStudentContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Sh");

        System.out.println("student = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Nikhil");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
        List<Student> students = studentRepository.getStudentByEmailAddress("mujahidali@gmail.com");

        System.out.println("student = " + students);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String student = studentRepository.getStudentFirstNameByEmailAddress("shivam@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        List<Student> students = studentRepository.getStudentByEmailAddressNative("mujahidali@gmail.com");

        System.out.println("student = " + students);
    }

    @Test
    public void printStudentByEmailAddressNativeParam() {
        List<Student> students = studentRepository.getStudentByEmailAddressNativeNamedParam("mujahidali@gmail.com");

        System.out.println("student = " + students);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "Sayed Mujahid",
                "mujahidali@gmail.com"
        );
    }

    @Test
    public void printAllStudents() {

        List<Student> studentList = studentRepository.findAll();

        System.out.println("Students List " + studentList);
    }

}