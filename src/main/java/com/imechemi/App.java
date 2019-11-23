package com.imechemi;

import com.imechemi.model.Loan;
import com.imechemi.model.Student;
import com.imechemi.repository.bank.LoanRepository;
import com.imechemi.repository.school.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@Slf4j
public class App implements CommandLineRunner {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private StudentRepository studentRepository;


    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = studentRepository.insert(new Student("Tenzin"));
        Loan loan = loanRepository.insert(new Loan(student.getId(), 24000));
        log.info("{} borrowed {} from the bank", student.getName(), loan.getAmount());
    }
}
