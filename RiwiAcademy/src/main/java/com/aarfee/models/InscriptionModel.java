package com.aarfee.models;

import com.aarfee.entities.InscriptionEntity;
import com.aarfee.persistence.configDB.ConnectionDB;
import com.aarfee.persistence.imodel.IInscriptionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InscriptionModel implements IInscriptionModel {
    @Override
    public InscriptionEntity create(InscriptionEntity request) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "INSERT INTO inscriptions(id_inscription,id_course_fk,id_student_fk) VALUES(?,?,?);";
        InscriptionEntity  inscription = new InscriptionEntity();

        try {
            PreparedStatement ppst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ppst.setInt(1, request.getId_inscription());
            ppst.setInt(2, request.getId_course_fk());
            ppst.setInt(3, request.getId_student_fk());
            ppst.executeUpdate();

            ResultSet generatedKeys = ppst.getGeneratedKeys();

            if (generatedKeys.next()){
                inscription.setId_inscription(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection();
        }
        return inscription;
    }

    @Override
    public Boolean delete(int id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "DELETE FROM inscriptions WHERE id_inscription = ?;";

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setInt(1, id);
            ppst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection();
        }
        return true;
    }

    @Override
    public ArrayList<InscriptionEntity> readAll() {
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM inscriptions;";
        ArrayList<InscriptionEntity> inscriptions = new ArrayList<>();

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ResultSet rs = ppst.executeQuery();

            while (rs.next()){
                InscriptionEntity inscription = new InscriptionEntity(
                        rs.getInt("id_inscription"),
                        rs.getInt("id_course_fk"),
                        rs.getInt("id_student_fk")
                );
                inscriptions.add(inscription);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }

        return inscriptions;
    }

    @Override
    public InscriptionEntity readById(int id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM inscriptions WHERE id_inscription = ?;";
        InscriptionEntity inscription = null;

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setInt(1, id);
            ResultSet rs = ppst.executeQuery();

            if (rs.next()){
                inscription = new InscriptionEntity(
                        rs.getInt("id_inscription"),
                        rs.getInt("id_course_fk"),
                        rs.getInt("id_student_fk")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection();
        }

        return inscription;
    }

    @Override
    public InscriptionEntity upDate(Object object, int id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "UPDATE inscriptions SET id_course_fk = ?, id_student_fk = ? WHERE id_inscription = ?;";
        InscriptionEntity inscription = new InscriptionEntity();

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setInt(1, inscription.getId_course_fk());
            ppst.setInt(2, inscription.getId_student_fk());
            ppst.setInt(3, id);
            ppst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }

        return inscription;
    }
}
