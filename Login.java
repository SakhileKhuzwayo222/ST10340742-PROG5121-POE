/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author Admin user
 */
import java.util.Scanner;



public class Login {
   
    
    String storedUserName;
    String storedPassword;
    String storedFirstName;
    String storedLastName;
  
   
    public static void main(String[] args){
        
        System.out.println("Enter your first name : ");
        Scanner input = new Scanner(System.in);
        String storedFirstName = input.nextLine();
        
        System.out.println("Enter your last name : ");
        Scanner input = new Scanner(System.in);
        String storedLastName = input.nextLine();
        
        System.out.println("Enter your user name : ");
        Scanner input = new Scanner(System.in);
        String storedUserName = input.nextLine();
        //run check username
        
        System.out.println("Enter your profile password : ");
        Scanner input = new Scanner(System.in);
        String storedUserName = input.nextLine();
         //run check username
         
    }
        
  
 
  
    public boolean checkUsername(String userName)   {
      
      boolean correctUserNameFormat;
      
      if(userName.length()<=5)  {
      
          boolean correctUsernameFormat = true;
          System.out.println("User name successfully captured.");
      }
      else  {
        correctUserNameFormat = false;
        System.out.println("“Username is not correctly formatted, please ensure that your username contains an underscore "
        + "and is no more than 5 characters in length .”")
          
         
      }
      
      return correctUserNameFormat;
    }
  
    
    
    public boolean checkPasswordComplexity(String userPassword)   {
      
      boolean passwordComplexity;
      
      if(userPassword.length()>=8)  {
          passwordComplexitiy = true;
          System.out.println("“Password successfully captured”");
      }
      else  {
          passwordComplexity = false;
          System.out.println("Password is not correctly formatted, "
                  + "please ensure that the password contains at least"
                  + " 8 characters, a capital letter, a number and a special character.");
      }
      
      return passwordComplexity;
    }
  
    
    
    public String registerUser(String userName, String password, String firstName, String lastName)   {
      
      if(checkUserName(userName) && checkPasswordComplexity(password))  {
           
          storedUserName = userName;
            storedPassword = password;
            storedFirstName = firstName;
            storedLastName = lastName;
            
            System.out.println("User has been registered successfully. ");
      
      }
      
    }
  
    
    
    public boolean loginUser(String userName, String userPassword)   {
       
       boolean successfulLogin;
       
       if (storedUserName.equals(userName) && storedPassword.matches( "(?=.*[A-Z])(?=.*[0-9]).*") ){
           
           successfulLogin = true;
           System.out.println("Login successful.");
       }
       else {
           
           successfulLogin = false;
           System.out.println("An invalid username or password has been entered.");
       }
       
       return successfulLogin;
   }
   
   public String returnLoginStatus(boolean successfulLogin )    {
       
        
       String loginMessage = null;
       
       if(loggedIn) {
           loginMessage = "Welcome" + storedFirstName + " " + storedLastName + " " + "it is great to see you again";
       }
       else {
           loginMessage = "Username or password incorrect, please try again.";
       }
       
       return loginMessage;
   }
  
  
  
}
