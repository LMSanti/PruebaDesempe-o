package com.aarfee.entities;

import com.aarfee.utils.enums.ActiveEnum;

public class StudentEntity {
    private int id_student;
    private String name;
    private String last_name;
    private String document;
    private String email;
    private ActiveEnum status;

    public StudentEntity(int id_student, String name, String last_name, String document, String email, ActiveEnum status) {
        this.id_student = id_student;
        this.name = name;
        this.last_name = last_name;
        this.document = document;
        this.email = email;
        this.status = status;
    }

    public StudentEntity() {
    }

    public StudentEntity(String name, String last_name, String document, String email, ActiveEnum status) {
        this.name = name;
        this.last_name = last_name;
        this.document = document;
        this.email = email;
        this.status = status;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public ActiveEnum getStatus() {
        return status;
    }

    public void setStatus(ActiveEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id_student=" + id_student +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", document='" + document + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
