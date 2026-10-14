package org.example;

import java.util.Scanner;
import org.example.repository.StudentRepository;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t This is First JDBC CRUD Operation.........!");
        System.out.println("\n====================================================================");

        while (true) {

            StudentRepository studentRepository = new StudentRepository();
            System.out.println("Press 1 Create New User \t Press 2 Update User ");
            System.out.println("Press 3 Delete User     \t Press 4 Show All Users");
            System.out.println("Press 0 EXIT");
            System.out.print("\t Select Option for CRUD Operation...:\t");
            int otp = sc.nextInt();
            if (otp == 0) {
                System.out.print("Thank you for using our CRUD Operation.....");
                break;
            }
            if (otp == 1) {
                studentRepository.createUser();
            }
            else if (otp == 2) {
                studentRepository.updateUser();
            }
            else if (otp == 3) {
                studentRepository.DeleteUser();
            }
            else if (otp == 4) {
                studentRepository.getreadUserById();
            }
            else {
                System.out.println("Invalid Input Please Enter Valid Option");
            }
        }


    }
}

// jdbc:mysql://localhost:3306/student_db