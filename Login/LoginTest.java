
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 *
 * @author Admin user
*/

package Login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private final Login login = new Login();

    @Test
    public void testCheckUsernameCorrectlyFormatted() {
        boolean actual = login.checkUsername("kyl_1");
        assertTrue(actual, () -> "The username 'kyl_1' should be correctly formatted.");
    }

    @Test
    public void testCheckUsernamePoorlyFormatted() {
        boolean actual = login.checkUsername("kyle!!!!!!!");
        assertFalse(actual, () -> "The username 'kyle!!!!!!!' should be poorly formatted.");
    }

    @Test
    public void testCheckPasswordComplexitySuccess() {
        boolean actual = login.checkPasswordComplexity("Ch&&sec@ke99");
        assertTrue(actual, () -> "The password 'Ch&&sec@ke99' should meet the complexity requirements.");
    }

    @Test
    public void testCheckPasswordComplexityFailure() {
        boolean actual = login.checkPasswordComplexity("password");
        assertFalse(actual, () -> "The password 'password' should fail the complexity requirements.");
    }

    @Test
    public void testRegisterUser() {
        boolean registered = login.registerUser("kyl_1", "Ch&&sec@ke99", "Kyle", "Reese");
        assertTrue(registered, () -> "The user should be registered successfully with correct credentials.");
    }

    @Test
    public void testLoginUser() {
        login.registerUser("kyl_1", "Ch&&sec@ke99", "Kyle", "Reese");
        boolean loggedIn = login.loginUser("kyl_1", "Ch&&sec@ke99");
        assertTrue(loggedIn, () -> "The user should be able to log in with correct credentials.");
    }

    @Test
    public void testLoginUserFailure() {
        login.registerUser("kyl_1", "Ch&&sec@ke99", "Kyle", "Reese");
        boolean loggedIn = login.loginUser("kyl_1", "wrongpassword");
        assertFalse(loggedIn, () -> "The user should not be able to log in with incorrect credentials.");
    }

    @Test
    public void testTaskDescriptionSuccess() {
        Task task = new Task("Login Feature", 0, "Create Login to authenticate users", "Robyn", "Harrison", 8, "To Do");
        assertTrue(task.checkTaskDescription(), () -> "The task description should be valid.");
    }

    @Test
    public void testTaskDescriptionFailure() {
        Task task = new Task("Login Feature", 0, "This is a very long task description that exceeds the fifty character limit.", "Robyn", "Harrison", 8, "To Do");
        assertFalse(task.checkTaskDescription(), () -> "The task description should be invalid as it exceeds 50 characters.");
    }

    @Test
    public void testCreateTaskID() {
        Task task = new Task("Login Feature", 0, "Create Login to authenticate users", "Robyn", "Harrison", 8, "To Do");
        assertEquals("LO:0:SON", task.createTaskID(), "The task ID should be correctly formatted.");
    }

    @Test
    public void testPrintTaskDetails() {
        Task task = new Task("Login Feature", 0, "Create Login to authenticate users", "Robyn", "Harrison", 8, "To Do");
        String expectedDetails = "Task Status: To Do\nDeveloper Details: Robyn Harrison\nTask Number: 0\nTask Name: Login Feature\nTask Description: Create Login to authenticate users\nTask ID: LO:0:SON\nTask Duration: 8 hours";
        assertEquals(expectedDetails, task.printTaskDetails(), "The task details should be printed correctly.");
    }
}
