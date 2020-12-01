package se.lexicon.negar.dataAccess;


import java.util.List;
import java.time.LocalDate;

import se.lexicon.negar.businessLogic.Course;


//an interface for the data access part of courses
public interface CourseDao {
    public Course saveCourse(Course course);

    public Course findById(int id);

    public List<Course> findByName(String name);

    public List<Course> findByDate(LocalDate date);

    public List<Course> findAll();

    public boolean removeCourse(Course course);
}

