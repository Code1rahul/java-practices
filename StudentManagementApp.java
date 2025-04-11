import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementApp {

    // Student class to represent a student
    static class Student {
        private String name;
        private String standerd;
        private int age;
        private int roll_NO;
        // private String name;

        // Constructor
        public Student(String name, int age, String standerd, int roll_NO) {
            this.name = name;
            this.age = age;
            this.standerd = standerd;
            this.roll_NO = roll_NO;
        }

        // Getters
        public String getName() {
            return name;
        }
        
        public String getStanderd() {
            return standerd;
        }

        public int getAge() {
            return age;
        }
        
        public int getRoll_NO() {
            return roll_NO;
        }
        
        

        // Setters
        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }
        
        public void setStanderd(String standerd) {
            this.standerd = standerd;
        }

        public void setRoll_NO(int roll_NO) {
            this.roll_NO = roll_NO;
        }

        @Override
        public String toString() {
            return "Name: " + name + ",Standerd "+ standerd + ",Roll NO "+ roll_NO  + ", Age: " + age;
        }
    }

    // StudentManager class to manage student operations
    static class StudentManager {
        private List<Student> students;

        public StudentManager() {
            students = new ArrayList<>();
        }

        public void addStudent(String name, int age, String standerd, int roll_NO) {
            Student student = new Student(name, age, standerd, roll_NO);
            students.add(student);
            System.out.println("Student added: " + student);
        }

        public void viewStudents() {
            if (students.isEmpty()) {
                System.out.println("No students found.");
            } else {
                System.out.println("Student List:");
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        }

        public void deleteStudent(String name) {
            boolean removed = students.removeIf(student -> student.getName().equalsIgnoreCase(name));
            if (removed) {
                System.out.println("Student with name " + name + " has been removed.");
            } else {
                System.out.println("Student with name " + name + " not found.");
            }
        }

        public void updateStudent(String name) {
            for (Student student : students) {
                if (student.getName().equalsIgnoreCase(name)) {
                    
                    Scanner scanner = new Scanner(System.in);
                    //new name
                    System.out.print("Enter new name (leave blank to keep current): ");
                    String newName = scanner.nextLine();
                    //new age
                    System.out.print("Enter new age (leave blank to keep current): ");
                    String ageInput = scanner.nextLine();
                    
                     //new standerd
                    System.out.print("Enter new standerd (leave blank to keep current): ");
                    String newStanderd = scanner.nextLine();
                    //new roll_NO
                    System.out.print("Enter new age (leave blank to keep current): ");
                    String roll_NOInput = scanner.nextLine();
                    
                    //varifyin new age
                    Integer newAge = ageInput.isEmpty() ? null : Integer.parseInt(ageInput);
                     //varifyin new roll_NO
                    Integer newRoll_NO = roll_NOInput.isEmpty() ? null : Integer.parseInt(roll_NOInput);
                    

                    // Update name if newName is provided
                    if (!newName.isEmpty()) {
                        student.setName(newName);
                        System.out.println("Updated name to " + newName);
                    }
                    // Update age if newAge is provided
                    if (newAge != null) {
                        student.setAge(newAge);
                        System.out.println("Updated age to " + newAge);
                    }
                    
                    // Update name if newStanderd is provided
                    if (!newStanderd.isEmpty()) {
                        student.setStanderd(newStanderd);
                        System.out.println("Updated standerd to " + newStanderd);
                    }
                    // Update age if newRoll_NO is provided
                    if (newRoll_NO != null) {
                        student.setRoll_NO(newRoll_NO);
                        System.out.println("Updated roll_NO to " + newRoll_NO);
                    }

                    return; // Exit the method after updating
                }
            }
            System.out.println("Student with name " + name + " not found.");
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student standerd: ");
                    String standerd = scanner.nextLine();
                    
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter student Roll NO: ");
                    int roll_NO = scanner.nextInt();
                    studentManager.addStudent(name, age, standerd, roll_NO);
                    break;
                case 2:
                    studentManager.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter student name to delete: ");
                    String nameToDelete = scanner.nextLine();
                    studentManager.deleteStudent(nameToDelete);
                    break;
                case 4:
                    System.out.print("Enter student name to update: ");
                    String nameToUpdate = scanner.nextLine();
                    studentManager.updateStudent(nameToUpdate);
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
