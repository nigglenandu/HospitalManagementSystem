package com.nigglespringboot.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastNamr;
    private String gender;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNamr() {
        return lastNamr;
    }

    public void setLastNamr(String lastNamr) {
        this.lastNamr = lastNamr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastNamr='" + lastNamr + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
