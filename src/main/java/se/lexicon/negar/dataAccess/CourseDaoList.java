package se.lexicon.negar.dataAccess;


import se.lexicon.negar.businessLogic.*;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;


//a class to implement CourseDao interface
public class CourseDaoList implements CourseDao {
    private static List<Course> courses;

    public CourseDaoList() {
        courses = new ArrayList<Course>();
    }

    public Course saveCourse(Course course) {
        courses.add(course);
        return course;
    }

    public Course findById(int id) {
        for (int i = 0; i < courses.size(); i++)
            if (courses.get(i).getId() == id)
                return courses.get(i);
        return null;
    }

    public List<Course> findByName(String name) {
        List<Course> result = new ArrayList<Course>();
        for (int i = 0; i < courses.size(); i++)
            if (courses.get(i).getCourseName().equals(name))
                result.add(courses.get(i));
        return result;
    }

    public List<Course> findByDate(LocalDate date) {
        List<Course> result = new ArrayList<Course>();
        for (int i = 0; i < courses.size(); i++)
            if (courses.get(i).getStartDate().equals(date))
                result.add(courses.get(i));
        return result;
    }

    public List<Course> findAll() {
        return courses;
    }

    public boolean removeCourse(Course course) {
        List<Student> students = course.getStudents();
        for (int i = 0; i < students.size(); i++)
            course.unregister(students.get(i));
        return courses.remove(course);
    }
}

