package com.aarfee.models;

import com.aarfee.entities.StudentEntity;
import com.aarfee.persistence.configDB.ConnectionDB;
import com.aarfee.persistence.imodel.IStudentModel;
import com.aarfee.utils.enums.ActiveEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentModel implements IStudentModel {
    @Override
    public StudentEntity create(StudentEntity request) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "INSERT INTO students(id_student,name,last_name,document,email,status) VALUES(?,?,?,?,?,?);";
        StudentEntity student = new StudentEntity();

        try {
            PreparedStatement ppst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ppst.setInt(1, request.getId_student());
            ppst.setString(2, request.getName());
            ppst.setString(3, request.getLast_name());
            ppst.setString(4, request.getDocument());
            ppst.setString(5, request.getEmail());
            ppst.setString(6, request.getStatus().name());
            ppst.executeUpdate();

            ResultSet generatedKeys = ppst.getGeneratedKeys();

            if (generatedKeys.next()){
                student.setId_student(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }

        return student;
    }



    @Override
    public ArrayList<StudentEntity> readAll() {
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM students;";
        ArrayList<StudentEntity> students = new ArrayList<>();

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ResultSet rs = ppst.executeQuery();

            while (rs.next()){
                StudentEntity student = new StudentEntity(
                        rs.getInt("id_student"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("document"),
                        rs.getString("email"),
                        ActiveEnum.valueOf(rs.getString("status"))
                );
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }

        return students;
    }

    @Override
    public StudentEntity readByEmail(String email) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM students WHERE email = ?;";
        StudentEntity student = null;

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setString(1, email);
            ResultSet rs = ppst.executeQuery();

            if (rs.next()){
                student = new StudentEntity(
                        rs.getInt("id_student"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("document"),
                        rs.getString("email"),
                        ActiveEnum.valueOf(rs.getString("status"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection();
        }
        return student;
    }

    @Override
    public StudentEntity readById(int id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM students WHERE id_student = ?;";
        StudentEntity student = null;

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setInt(1, id);
            ResultSet rs = ppst.executeQuery();

            if (rs.next()){
                student = new StudentEntity(
                        rs.getInt("id_student"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("document"),
                        rs.getString("email"),
                        ActiveEnum.valueOf(rs.getString("status"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection();
        }
        return student;
    }

    @Override
    public StudentEntity upDate(Object object, int id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "UPDATE students SET name = ?, last_name = ?, document = ?, email = ?, status = ? WHERE id_student = ?;";
        StudentEntity student = new StudentEntity();

        try {
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setString(1, student.getName());
            ppst.setString(2, student.getLast_name());
            ppst.setString(3, student.getDocument());
            ppst.setString(4, student.getEmail());
            ppst.setString(5, student.getStatus().name());
            ppst.setInt(6, id);
            ppst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }
        return student;
    }
}
