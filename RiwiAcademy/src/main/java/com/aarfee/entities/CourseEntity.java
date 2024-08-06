package com.aarfee.entities;

public class CourseEntity {
    private int id_course;
    private String name;

    public CourseEntity(int id_course, String name ) {
        this.id_course = id_course;
        this.name = name;
    }

    public CourseEntity() {
    }

    public CourseEntity(String name) {
        this.name = name;
    }


    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "id_course=" + this.id_course +
                ", name='" + this.name + '\'' +
                '}';
    }
}
