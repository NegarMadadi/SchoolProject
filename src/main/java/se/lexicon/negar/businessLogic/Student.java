package se.lexicon.negar.businessLogic;

import java.util.List;
import java.util.ArrayList;

//a class to store the information of the students
public class Student {
    private int id;
    private String name;
    private String email;
    private String address;
    private List<Course> courses;

    public Student(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        courses = new ArrayList<Course>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void register(Course course) {
        if (course == null)
            return;
        courses.remove(course);
        courses.add(course);
    }

    public void unregister(Course course) {
        if (course == null)
            return;
        courses.remove(course);
    }

    public void info() {
        String output = "This student id is " + Integer.toString(id) + " and his/her name is " + name + ".";
        output += " His/Her email is " + email + " and his/her address is " + address + ".";
        System.out.println(output);
    }

    public void show() {
        info();
        if (courses.size() == 0)
            System.out.println("This student is not registered for any courses.");
        else {
            System.out.println("The courses registered for this student are as follows:");
            for (int i = 0; i < courses.size(); i++) {
                System.out.print("   **");
                courses.get(i).info();
            }
        }
    }
}

