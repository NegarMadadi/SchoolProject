package se.lexicon.negar;

import org.junit.Test;
import se.lexicon.negar.businessLogic.*;
import se.lexicon.negar.dataAccess.*;

import java.time.LocalDate;
import static org.junit.Assert.*;
import java.util.List;

public class SchoolTest {
    public void initiate(StudentDaoList students, CourseDaoList courses) {
        Student s1 = new Student(111111, "jack", "jack@gmail.com", "street1");
        Student s2 = new Student(222222, "sue", "sue@gmai.com", "street2");
        Student s3 = new Student(333333, "bob", "bob@gmai.com", "street3");
        Student s4 = new Student(444444, "sarah", "sarah@gmai.com", "street4");
        Student s5 = new Student(555555, "john", "john@gmai.com", "street5");
        Student s6 = new Student(666666, "jack", "jackjack@gmai.com", "street6");
        Student s7 = new Student(777777, "jimmy", "jimmy@gmai.com", "street7");
        Course c1 = new Course(111, "networking", LocalDate.of(2020, 10, 25), 7);
        Course c2 = new Course(222, "databases", LocalDate.of(2020, 10, 20), 8);
        Course c3 = new Course(333, "networking", LocalDate.of(2020, 10, 20), 10);
        students.saveStudent(s1);
        students.saveStudent(s2);
        students.saveStudent(s3);
        students.saveStudent(s4);
        students.saveStudent(s5);
        students.saveStudent(s6);
        students.saveStudent(s7);
        courses.saveCourse(c1);
        courses.saveCourse(c2);
        courses.saveCourse(c3);
    }

    //a method to test whether register works
    @Test
    public void registerTest() {
        StudentDaoList students = new StudentDaoList();
        CourseDaoList courses = new CourseDaoList();
        initiate(students, courses);
        Student s1 = students.findById(111111);
        Student s2 = students.findById(222222);
        Course c = courses.findById(111);
        c.register(s1);
        c.register(s2);
        int registered = c.getStudents().size();
        assertEquals(2, registered);
        registered = s1.getCourses().size();
        assertEquals(1, registered);
    }

    //a method to test whether unregister works
    @Test
    public void unregisterTest() {
        StudentDaoList students = new StudentDaoList();
        CourseDaoList courses = new CourseDaoList();
        initiate(students, courses);
        Student s1 = students.findById(111111);
        Student s2 = students.findById(222222);
        Course c = courses.findById(111);
        c.register(s1);
        c.register(s2);
        c.unregister(s1);
        int registered = c.getStudents().size();
        assertEquals(1, registered);
        registered = s1.getCourses().size();
        assertEquals(0, registered);
    }

    //a method to test whether find by id works
    @Test
    public void findIdTest() {
        StudentDaoList students = new StudentDaoList();
        CourseDaoList courses = new CourseDaoList();
        initiate(students, courses);
        Student s = students.findById(111111);
        assertNotNull(s);
        s = students.findById(999999);
        assertEquals(null, s);
        Course c = courses.findById(222);
        assertNotNull(c);
        c = courses.findById(888);
        assertEquals(null, c);
    }

    //a method to test whether find by email works
    @Test
    public void findEmailTest() {
        StudentDaoList students = new StudentDaoList();
        CourseDaoList courses = new CourseDaoList();
        initiate(students, courses);
        Student s = students.findByEmail("jack@gmail.com");
        assertNotNull(s);
        s = students.findByEmail("sophie@gmail.com");
        assertEquals(null, s);
    }

    //a method to test whether find by name works
    @Test
    public void findNameTest() {
        StudentDaoList students = new StudentDaoList();
        CourseDaoList courses = new CourseDaoList();
        initiate(students, courses);
        List<Student> s = students.findByName("jack");
        assertEquals(2, s.size());
        s = students.findByName("sophie");
        assertEquals(0, s.size());
        List<Course> c = courses.findByName("networking");
        assertEquals(2, c.size());
        c = courses.findByName("databases");
        assertEquals(1, c.size());
    }

    //a method to test whether find by date works
    @Test
    public void findDateTest() {
        StudentDaoList students = new StudentDaoList();
        CourseDaoList courses = new CourseDaoList();
        initiate(students, courses);
        List<Course> c = courses.findByDate(LocalDate.of(2020, 10, 20));
        assertEquals(2, c.size());
        c = courses.findByDate(LocalDate.of(2017, 10, 20));
        assertEquals(0, c.size());
    }

    //a method to test whether find all works
    @Test
    public void findAllTest() {
        StudentDaoList students = new StudentDaoList();
        CourseDaoList courses = new CourseDaoList();
        initiate(students, courses);
        List<Student> s = students.findAll();
        assertEquals(7, s.size());
        List<Course> c = courses.findAll();
        assertEquals(3, c.size());
    }

    //a method to test whether remove and delete work
    @Test
    public void removeTest() {
        StudentDaoList students = new StudentDaoList();
        CourseDaoList courses = new CourseDaoList();
        initiate(students, courses);
        Student s1 = students.findById(444444);
        students.deleteStudent(s1);
        List<Student> s = students.findAll();
        assertEquals(6, s.size());
        Course c1 = courses.findById(222);
        courses.removeCourse(c1);
        List<Course> c = courses.findAll();
        assertEquals(2, c.size());
    }
}
