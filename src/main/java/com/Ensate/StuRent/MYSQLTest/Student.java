package com.Ensate.StuRent.MYSQLTest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "usersNEW") // This tells Hibernate to make a table out of this class
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)


    private Long id;
    private String firstName;
    private String lastName;
    private String dayOfBirth;
    private int age;
    private String email;


    public Student() {}

    public Student(String firstName, String lastName, Long id, String dayOfBirth, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dayOfBirth = dayOfBirth;
        this.age = age;
        this.email = email;
    }

    public Student(String firstName, String lastName, String dayOfBirth, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Long getId() { return id; }
    public String getDayOfBirth() { return dayOfBirth; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setId(Long id) { this.id = id; }
    public void setDayOfBirth(String dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
}