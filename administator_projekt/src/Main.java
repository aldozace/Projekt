//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int year;
    private String id;
    private ArrayList<String> courses;
    private double balance;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.id = generateUniqueId();
        this.courses = new ArrayList<>();
        this.balance = 0;
    }

    private String generateUniqueId() {
        int gradeLevel = year * 10;
        int randomNumber = (int)(Math.random() * 9000) + 1000;
        return Integer.toString(gradeLevel) + Integer.toString(randomNumber);
    }

    public void enrollCourse(String course) {
        courses.add(course);
        balance += 600;
    }

    public double viewBalance() {
        return balance;
    }

    public void payTuition(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Payment successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Courses Enrolled: " + courses);
        System.out.println("Balance: $" + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many new students will be added to the database? ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            Student student = new Student(name, year);
            System.out.println("Available courses: History 101, Mathematics 101, English 101, Chemistry 101, Computer Science 101");
            System.out.print("How many courses will the student enroll in? ");
            int numCourses = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < numCourses; j++) {
                System.out.print("Enter course name: ");
                String course = scanner.nextLine();
                student.enrollCourse(course);
            }

            students.add(student);
        }

        for (Student student : students) {
            System.out.println("\nStudent Information:");
            student.displayInfo();

            System.out.print("\nDo you want to pay tuition? (yes/no) ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("yes")) {
                System.out.print("Enter the amount to pay: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                student.payTuition(amount);
                System.out.println("Updated balance: $" + student.viewBalance());
            }
        }

        scanner.close();
    }
}
