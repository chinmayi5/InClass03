package com.example.kchin.inclass03;

import java.io.Serializable;

/**
 * Created by Stephen on 1/29/2018.
 */

public class Student implements Serializable{

    private String name;
    private String email;
    private String department;
    private String mood;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
