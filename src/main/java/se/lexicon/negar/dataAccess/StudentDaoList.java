package se.lexicon.negar.dataAccess;

import java.util.List;
import java.util.ArrayList;

import se.lexicon.negar.businessLogic.*;


//a class to implement StudentDao interface
public class StudentDaoList implements StudentDao {
    private static List<Student> students;

    public StudentDaoList() {
        students = new ArrayList<Student>();
    }

    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student findByEmail(String email) {
        for (int i = 0; i < students.size(); i++)
            if (students.get(i).getEmail().equals(email))
                return students.get(i);
        return null;
    }

    public List<Student> findByName(String name) {
        List<Student> result = new ArrayList<Student>();
        for (int i = 0; i < students.size(); i++)
            if (students.get(i).getName().equals(name))
                result.add(students.get(i));
        return result;
    }

    public Student findById(int id) {
        for (int i = 0; i < students.size(); i++)
            if (students.get(i).getId() == id)
                return students.get(i);
        return null;
    }

    public List<Student> findAll() {
        return students;
    }

    public boolean deleteStudent(Student student) {
        List<Course> courses = student.getCourses();
        for (int i = 0; i < courses.size(); i++)
            courses.get(i).unregister(student);
        return students.remove(student);
    }
}

