package org.example.repository;

import org.example.model.Student;

import java.sql.*;

public class StudentRepository
{
    String url = "jdbc:mysql://localhost:3306/student_db";
    String user = "root";
    String password = "Shashi@62034";

    public void createUser()
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            String sql = "Insert into students(name,email,age) VALUES('Raj','raj123@gmail.com',26)";
            int res = statement.executeUpdate(sql); // executeUpdate use for CREATE, UPDATE , DELETE
                                            // executeQuery use for READ
                                            // execute use for General Purpose (CRUD) i.e Every way
            if (res == 1)
                System.out.println("Successfully inserted into students");
            else
                System.out.println("Failed to insert into students");

            connection.close();
        }catch (SQLException e)
        {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }

    public void updateUser()
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            String sql = "UPDATE students set age=30 where id = 1";
            int res = statement.executeUpdate(sql);
            if (res == 1)
                System.out.println("Successfully updated into students");
            else
                System.out.println("Failed to update into students");
            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }

    public void getreadUserById()
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            String sql = "select * from students";
            ResultSet rt = statement.executeQuery(sql);
            while(rt.next())
            {
                Student student = mapRow(rt);
                System.out.println(student);
            }

            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }
    private Student mapRow(ResultSet rs) throws SQLException
    {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setEmail(rs.getString("email"));
        student.setAge(rs.getInt("age"));
        return student;
    }

    public void DeleteUser()
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            String sql = "delete from students where id = 1";
            int res = statement.executeUpdate(sql);
            if (res == 1)
                System.out.println("Successfully deleted from students");
            else
                System.out.println("Failed to delete from students");
            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }

    // Execute define

    public void CRUDOperations()
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            String sql = "delete from students where id = 1";
            boolean res = statement.execute(sql);

            if (res)
                System.out.println("Successfully deleted from students");
            else
                System.out.println("Failed to delete from students");

            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }

}
