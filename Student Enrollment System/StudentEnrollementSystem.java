//Laith Amro
//1230018
//Dr. Abdallah Karakra
//Section 1
import java.util.*;

public class StudentEnrollementSystem {//I didnt know if to name the file driver or this 
    private static Course[] courses = new Course[10];  //array of object to store objects of kind course
    private static Student[] students = new Student[10];  //same but for students
    private static int courseCount = 0;  //initalize the counters
    private static int studentCount = 0;  

    public static void printMenu() {//print menu method
        System.out.println("\nMenu:");
        System.out.println("1. Add a new course");
        System.out.println("2. Add a new student");
        System.out.println("3. Enroll a student in a course");
        System.out.println("4. Update the details of a student's enrollment");
        System.out.println("5. Remove a student from a course");
        System.out.println("6. Display the list of students enrolled in a course");
        System.out.println("7. Display the list of available courses");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {//main class
        Scanner input = new Scanner(System.in);//scanner
        boolean exit = false;//initialize the exit boolean

        while (!exit) {//if the user didnt set the boolean to true then keep on looping
            printMenu();//print menu method

                int choice = input.nextInt();//enters the choice of the user

                switch (choice) {//switch case where the switch is the choice entered by users
                    case 1:
                         
                            System.out.print("Enter course ID: ");//print statement
                            String courseID = input.next();  //takes a String 
                            System.out.print("Enter course name: ");
                            String courseName = input.next(); 
                            System.out.print("Enter course description: ");
                            String description = input.next();  

                            System.out.print("Enter course credits: ");
                            int credits = input.nextInt();

                            System.out.print("Is the course available (true/false)? ");
                            boolean isAvailable = input.nextBoolean();

                            courses[courseCount] = new Course(courseID, courseName, description, credits, isAvailable);//sets the parameters of the courses to the values we entered
                            courseCount++;//increments the count by one
                            System.out.println("Course added successfully!");//print statement
                        break;//breaks

                    case 2:
                        
                            System.out.print("Enter student ID: ");//print statement
                            String studentID = input.next();
                            System.out.print("Enter student name: ");
                            String studentName = input.next();
                            students[studentCount] = new Student(studentID, studentName, new Course[10], studentCount);//sets the parameters of the students to the values we entered
                            studentCount++;//increments by one
                            System.out.println("Student added successfully!");
                         
                        break;//breaks

                    case 3:
                        System.out.print("Enter student ID: ");
                        studentID = input.next();  // Single word input
                        Student student = null; //initialize the student from type object as null which is zero but for strings
                        for (int i = 0; i < studentCount; i++) { //checks on every student in the array
                            if (students[i].getStudentID().equals(studentID)) {//if the student of the id matches the student ID entered
                                student = students[i]; //then add him to the index of the array found
                                break;//break
                            }
                        }
                        //here it does the same but with the course ID
                        System.out.print("Enter course ID: ");
                        courseID = input.next();
                        Course course = null; 
                        for(int i = 0; i < courseCount; i++) {
                            if (courses[i].getCourseID().equals(courseID)) {
                                course = courses[i];
                                break;
                            }
                        }

                        if (student != null && course != null) {//checks if both are not null
                            String result = student.addCourse(course);//adds the student to the course
                            System.out.println(result);//prints the return statement in the methods
                        } else {
                            System.out.println("Student or course not found.");
                        }
                        break;//breaks
                     
                    case 4:
                    	//same as previous method but different at the end where it uses the updateCourse method
                        System.out.print("Enter student ID: ");
                        studentID = input.next(); 
                        student = null;
                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].getStudentID().equals(studentID)) {
                                student = students[i];
                                break;
                            }
                        }

                        System.out.print("Enter old course ID: ");
                        String oldCourseID = input.next();  
                        System.out.print("Enter new course ID: ");
                        String newCourseID = input.next();  

                        Course newCourse = null;
                        for (int i = 0; i < courseCount; i++) {
                            if (courses[i].getCourseID().equals(newCourseID)) {
                                newCourse = courses[i];
                                break;
                            }
                        }

                        if (student != null && newCourse != null) {
                            String result = student.updateCourse(oldCourseID, newCourse);
                            System.out.println(result);
                        } else {
                            System.out.println("Student or course not found.");
                        }
                        break;

                    case 5:
                    	//also the same thing but removes student
                        System.out.print("Enter student ID: ");
                        studentID = input.next();  
                        student = null;
                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].getStudentID().equals(studentID)) {
                                student = students[i];
                                break;
                            }
                        }

                        System.out.print("Enter course ID: ");
                        courseID = input.next(); 
                        if (student != null) {
                            String result = student.removeCourse(courseID);
                            System.out.println(result);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 6:
                    	//does the same at first
                        System.out.print("Enter course ID: ");
                        courseID = input.next(); 
                        course = null;
                        for (int i = 0; i < courseCount; i++) {
                            if (courses[i].getCourseID().equals(courseID)) {
                                course = courses[i];
                                break;
                            }
                        }

                        if (course != null) {
                            System.out.println(course.toString());//here it prints the details using the toString method
                        } else {
                            System.out.println("Course not found.");
                        }
                        break;

                    case 7:
                        for (int i = 0; i < courseCount; i++) {//for loop goes over all courses
                            if (courses[i].getIsAvailable()) { //if the courses are available
                                System.out.println(courses[i]);//then print course
                            }
                        }
                        break;//break

                    case 8:
                        exit = true;//when chosen the boolean is set to true so it exits
                        System.out.println("Thank you for using the system. Goodbye!");//bye statment
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");//when a wrong input is entered
                
            
            }
        }

    }
}
