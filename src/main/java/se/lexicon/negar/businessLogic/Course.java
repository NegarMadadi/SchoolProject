package se.lexicon.negar.businessLogic;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

//a class to store the information of courses
public class Course {
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        students = new ArrayList<Student>();
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void register(Student student) {
        if (student == null)
            return;
        students.remove(student);
        students.add(student);
        student.register(this);
    }

    public void unregister(Student student) {
        if (student == null)
            return;
        students.remove(student);
        student.unregister(this);
    }

    public void info() {
        String output = "This course id is " + Integer.toString(id) + " and its name is " + courseName + ".";
        output += " Its starting date is " + startDate.toString() + " and its duration is " + Integer.toString(weekDuration) + " weeks.";
        System.out.println(output);
    }

    public void show() {
        info();
        if (students.size() == 0)
            System.out.println("No one is registered for this course.");
        else {
            System.out.println("The students registered for this course are as follows:");
            for (int i = 0; i < students.size(); i++) {
                System.out.print("   **");
                students.get(i).info();
            }
        }
    }
}

