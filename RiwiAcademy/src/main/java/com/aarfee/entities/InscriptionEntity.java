package com.aarfee.entities;

public class InscriptionEntity {
    private int id_inscription;
    private int id_course_fk;
    private int id_student_fk;

    public InscriptionEntity(int id_inscription, int id_course_fk,  int id_student_fk) {
        this.id_inscription = id_inscription;
        this.id_course_fk = id_course_fk;
        this.id_student_fk = id_student_fk;
    }

    public InscriptionEntity() {
    }

    public InscriptionEntity(int id_course_fk, int id_student_fk) {
        this.id_course_fk = id_course_fk;
        this.id_student_fk = id_student_fk;

    }



    public int getId_inscription() {
        return id_inscription;
    }

    public void setId_inscription(int id_inscription) {
        this.id_inscription = id_inscription;
    }

    public int getId_course_fk() {
        return id_course_fk;
    }

    public void setId_course_fk(int id_course_fk) {
        this.id_course_fk = id_course_fk;
    }

    public int getId_student_fk() {
        return id_student_fk;
    }

    public void setId_student_fk(int id_student_fk) {
        this.id_student_fk = id_student_fk;
    }


    @Override
    public String toString() {
        return "InscriptionEntity{" +
                "id_inscription=" + this.id_inscription +
                ", id_course_fk=" + this.id_course_fk +
                ", id_student_fk=" + this.id_student_fk +
                '}';
    }
}
