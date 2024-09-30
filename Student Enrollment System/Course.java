//Laith Amro
//1230018
//Dr. Abdallah Karakra
//Section 1
public class Course {                                //First Class which is the course class
    private String courseID;						// first we declare the variables
    private String courseName;
    private String description;
    private int credits;
    private boolean isAvailable;
    private String[] students = new String[10];    //this is the array that stores students I have set the array size to 10 since Dr. Abdallah didnt tell us the size
    private int studentCount;                 // here we declare the amount of students so we know where to stop when adding students

    public Course(String courseID, String courseName, String description, int credits, boolean isAvailable) { //we set an argument constructer
        this.courseID = courseID;      //the this is used so the program knows with wich variable to deal
        this.courseName = courseName;
        this.description = description;
        this.credits = credits;
        this.isAvailable = isAvailable;
    }


	public String getDescription() {              // here we put setters and getter, where the getters return the value of the variable and the setters makes it mutable
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String[] getStudents() {
		return students;
	}

	public void setStudents(String[] students) {
		this.students = students;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }
    public int getStudentCount() {
		return studentCount;
	}

	
    public String addStudent(String studentName) { //add students method to add students
        if (studentCount < students.length) {      // we chech if the number of students enrolled is less than the array length so we dont go beyond the index if yes we continue if not we dont
            students[studentCount++] = studentName; //here we use the increment the student count when added and save the name in the index chosen by the count
            return "Student added successfully!";  //print statement
        }
        return "Course is full!";                  // print statement
    }

    public String removeStudent(String studentName) { //method removeStudent to remove a student that is already enrolled
        for (int i = 0; i < studentCount; i++) {      //for loop to check upon all the elements of the array
            if (students[i].equals(studentName)) {    //for each element it checks whether the array index matches the student name 
                students[i] = students[studentCount--]; //if yes the student count get decremeneted         
                return "Student removed successfully!"; //print statement
            }
        }
        return "Student not found in this course.";    //print statement
    }

    
    public String toString() {                        //toString function is used to print the descrebtion of the object
        return "Course ID: " + courseID + ", Name: " + courseName + ", Credits: " + credits + ", Available: " + isAvailable + "\nStudents enrolled:";
         //in the line above the the values of are printed in an organized way for the user
            
    }
}
