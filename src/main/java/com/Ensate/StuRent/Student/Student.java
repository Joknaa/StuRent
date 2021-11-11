package com.Ensate.StuRent.Student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private String firstName;
    private String lastName;
    private Long id;
    private LocalDate dayOfBirth;
    private int age;
    private String email;


    public Student() {}

    public Student(String firstName, String lastName, Long id, LocalDate dayOfBirth, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dayOfBirth = dayOfBirth;
        this.age = age;
        this.email = email;
    }

    public Student(String firstName, String lastName, LocalDate dayOfBirth, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Long getId() { return id; }
    public LocalDate getDayOfBirth() { return dayOfBirth; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setId(Long id) { this.id = id; }
    public void setDayOfBirth(LocalDate dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
}
