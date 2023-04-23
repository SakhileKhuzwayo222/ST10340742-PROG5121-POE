/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Admin user
 */
public class LoginTest {
    
    public LoginTest() {
    }

    Login login  = new Login ();

    @Test
    public void testCheckUserNameCorrectlyFormatted() 
    {
        boolean actual = login.checkUserName("kyl_1");
        assertTrue(actual);
    }
    
      @Test
    public void testCheckUserNamePoorlyFormatted() 
    {
        boolean actual = login.checkUserName("kyle!!!!!!!”);
);
        assertFalse(actual);
    }

    @Test
    public void testCheckPasswordComplexitySuccess() 
    {
        boolean actual = login.checkPasswordComplexity("Ch&&sec@ke99!”");
        assertTrue(actual);
    }
    
      @Test
    public void testCheckPasswordComplexityFailure() 
    {
        boolean actual = login.checkPasswordComplexity("password”");
        assertFalse(actual);
    }

    @Test
    public void testRegisterUser() 
    {
    }

    @Test
    public void testLoginUser() {
    }
    
   
    
}