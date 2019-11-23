package com.imechemi;

import com.imechemi.model.Student;
import com.imechemi.repository.bank.LoanRepository;
import com.imechemi.repository.school.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App {

//    @Autowired
//    private LoanRepository loanRepository;
//
//    @Autowired
//    private StudentRepository studentRepository;
//

    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Student student = new Student("Lobsang");
//        studentRepository.insert(student);
//        System.out.println(studentRepository.findAll().size());
//    }
}
