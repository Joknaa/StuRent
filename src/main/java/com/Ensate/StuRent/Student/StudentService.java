package com.Ensate.StuRent.Student;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudent() {
        return List.of(
                new Student("Oknaa", "Kun", LocalDate.of(1998, Month.JUNE, 25), 23, "Email@mail.com")
        );
    }
}
