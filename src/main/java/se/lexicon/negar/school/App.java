package se.lexicon.negar.school;




import se.lexicon.negar.businessLogic.*;
import se.lexicon.negar.dataAccess.*;

import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;

//a class to use School class
public class App
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int input;
        int id;
        int year;
        int month;
        int day;
        int weeks;
        String name;
        String email;
        String address;
        Student student;
        Course course;
        StudentDaoList students = new StudentDaoList();
        CourseDaoList courses = new CourseDaoList();
        List<Course> course_result;
        List<Student> student_result;
        while (true) //a loop to show the menu everytime
        {
            //showing the menu
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Enter one of these:");
            System.out.println("     1 for create a new student");
            System.out.println("     2 for creating a new course");
            System.out.println("     3 for registering a course for a student");
            System.out.println("     4 for unregistering a course for a student");
            System.out.println("     5 for finding specific students");
            System.out.println("     6 for finding specific courses");
            System.out.println("     7 for editing a specific student");
            System.out.println("     8 for editing a specific course");
            System.out.println("     9 for showing a specific student");
            System.out.println("     10 for showing a specific course");
            System.out.println("     11 for removing a specific student");
            System.out.println("     12 for removing a specific course");
            System.out.println("     13 for exiting the program");
            System.out.print(">>> ");
            input = Integer.parseInt(s.nextLine()); //getting the selected item
            if (input == 1) //create a new student
            {
                System.out.println("Enter the student ID:");
                System.out.print(">>> ");
                id = Integer.parseInt(s.nextLine());
                System.out.println("Enter the student name:");
                System.out.print(">>> ");
                name = s.nextLine();
                System.out.println("Enter the student email:");
                System.out.print(">>> ");
                email = s.nextLine();
                System.out.println("Enter the student address:");
                System.out.print(">>> ");
                address = s.nextLine();
                student = students.findById(id);
                if (student == null)
                {
                    student = new Student(id, name, email, address);
                    students.saveStudent(student);
                    System.out.println("OK!");
                }
                else
                {
                    System.out.println("ID is not valid!");
                }
            }
            else if (input == 2) //create a new course
            {
                System.out.println("Enter the course ID:");
                System.out.print(">>> ");
                id = Integer.parseInt(s.nextLine());
                System.out.println("Enter the course name:");
                System.out.print(">>> ");
                name = s.nextLine();
                System.out.println("Enter the course starting year:");
                System.out.print(">>> ");
                year = Integer.parseInt(s.nextLine());
                System.out.println("Enter the course starting month:");
                System.out.print(">>> ");
                month = Integer.parseInt(s.nextLine());
                System.out.println("Enter the course starting day:");
                System.out.print(">>> ");
                day = Integer.parseInt(s.nextLine());
                System.out.println("Enter the course duration in weeks:");
                System.out.print(">>> ");
                weeks = Integer.parseInt(s.nextLine());
                course = courses.findById(id);
                if (course == null)
                {
                    course = new Course(id, name, LocalDate.of(year, month, day), weeks);
                    courses.saveCourse(course);
                    System.out.println("OK!");
                }
                else
                {
                    System.out.println("ID is not valid!");
                }
            }
            else if (input == 3) //register
            {
                System.out.println("Enter the course ID:");
                System.out.print(">>> ");
                id = Integer.parseInt(s.nextLine());
                course = courses.findById(id);
                System.out.println("Enter the student ID:");
                System.out.print(">>> ");
                id = Integer.parseInt(s.nextLine());
                student = students.findById(id);
                if (student != null && course != null)
                {
                    course.register(student);
                    System.out.println("OK!");
                }
                else
                {
                    System.out.println("IDs are not valid!");
                }
            }
            else if (input == 4) //unregister
            {
                System.out.println("Enter the course id:");
                System.out.print(">>> ");
                id = Integer.parseInt(s.nextLine());
                course = courses.findById(id);
                System.out.println("Enter the student id:");
                System.out.print(">>> ");
                id = Integer.parseInt(s.nextLine());
                student = students.findById(id);
                if (student != null && course != null)
                {
                    course.unregister(student);
                    System.out.println("OK!");
                }
                else
                {
                    System.out.println("IDs are not valid!");
                }
            }
            else if (input == 5) //finding students
            {
                System.out.println("Enter 1 for finding by ID, 2 for finding by name, and 3 for finding by email:");
                System.out.print(">>> ");
                input = Integer.parseInt(s.nextLine());
                if (input == 1) //ID
                {
                    System.out.println("Enter the ID:");
                    System.out.print(">>> ");
                    id = Integer.parseInt(s.nextLine());
                    student = students.findById(id);
                    if (student == null)
                        System.out.println("Not found!");
                    else
                        student.show();
                }
                else if (input == 2) //name
                {
                    System.out.println("Enter the name:");
                    System.out.print(">>> ");
                    name = s.nextLine();
                    student_result = students.findByName(name);

                    if (student_result.size() == 0)
                        System.out.println("Not found!");
                    else
                        for (int i = 0; i < student_result.size(); i++)
                            student_result.get(i).show();
                }
                else if (input == 3) //email
                {
                    System.out.println("Enter the email:");
                    System.out.print(">>> ");
                    email = s.nextLine();
                    student = students.findByEmail(email);
                    if (student == null)
                        System.out.println("Not found!");
                    else
                        student.show();
                }
                else
                    System.out.println("Invalid option!");
            }
            else if (input == 6) //finding courses
            {
                System.out.println("Enter 1 for finding by ID, 2 for finding by name, and 3 for finding by date:");
                System.out.print(">>> ");
                input = Integer.parseInt(s.nextLine());
                if (input == 1) //ID
                {
                    System.out.println("Enter the ID:");
                    System.out.print(">>> ");
                    id = Integer.parseInt(s.nextLine());
                    course = courses.findById(id);
                    if (course == null)
                        System.out.println("Not found!");
                    else
                        course.show();
                }
                else if (input == 2) //name
                {
                    System.out.println("Enter the name:");
                    System.out.print(">>> ");
                    name = s.nextLine();
                    course_result = courses.findByName(name);
                    if (course_result.size() == 0)
                        System.out.println("Not found!");
                    else
                        for (int i = 0; i < course_result.size(); i++)
                            course_result.get(i).show();
                }
                else if (input == 3) //date
                {
                    System.out.println("Enter the year:");
                    System.out.print(">>> ");
                    year = Integer.parseInt(s.nextLine());
                    System.out.println("Enter the month:");
                    System.out.print(">>> ");
                    month = Integer.parseInt(s.nextLine());
                    System.out.println("Enter the day:");
                    System.out.print(">>> ");
                    day = Integer.parseInt(s.nextLine());
                    course_result = courses.findByDate(LocalDate.of(year, month, day));
                    if (course_result.size() == 0)
                        System.out.println("Not found!");
                    else
                        for (int i = 0; i < course_result.size(); i++)
                            course_result.get(i).show();
                }
                else
                    System.out.println("Invalid option!");
            }
            else if (input == 7) //editing students
            {
                System.out.println("Enter the student ID:");
                System.out.print(">>> ");
                id = Integer.parseInt(s.nextLine());
                student = students.findById(id);
                System.out.println("Enter 1 for name, 2 for email, and 3 for address:");
                System.out.print(">>> ");
                input = Integer.parseInt(s.nextLine());
                if (student == null)
                {
                    System.out.println("Not found!");
                }
                else if (input == 1) //name
                {
                    System.out.println("Enter the new name:");
                    System.out.print(">>> ");
                    name = s.nextLine();
                    student.setName(name);
                    System.out.println("OK!");
                }
                else if (input == 2) //email
                {
                    System.out.println("Enter the new email:");
                    System.out.print(">>> ");
                    email = s.nextLine();
                    student.setEmail(email);
                    System.out.println("OK!");
                }
                else if (input == 3) //address
                {
                    System.out.println("Enter the new address:");
                    System.out.print(">>> ");
                    address = s.nextLine();
                    student.setAddress(address);
                    System.out.println("OK!");
                }
                else
                    System.out.println("Invalid option!");
            }
            else if (input == 8) //editing courses
            {
                System.out.println("Enter the course ID:");
                System.out.print(">>> ");
                id = Integer.parseInt(s.nextLine());
                course = courses.findById(id);
                System.out.println("Enter 1 for name, 2 for date, and 3 for weeks:");
                System.out.print(">>> ");
                input = Integer.parseInt(s.nextLine());
                if (course == null)
                {
                    System.out.println("Not found!");
                }
                else if (input == 1) //name
                {
                    System.out.println("Enter the new name:");
                    System.out.print(">>> ");
                    name = s.nextLine();
                    course.setCourseName(name);
                    System.out.println("OK!");
                }
                else if (input == 2) //date
                {
                    System.out.println("Enter the new year:");
                    System.out.print(">>> ");
                    year = Integer.parseInt(s.nextLine());
                    System.out.println("Enter the new month:");
                    System.out.print(">>> ");
                    month = Integer.parseInt(s.nextLine());
                    System.out.println("Enter the new day:");
                    System.out.print(">>> ");
                    day = Integer.parseInt(s.nextLine());
                    course.setStartDate(LocalDate.of(year, month, day));
                    System.out.println("OK!");
                }
                else if (input == 3) //weeks
                {
                    System.out.println("Enter the new weeks:");
                    System.out.print(">>> ");
                    weeks = Integer.parseInt(s.nextLine());
                    course.setWeekDuration(weeks);
                    System.out.println("OK!");
                }
                else
                    System.out.println("Invalid option!");
            }
            else if (input == 9) //show students
            {
                System.out.println("Enter the student ID:");
                System.out.print(">>> ");
                id = Integer.parseInt(s.nextLine());
                student = students.findById(id);
                if (student == null)
                    System.out.println("Not found!");
                else
                    student.show();
            }
            else if (input == 10) //show courses
            {
                System.out.println("Enter the course ID:");
                System.out.print(">>> ");
                id = Integer.parseInt(s.nextLine());
                course = courses.findById(id);
                if (course == null)
                    System.out.println("Not found!");
                else
                    course.show();
            }
            else if (input == 11) //remove students
            {
                System.out.println("Enter the student ID:");
                System.out.print(">>> ");
                id = Integer.parseInt(s.nextLine());
                student = students.findById(id);
                if (student == null)
                    System.out.println("Not found!");
                else
                {
                    students.deleteStudent(student);
                    System.out.println("OK!");
                }
            }
            else if (input == 12) //remove courses
            {
                System.out.println("Enter the course ID:");
                System.out.print(">>> ");
                id = Integer.parseInt(s.nextLine());
                course = courses.findById(id);
                if (course == null)
                    System.out.println("Not found!");
                else
                {
                    courses.removeCourse(course);
                    System.out.println("OK!");
                }
            }
            else if (input == 13) //exit
                break;
            else //invalid command
                System.out.println("Invalid option!");
        }
    }
}
