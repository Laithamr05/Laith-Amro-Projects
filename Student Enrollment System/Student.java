//Laith Amro
//1230018
//Dr. Abdallah Karakra
//Section 1
public class Student { //2nd class Student class
    private String studentID; //we declare the variables like the previous class
    private String studentName;
    private Course[] courses = new Course[10]; // the difference here we use an array of object here to store the objects of the class
    private int courseCount; // same as the previous class

    public Student(String studentID, String studentName, Course[] courses, int courseCount) {// same as the previous class
        this.studentID = studentID;
        this.studentName = studentName;
        this.courses = new Course[100];
        this.courseCount = courseCount;
    }
    public String getStudentName() { //setter and getter same as the previous class
  		return studentName;
  	}

  	public void setStudentName(String studentName) {
  		this.studentName = studentName;
  	}

  	public Course[] getCourses() {
  		return courses;
  	}

  	public void setCourses(Course[] courses) {
  		this.courses = courses;
  	}

  	public int getCourseCount() {
  		return courseCount;
  	}

  	public void setStudentID(String studentID) {
  		this.studentID = studentID;
  	}
    public String getStudentID() {
        return studentID;
    }

    public String addCourse(Course course) {  //addCourse method to add courses 
        if (courseCount < courses.length) {   //here as the previous class we check to see if it exceeds the length or not
            for (int i = 0; i < courseCount; i++) {  //if it does not exceed the limit we create a forloop to pass on every element
                if (courses[i].getCourseID().equals(course.getCourseID())) {// this if statement checks if one of the already added courses id matches the course added ID 
                    return "Already enrolled in this course.";// if it does match then we print that we cant add the course
                }
            }
            courses[courseCount++] = course; //if it doesnt then the course counter gets incremeneted and the index gets occupied by the course entered
            return "course added successfully"; //print statement
        }
        return "Cannot enroll in more courses.";//print statement
    }

    public String updateCourse(String oldCourseID, Course newCourse) { //updateCourse method to update or change the course info
        if (newCourse.getStudents().length <= newCourse.getStudentCount()) { //here it checks if the length of the array of the students is less than the number of students
            return "Cannot update course; the new course is full.";//print statement
        }

        for (int i = 0; i < courseCount; i++) {//if it isnt less than it goes into a forloop for every course in the array
            if (courses[i].getCourseID().equals(oldCourseID)) {// here it checks every course if the old ID equals the new one 
                String result = courses[i].removeStudent(studentName);//here it removes the student from the old course
                courses[i] = newCourse;//and sets the index of the old one for the new one
                return result + " and " + newCourse.addStudent(studentName);// and then add the student to the new course
            
        }
            }
        return "Not enrolled in the course.";//print statement
    }

    

	public String removeCourse(String courseID) {//removeCourse method removes the course
        for (int i = 0; i < courseCount; i++) {// for loop goes over each element of the array
            if (courses[i].getCourseID().equals(courseID)) {//checks if the id of the course in the array equals the ID entered
                String result = courses[i].removeStudent(studentName);//removes the student from the course
                courses[i] = courses[courseCount--];//decrements the counter of the array
                return result;// return what course was removed
            }
        }
        return "Not enrolled in the course.";//print statement
    }
}
