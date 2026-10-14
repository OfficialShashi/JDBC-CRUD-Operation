package org.example.repository;

import org.example.model.Student;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.Scanner;

public class StudentRepository
{
    String url = "jdbc:mysql://localhost:3306/student_db";
    String user = "root";
    String password = "Shashi@62034";

    public void createUser()
    {
        String sql = "Insert into students(name,email,age) VALUES(?,?,?)";
        try(
                Connection connection = DriverManager.getConnection(url,user,password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                )
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Student Name");
            String name = sc.next();
            System.out.print("Enter Student Email");
            String email = sc.next();
            System.out.print("Enter Student Age");
            int age = sc.nextInt();
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, age);

            int res = preparedStatement.executeUpdate(); // executeUpdate use for CREATE, UPDATE , DELETE
                                            // executeQuery use for READ
                                            // execute use for General Purpose (CRUD) i.e Every way
            if (res == 1)
                System.out.println("Successfully inserted into students");
            else
                System.out.println("Failed to insert into students");
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
            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Press 1 Name \t Press 2 Email ");
                System.out.println("Press 3 Age   ");
                System.out.println("Press 0 EXIT");
                System.out.print("\t Select Option for Update :\t");
                int otp1 = sc.nextInt();
                if (otp1 == 0) {
                    break;
                }
                if (otp1 == 1) {
                    System.out.print("Enter Student ID : ");
                    int A = sc.nextInt();
                    System.out.print("Enter Student Name : ");
                    String N = sc.next();
                    String sql = "UPDATE students SET name = ? WHERE id = ?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, N);
                    ps.setInt(2, A);
                    int res = ps.executeUpdate();
                    if (res == 1)
                        System.out.println("Name Update Successfully into students");
                    else
                        System.out.println("Failed to update into students");
                } else if (otp1 == 2) {
                    System.out.print("Enter Student ID : ");
                    int A = sc.nextInt();
                    System.out.print("Enter Student Email : ");
                    String E = sc.next();
                    String sql = "UPDATE students SET email = ? WHERE id = ?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, E);
                    ps.setInt(2, A);
                    int res = ps.executeUpdate();
                    if (res == 1)
                        System.out.println("Email Update Successfully into students");
                    else
                        System.out.println("Failed to update into students");
                } else if (otp1 == 3) {
                    System.out.print("Enter Student ID : ");
                    int A = sc.nextInt();
                    System.out.print("Enter Student Age : ");
                    int A1 = sc.nextInt();
                    String sql = "UPDATE students SET age = ? WHERE id = ?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setInt(1, A1);
                    ps.setInt(2, A);

                    int res = ps.executeUpdate();
                    if (res == 1)
                        System.out.println("Age Update Successfully into students");
                    else
                        System.out.println("Failed to update into students");
                } else {
                    System.out.println("Invalid Input");
                }
            }
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
        String sql = "select * from students";
        try(Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            )
        {

            ResultSet rt = preparedStatement.executeQuery();
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
        String sql = "delete from students where id = ?";
        Scanner sc = new Scanner(System.in);
        try(Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            )
        {
            System.out.print("Enter Student ID : ");
            int A = sc.nextInt();
            preparedStatement.setInt(1, A);
            int res = preparedStatement.executeUpdate();
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
