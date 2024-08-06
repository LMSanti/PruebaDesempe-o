package com.aarfee.models;

import com.aarfee.entities.RatingEntity;
import com.aarfee.persistence.configDB.ConnectionDB;
import com.aarfee.persistence.imodel.IRatingModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RatingModel implements IRatingModel {
    @Override
    public RatingEntity create(RatingEntity request) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "INSERT INTO ratings(id_rating,description,rating,id_inscription_fk) VALUES(?,?,?,?);";
        RatingEntity rating = new RatingEntity();

        try {
            PreparedStatement ppst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ppst.setInt(1, request.getId_rating());
            ppst.setString(2, request.getDescription());
            ppst.setInt(3, request.getRating());
            ppst.setInt(4, request.getId_inscription_fk());
            ppst.executeUpdate();

            ResultSet generatedKeys = ppst.getGeneratedKeys();

            if (generatedKeys.next()){
                rating.setId_rating(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }
        return rating;
    }


    @Override
    public ArrayList<RatingEntity> readAll() {
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM ratings;";
        ArrayList<RatingEntity> ratings = new ArrayList<>();

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()){
                RatingEntity rating = new RatingEntity(
                        rs.getInt("id_rating"),
                        rs.getString("description"),
                        rs.getInt("rating"),
                        rs.getInt("id_inscription_fk")
                );
                ratings.add(rating);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }

        return ratings;
    }

    @Override
    public RatingEntity readById(int id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM ratings WHERE id_rating = ?;";
        RatingEntity rating = null;

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setInt(1, id);
            ResultSet rs = ppst.executeQuery();

            if (rs.next()){
                rating = new RatingEntity(
                        rs.getInt("id_rating"),
                        rs.getString("description"),
                        rs.getInt("rating"),
                        rs.getInt("id_inscription_fk")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection();
        }
        return rating;
    }

    @Override
    public RatingEntity upDate(Object object, int id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "UPDATE ratings SET description = ?, rating = ?, id_inscription_fk = ? WHERE id_rating = ? ;";
        RatingEntity rating = new RatingEntity();

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setString(1, rating.getDescription());
            ppst.setInt(2, rating.getRating());
            ppst.setInt(3, rating.getId_inscription_fk());
            ppst.setInt(4, id);
            ppst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }
        return rating;
    }

}
