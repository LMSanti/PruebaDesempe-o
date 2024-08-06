package com.aarfee.models;

import com.aarfee.entities.CourseEntity;
import com.aarfee.persistence.configDB.ConnectionDB;
import com.aarfee.persistence.imodel.ICourserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseModel implements ICourserModel {
    @Override
    public CourseEntity create(CourseEntity request) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "INSERT INTO courses(id_course,name) VALUES (?,?);";
        CourseEntity course = new CourseEntity();

        try {
            PreparedStatement ppst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ppst.setInt(1, request.getId_course());
            ppst.setString(2, request.getName());
            ppst.executeUpdate();

            ResultSet generatedKeys = ppst.getGeneratedKeys();

            if (generatedKeys.next()){
                course.setId_course(generatedKeys.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection();
        }
        return course;
    }

    @Override
    public Boolean delete(int id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "DELETE FROM courses WHERE id_course = ?;";

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setInt(1, id);
            ppst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }
        return true;
    }

    @Override
    public ArrayList<CourseEntity> readAll() {
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM courses;";
        ArrayList<CourseEntity> courses = new ArrayList<>();

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()){
                CourseEntity course = new CourseEntity(
                        rs.getInt("id_course"),
                        rs.getString("name")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }

        return courses;
    }

    @Override
    public CourseEntity readById(int id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM courses WHERE id_course = ?;";
        CourseEntity course = null;

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setInt(1, id);
            ResultSet rs = ppst.executeQuery();

            if(rs.next()){
                course = new CourseEntity(
                        rs.getInt("id_course"),
                        rs.getString("name")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection();
        }

        return course;
    }

    @Override
    public CourseEntity upDate(Object object, int id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "UPDATE courses SET name = ? WHERE id_course= ?;";
        CourseEntity course = new CourseEntity();

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setString(1, course.getName());
            ppst.setInt(2, id);
            ppst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }
        return course;
    }
}
