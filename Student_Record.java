import java.util.ArrayList; 
import java.util.Scanner;   

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks);
    }
}

public class Student_Record {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        
        System.out.println("Welcome to Student Management System!!");
        
        do {
            System.out.println("\n---MENU---");
            System.out.println("1. Add Students");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Id");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your Choice: ");
            choice = sc.nextInt();
            
            switch(choice) {
                case 1: 
                    System.out.print("Enter Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    
                    list.add(new Student(id, name, marks));
                    System.out.println("Student added successfully!");
                    break;
                    
                case 2:
                    if(list.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        System.out.println("\n---Student List---");
                        for(Student s : list) s.display();
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    for(Student s : list) {
                        if(s.id == searchId) {
                            s.display();
                            found = true;
                            break;
                        }
                    }
                    if(!found) System.out.println("ID not found.");
                    break;
                
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean removed = false;
                    for(int i = 0; i < list.size(); i++) {
                        if (list.get(i).id == deleteId) {
                            list.remove(i);
                            removed = true;
                            break;
                        }
                    }
                    if(removed) {
                        System.out.println("Student with ID " + deleteId + " Deleted Successfully");
                    } else {
                        System.out.println("Error: Student ID not found.");    
                    }
                    break;
                    
                case 5:
                    System.out.println("Thank you!!");
                    break;
                    
                default:
                    System.out.println("Invalid choice!!");
            }
        } while(choice != 5);
        sc.close();
    }
}
