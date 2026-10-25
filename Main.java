import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Student {
        String name;
        double m1, m2, m3;

        Student(String name, double m1, double m2, double m3) {
            this.name = name;
            this.m1 = m1;
            this.m2 = m2;
            this.m3 = m3;
        }

        double average() {
            return (m1 + m2 + m3) / 3;
        }

        String result() {
            if (m1 >= 35 && m2 >= 35 && m3 >= 35) {
                return "PASS";
            }
            return "FAIL";
        }

        void display() {
            System.out.println("Name: " + name);
            System.out.println("Average: " + average());
            System.out.println("Result: " + result());
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Student Grade Tracker ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                System.out.print("Enter Subject 1 marks: ");
                double m1 = sc.nextDouble();

                System.out.print("Enter Subject 2 marks: ");
                double m2 = sc.nextDouble();

                System.out.print("Enter Subject 3 marks: ");
                double m3 = sc.nextDouble();
                sc.nextLine();

                if (m1 < 0 || m1 > 100 ||
                    m2 < 0 || m2 > 100 ||
                    m3 < 0 || m3 > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                    continue;
                }

                students.add(new Student(name, m1, m2, m3));
                System.out.println("Student added successfully!");

            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("No students found.");
                }

                for (Student s : students) {
                    s.display();
                }

            } else if (choice == 3) {
                System.out.println("Thank you!");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}