/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1poe;

/**
 *
 * @author DeLL
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    private static boolean checkUsername(String u) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static boolean checkCellPhoneNumber(String c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static boolean checkPasswordComplexity(String p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String authUser;
    private String authPass;
    private static ArrayList<Login> activeRecords = new ArrayList<>();

    public Login(String u, String p) {
        this.authUser = u;
        this.authPass = p;
    }

    public static void addTestUser(Login r) { activeRecords.add(r); }

    Login() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean loginUser() {
        // this is a loop to check the list of active records to see if they match the username and password
        for (int i = 0; i < activeRecords.size(); i++) {
            Login r = activeRecords.get(i);
            if (r.getName().equals(authUser) && r.getPassword().equals(authPass)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the Login System");

        while (true) {
            System.out.print("\n1) Register\n2) Log\n3) Exit\nPick: ");
            String op = console.nextLine().trim();

            if (op.equals("1")) {
                processReg(console);
            } else if (op.equals("2")) {
                processLog(console);
            } else if (op.equals("3") || op.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private static void processReg(Scanner sc) {
        System.out.println("\n--- User Signup ---");
        System.out.println("Enter your name:");
        String u = sc.nextLine();
        while (!Login.checkUsername(u)) u = sc.nextLine();

        System.out.println("Enter cell (+27...):");
        String c = sc.nextLine();
        while (!Login.checkCellPhoneNumber(c)) c = sc.nextLine();

        System.out.println("Create password:");
        String p = sc.nextLine();
        while (!Login.checkPasswordComplexity(p)) p = sc.nextLine();

        
        System.out.println("Registration successful!");
    }

    private static void processLog(Scanner sc) {
        if (activeRecords.isEmpty()) {
            System.out.println("No users registered yet.");
            return;
        }
        System.out.print("User: ");
        String u = sc.nextLine();
        System.out.print("Pass: ");
        String p = sc.nextLine();

        if (new Login(u, p).loginUser()) {
            System.out.println("Login successful! Welcome, " + u + ".");
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }

    private Object getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Object getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean checkUserName(String kyl_1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
   