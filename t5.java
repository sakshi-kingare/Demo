package Demo;

import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean hasAvailableSlots() {
        return enrolledStudents < capacity;
    }

    public void enrollStudent() {
        if (hasAvailableSlots()) {
            enrolledStudents++;
        }
    }

    public void removeStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        }
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + "\nTitle: " + title + "\nDescription: " + description +
                "\nCapacity: " + capacity + "\nSchedule: " + schedule + "\nEnrolled Students: " + enrolledStudents;
    }
}

class Student {
    private int studentID;
    private String name;
    private ArrayList<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course != null && course.hasAvailableSlots() && !registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.enrollStudent();
        }
    }

    public void dropCourse(Course course) {
        if (course != null && registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.removeStudent();
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name + "\nRegistered Courses: " + registeredCourses.size();
    }
}

class CourseRegistrationSystem {
    public static void main(String[] args) {
        // Create courses
        Course course1 = new Course("CS101", "Introduction to Computer Science", "Basic concepts of programming", 30, "MWF 10:00 AM - 11:30 AM");
        Course course2 = new Course("ENG201", "English Literature", "Classical literature analysis", 25, "TTH 1:00 PM - 2:30 PM");
        Course course3 = new Course("MATH301", "Calculus", "Advanced calculus topics", 20, "MWF 2:00 PM - 3:30 PM");

        // Create students
        Student student1 = new Student(1001, "John Doe");
        Student student2 = new Student(1002, "Jane Smith");

        // Display course listings
        displayCourseListing(course1);
        displayCourseListing(course2);
        displayCourseListing(course3);

        // Student registration
        student1.registerCourse(course1);
        student1.registerCourse(course2);

        student2.registerCourse(course2);
        student2.registerCourse(course3);

        // Display student information
        displayStudentInfo(student1);
        displayStudentInfo(student2);

        // Drop a course
        student1.dropCourse(course1);

        // Display updated student information
        displayStudentInfo(student1);
        displayStudentInfo(student2);
    }

    private static void displayCourseListing(Course course) {
        System.out.println("\nCourse Listing:");
        System.out.println(course);
        System.out.println("------------------------------");
    }

    private static void displayStudentInfo(Student student) {
        System.out.println("\nStudent Information:");
        System.out.println(student);
        System.out.println("------------------------------");
    }
}
