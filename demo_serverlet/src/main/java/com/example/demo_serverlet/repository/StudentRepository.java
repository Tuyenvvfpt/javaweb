package com.example.demo_serverlet.repository;

import com.example.demo_serverlet.entities.Student;
import com.example.demo_serverlet.utils.DBContext;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class StudentRepository {
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        DBContext context = new DBContext();

        Connection connection = context.openConnection();
        String sql = "select * from student";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("studentId"));
                student.setName(resultSet.getString("studentName"));
                student.setAddress(resultSet.getString("studentAddress"));
                student.setAge(resultSet.getInt("studentAge"));
                studentList.add(student);
            }
            return studentList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<Student>();
        }

    }

    public Student findById(int id) {

        DBContext context = new DBContext();

        Connection connection = context.openConnection();
        String sql = "select * from student where studentId =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            Student student = new Student();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                student.setId(resultSet.getInt("studentId"));
                student.setName(resultSet.getString("studentName"));
                student.setAddress(resultSet.getString("studentAddress"));
                student.setAge(resultSet.getInt("studentAge"));

            }
            return student;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Student();
        }

    }
    public int update(Student student){

        DBContext context = new DBContext();

        Connection connection = context.openConnection();
        String sql = "update student set studentName = ? , studentAddress =? , studentAge = ? where studentId = ? ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getAddress());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setInt(4, (int) student.getId());
           int flag =  preparedStatement.executeUpdate();
           return  flag;

        }catch (Exception e){
            return 0;
        }
    }
    public int delete(int id){
        DBContext context = new DBContext();

        Connection connection = context.openConnection();
        String sql = "delete from student where studentId = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate();

        }catch (Exception e){
            return  0;
        }

    }



}
