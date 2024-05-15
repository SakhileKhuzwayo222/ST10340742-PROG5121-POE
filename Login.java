/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Admin user
 */
package Login;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Login {

    private String storedUserName;
    private String storedPassword;
    private String storedFirstName;
    private String storedLastName;
    private boolean loggedIn = false;
    private ArrayList<Task> tasks = new ArrayList<>();
    private int totalHours = 0;

    public static void main(String[] args) {
        Login login = new Login();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your first name : ");
        String firstName = input.nextLine();

        System.out.println("Enter your last name : ");
        String lastName = input.nextLine();

        System.out.println("Enter your user name : ");
        String userName = input.nextLine();

        System.out.println("Enter your profile password : ");
        String password = input.nextLine();

        if (login.registerUser(userName, password, firstName, lastName)) {
            System.out.println("User has been registered successfully.");
            System.out.println("Enter your user name to login: ");
            String loginUserName = input.nextLine();

            System.out.println("Enter your password to login: ");
            String loginPassword = input.nextLine();

            if (login.loginUser(loginUserName, loginPassword)) {
                System.out.println(login.returnLoginStatus(true));
                System.out.println("Welcome to EasyKanban");

                while (true) {
                    System.out.println("Please select an option:");
                    System.out.println("1) Add tasks");
                    System.out.println("2) Show report");
                    System.out.println("3) Quit");

                    int choice = input.nextInt();
                    input.nextLine(); // consume newline

                    if (choice == 1) {
                        login.addTasks(input);
                    } else if (choice == 2) {
                        System.out.println("Coming Soon.");
                    } else if (choice == 3) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else {
                System.out.println(login.returnLoginStatus(false));
            }
        } else {
            System.out.println("User registration failed.");
        }

        input.close();
    }

    public boolean checkUsername(String userName) {
        if (userName.contains("_") && userName.length() <= 5) {
            System.out.println("User name successfully captured.");
            return true;
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return false;
        }
    }

    public boolean checkPasswordComplexity(String userPassword) {
        if (userPassword.length() >= 8 && userPassword.matches(".*[A-Z].*") && userPassword.matches(".*[0-9].*") && userPassword.matches(".*[^a-zA-Z0-9].*")) {
            System.out.println("Password successfully captured.");
            return true;
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return false;
        }
    }

    public boolean registerUser(String userName, String password, String firstName, String lastName) {
        if (checkUsername(userName) && checkPasswordComplexity(password)) {
            storedUserName = userName;
            storedPassword = password;
            storedFirstName = firstName;
            storedLastName = lastName;
            return true;
        }
        return false;
    }

    public boolean loginUser(String userName, String userPassword) {
        if (storedUserName.equals(userName) && storedPassword.equals(userPassword)) {
            loggedIn = true;
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("An invalid username or password has been entered.");
            return false;
        }
    }

    public String returnLoginStatus(boolean successfulLogin) {
        if (successfulLogin) {
            return "Welcome " + storedFirstName + " " + storedLastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public void addTasks(Scanner input) {
        if (!loggedIn) {
            System.out.println("You must be logged in to add tasks.");
            return;
        }

        System.out.println("How many tasks would you like to enter?");
        int numTasks = input.nextInt();
        input.nextLine(); // consume newline

        for (int i = 0; i < numTasks; i++) {
            System.out.println("Enter the task name: ");
            String taskName = input.nextLine();

            System.out.println("Enter the task description (max 50 characters): ");
            String taskDescription = input.nextLine();
            while (taskDescription.length() > 50) {
                System.out.println("Please enter a task description of less than 50 characters:");
                taskDescription = input.nextLine();
            }

            System.out.println("Enter the developer's first name: ");
            String developerFirstName = input.nextLine();

            System.out.println("Enter the developer's last name: ");
            String developerLastName = input.nextLine();

            System.out.println("Enter the estimated duration of the task in hours: ");
            int taskDuration = input.nextInt();
            input.nextLine(); // consume newline

            System.out.println("Select the task status (1 for To Do, 2 for Done, 3 for Doing): ");
            int statusChoice = input.nextInt();
            input.nextLine(); // consume newline
            String taskStatus;
            switch (statusChoice) {
                case 1:
                    taskStatus = "To Do";
                    break;
                case 2:
                    taskStatus = "Done";
                    break;
                case 3:
                    taskStatus = "Doing";
                    break;
                default:
                    taskStatus = "Unknown";
                    break;
            }

            Task task = new Task(taskName, i, taskDescription, developerFirstName, developerLastName, taskDuration, taskStatus);
            tasks.add(task);
            totalHours += taskDuration;
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }

        System.out.println("Total hours across all tasks: " + totalHours);
    }
}

class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private int taskDuration;
    private String taskStatus;
    private String taskID;

    public Task(String taskName, int taskNumber, String taskDescription, String developerFirstName, String developerLastName, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        return (taskName.substring(0, 2) + ":" + taskNumber + ":" + developerLastName.substring(developerLastName.length() - 3)).toUpperCase();
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\nDeveloper Details: " + developerFirstName + " " + developerLastName +
               "\nTask Number: " + taskNumber + "\nTask Name: " + taskName +
               "\nTask Description: " + taskDescription + "\nTask ID: " + taskID +
               "\nTask Duration: " + taskDuration + " hours";
    }

    public int returnTotalHours() {
        return taskDuration;
    }
}
