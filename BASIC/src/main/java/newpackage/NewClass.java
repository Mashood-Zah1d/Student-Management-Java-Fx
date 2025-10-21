
package newpackage;
    import java.util.*;
class Person {
    private String name;
    private int id;
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
class Student extends Person {
    private double gpa;
    private double fees;
    private static ArrayList<Student> studentList = new ArrayList<>();
    public Student(String name, int id) {
        super(name, id);
    }
    public double getGPA() {
        return gpa;
    }
    public void setGPA(double gpa) {
        this.gpa = gpa;
    }
    public double getFees() {
        return fees;
    }
    public void setFees(double fees) {
        this.fees = fees;
    }
    public static Student findStudent(String name) {
        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }
    public static void calculateGPA() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the student: ");
        String name = sc.nextLine();
        Student student = findStudent(name);
        if (student != null) {
            System.out.print("Enter the number of subjects: ");
            int numSubjects = sc.nextInt();
            System.out.print("Enter total marks obtained: ");
            int totalMarks = sc.nextInt();

            // Calculate percentage
            double percentage = (totalMarks / (double) (100 * numSubjects)) * 100.0;

            student.setGPA(percentage);
            System.out.println("Percentage set for student " + student.getName() + ": " + student.getGPA() + "%");
        } else {
            System.out.println("Student not found.");
        }
    }
    public static void calculateFees() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the student: ");
        String name = sc.nextLine();
        Student student = findStudent(name);
        if (student != null) {
            System.out.print("Enter the number of subjects: ");
            int numSubjects = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter fees per subject: ");
            double feesPerSubject = sc.nextDouble();
            sc.nextLine();
            student.setFees(numSubjects * feesPerSubject);
            System.out.println("Fees set for student " + student.getName() + ": " + student.getFees());
        } else {
            System.out.println("Student not found.");
        }
    }
    public static void add() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Student student = new Student(name, id);
        studentList.add(student);
        System.out.println("Student " + student.getName() + " added with ID: " + student.getId());
    }

    public static void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student ID to remove: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                System.out.println("Student with ID " + id + " removed.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
    public static void display() {
        System.out.println("Student List:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("Name: " + studentList.get(i).getName() + ", ID: " + studentList.get(i).getId() + ", GPA: " + studentList.get(i).getGPA() + ", Fees: " + studentList.get(i).getFees());
        }
    }
}
class Teacher extends Person {
    private double salary;
    private static ArrayList<Teacher> teacherList = new ArrayList<>();
    public Teacher(String name, int id) {
        super(name, id);
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public static Teacher findTeacher(String name) {
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getName().equals(name)) {
                return teacherList.get(i);
            }
        }
        return null;
    }
    public static void calculateSalary() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the teacher: ");
        String name = sc.nextLine();
        Teacher teacher = findTeacher(name);
        if (teacher != null) {
            System.out.print("Enter base salary: ");
            double baseSalary = sc.nextDouble();
            System.out.print("Enter bonus: ");
            double bonus = sc.nextDouble();
            System.out.print("Enter allowance: ");
            double allowance = sc.nextDouble();
            System.out.print("Enter deductions: ");
            double deductions = sc.nextDouble();
            double totalSalary = baseSalary + bonus + allowance - deductions;
            teacher.setSalary(totalSalary);
            System.out.println("Salary set for teacher " + teacher.getName() + ": " + teacher.getSalary());
        } else {
            System.out.println("Teacher not found.");
        }
    }
    public static void add() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter teacher name: ");
        String name = sc.nextLine();
        System.out.print("Enter teacher ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter base salary: ");
        double baseSalary = sc.nextDouble();
        Teacher teacher = new Teacher(name, id);
        teacher.setSalary(baseSalary);
        teacherList.add(teacher);
        System.out.println("Teacher " + teacher.getName() + " added with ID: " + teacher.getId() + ", Salary: " + teacher.getSalary());
    }
    public static void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter teacher ID to remove: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId() == id) {
                teacherList.remove(i);
                System.out.println("Teacher with ID " + id + " removed.");
                return;
            }
        }
        System.out.println("Teacher with ID " + id + " not found.");
    }

    public static void display() {
        System.out.println("Teacher List:");
        for (int i = 0; i < teacherList.size(); i++) {
            System.out.println("Name: " + teacherList.get(i).getName() + ", ID: " + teacherList.get(i).getId() + ", Salary: " + teacherList.get(i).getSalary());
        }
    }
}

public class NewClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------- School Management System -----------");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Calculate Student GPA");
            System.out.println("4. Calculate Student Fees");
            System.out.println("5. Add Teacher");
            System.out.println("6. Remove Teacher");
            System.out.println("7. Calculate Teacher Salary");
            System.out.println("8. Display Student List");
            System.out.println("9. Display Teacher List");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Student.add();
                    break;
                case 2:
                    Student.remove();
                    break;
                case 3:
                    Student.calculateGPA();
                    break;
                case 4:
                    Student.calculateFees();
                    break;
                case 5:
                    Teacher.add();
                    break;
                case 6:
                    Teacher.remove();
                    break;
                case 7:
                    Teacher.calculateSalary();
                    break;
                case 8:
                    Student.display();
                    break;
                case 9:
                    Teacher.display();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

