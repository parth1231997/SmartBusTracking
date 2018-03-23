package com.example.parthbambhaniya.smartbustracking;

/**
 * Created by bmpar on 1/10/2018.
 */

public class Model
{
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHoobies(String hoobies) {
        this.hoobies = hoobies;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    private String name;
    private String email;
    private String contact;
    private String dob;
    private String gender;
    private String hoobies;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getHoobies() {
        return hoobies;
    }

    public String getCourse() {
        return course;
    }

    private String course;

}
