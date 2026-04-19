/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.part1poe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DeLL
 */
public class LoginTest {
    
    // Create an instance of the Login class to test its methods
    Login login = new Login();

    @Test
    public void testUsernameCorrect() {
        // Test Data: kyl_1 (Contains _ and is 5 chars)
        boolean result = login.checkUserName("kyl_1");
        assertTrue("Username 'kyl_1' should be valid", result);
    }

    @Test
    public void testUsernameIncorrect() {
        // Test Data: kyle!!!!!!! (No underscore and too long)
        boolean result = login.checkUserName("kyle!!!!!!!");
        assertFalse("Username 'kyle!!!!!!!' should be invalid", result);
    }

    @Test
    public void testPasswordComplexitySuccess() {
        // Test Data: Ch&&sec@ke99! (Meets all requirements)
        boolean result = login.checkPasswordComplexity("Ch&&sec@ke99!");
        assertTrue("Password meets complexity requirements", result);
    }

    @Test
    public void testPasswordComplexityFailure() {
        // Test Data: password (Too short, no caps, no special)
        boolean result = login.checkPasswordComplexity("password");
        assertFalse("Password does not meet complexity requirements", result);
    }
    
    @Test
    public void testCellPhoneNumberCorrect() {
        // Test Data: +27838968976
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertTrue("Cell phone number correctly formatted", result);
    }
    
    @Test
    public void testCellPhoneNumberIncorrect() {
        // Test Data: 08966553 (Missing international code)
        boolean result = login.checkCellPhoneNumber("08966553");
        assertFalse("Cell phone number incorrectly formatted", result);
    }

    @Test
    public void testLoginSuccess() {
        // Mock registration first
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");
        
        // Test login with same details
        boolean result = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue("Login should be successful", result);
    }

    @Test
    public void testLoginFailure() {
        // Mock registration first
        Login.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");
        
        // Test login with WRONG details
        boolean result = Login.LoginUser("wrong_user", "wrong_pass");
        assertFalse("Login should fail", result);
    }
}