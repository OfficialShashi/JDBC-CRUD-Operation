package org.example;

import org.example.repository.StudentRepository;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\t\t This is First JDBC CRUD Operation.........!");
        System.out.println("\n====================================================================");

        StudentRepository studentRepository = new StudentRepository();
        //studentRepository.createUser();
        //studentRepository.updateUser();
        //studentRepository.DeleteUser();
        studentRepository.getreadUserById();
    }
}

// jdbc:mysql://localhost:3306/student_db