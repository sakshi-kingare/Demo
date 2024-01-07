package Demo;

import java.util.Scanner;

 class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int numberOfSubjects = scanner.nextInt();

        // Validate that the number of subjects is positive
        if (numberOfSubjects <= 0) {
            System.out.println("Invalid number of subjects. Please enter a positive number.");
            return;
        }

        // Initialize variables
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.println("Enter marks (out of 100) for Subject " + i + ": ");
            int marks = scanner.nextInt();

            // Validate that marks are within the valid range (0 to 100)
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Please enter marks within the range of 0 to 100.");
                return;
            }

            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Grade calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}