package com.aarfee.entities;

public class RatingEntity {
    private int id_rating;
    private String description;
    private int rating;
    private int id_inscription_fk;

    public RatingEntity(int id_rating,String description, int rating, int id_inscription_fk) {
        this.id_rating = id_rating;
        this.description = description;
        this.rating = rating;
        this.id_inscription_fk = id_inscription_fk;
    }

    public RatingEntity() {
    }

    public RatingEntity(String description, int rating, int id_inscription_fk) {
        this.description = description;
        this.rating = rating;
        this.id_inscription_fk = id_inscription_fk;
    }

    public int getId_rating() {
        return id_rating;
    }

    public void setId_rating(int id_rating) {
        this.id_rating = id_rating;
    }


    public int getId_inscription_fk() {
        return id_inscription_fk;
    }

    public void setId_inscription_fk(int id_inscription_fk) {
        this.id_inscription_fk = id_inscription_fk;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "RatingEntity{" +
                "id_rating=" + this.id_rating +
                ", description='" + this.description + '\'' +
                ", rating=" + this.rating +
                ", id_inscription_fk=" + this.id_inscription_fk +
                '}';
    }
}
