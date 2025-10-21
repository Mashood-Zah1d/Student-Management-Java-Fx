package basic;
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
    private double percentage;
    private double fees;
    private static ArrayList<Student> studentList = new ArrayList<>();

    public Student(String name, int id) {
        super(name, id);
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public static Student findStudent(String name) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equals(name)) {
                return studentList.get(i);
            }
        }
        return null;
    }

    public static boolean calculateGPA(String name, int totalMarks, int numSubjects) {
        Student student = findStudent(name);
        if (student != null) {
            double percentage = (totalMarks / (double) (100 * numSubjects)) * 100.0;
            student.setPercentage(percentage);
            System.out.println("Percentage set for student " + student.getName() + ": " + student.getPercentage() + "%");
            return true; 
        } else {
            System.out.println("Student not found.");
            return false;
        }
    }

    public static boolean calculateFees(String name, int numSubjects, int pricePerSubject) {
        Student s1 = findStudent(name);
        if (s1 != null) {
            double fees = numSubjects * pricePerSubject;
            s1.setFees(fees);
            System.out.println("Fees set for student " + s1.getName() + ": " + s1.getFees());
            return true; 
        } else {
            System.out.println("Student not found.");
            return false;
        }
    }

    public static void add(String name, int id) {
        Student s1 = new Student(name, id);
        studentList.add(s1);
        System.out.println("Student " + s1.getName() + " added with ID: " + s1.getId());
    }
    public static boolean remove(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                System.out.println("Student with ID " + id + " removed.");
                return true;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return false;
    }
    public static String[] display() {
        String[] studentArray = new String[studentList.size()];
        for (int i = 0; i < studentList.size(); i++) {
            studentArray[i] = "Name: " + studentList.get(i).getName() +
                              ", ID: " + studentList.get(i).getId() +
                              ", GPA: " + studentList.get(i).getPercentage() +
                              ", Fees: " + studentList.get(i).getFees();
        }
        return studentArray;
    }}

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

    public static boolean calculateSalary(String name, double baseSalary, double bonus, double allowance, double deductions) {
        Teacher t1 = findTeacher(name);
        if (t1 != null) {
            double totalSalary = baseSalary + bonus + allowance - deductions;
            t1.setSalary(totalSalary);
            System.out.println("Salary set for teacher " + t1.getName() + ": " + t1.getSalary());
            return true;
        } else {
            System.out.println("Teacher not found.");
            return false;
        }
    }

    public static void add(String name, int id) {
        Teacher teacher = new Teacher(name, id);
        teacherList.add(teacher);
        System.out.println("Teacher " + teacher.getName() + " added with ID: " + teacher.getId() + ", Salary: " + teacher.getSalary());
    }

    public static boolean remove(int id) {
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId() == id) {
                teacherList.remove(i);
                System.out.println("Teacher with ID " + id + " removed.");
                return true;
            }
        }
        System.out.println("Teacher with ID " + id + " not found.");
        return false;
    }

    public static String[] displayTeacher() {
        String[] teacherArray = new String[teacherList.size()];
        for (int i = 0; i < teacherList.size(); i++) {
            teacherArray[i] = "Name: " + teacherList.get(i).getName() +
                    ", ID: " + teacherList.get(i).getId() +
                    ", Salary: " + teacherList.get(i).getSalary();
            System.out.println();
        }
        return teacherArray;
    }
}

public class Main {

    public static void main(String[] args) {

    }
}