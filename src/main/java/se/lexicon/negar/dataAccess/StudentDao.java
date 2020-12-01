package se.lexicon.negar.dataAccess;


import se.lexicon.negar.businessLogic.Student;
import java.util.List;


//an interface for the data access part of students
public interface StudentDao {
    public Student saveStudent(Student student);

    public Student findByEmail(String email);

    public List<Student> findByName(String name);

    public Student findById(int id);

    public List<Student> findAll();

    public boolean deleteStudent(Student student);
}

