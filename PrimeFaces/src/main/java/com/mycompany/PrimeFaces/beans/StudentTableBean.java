package com.mycompany.PrimeFaces.beans;

import com.mycompany.PrimeFaces.entity.Student;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Tomek
 */
@Named(value = "studentTableBean")
@ApplicationScoped
public class StudentTableBean {

    private final List<Student> students = Arrays.asList(
            createStudent("Theodore", "Charles", 3.0),
            createStudent("Jonathan", "Harrington", 4.0),
            createStudent("Isaac", "Aguilar", 5.0),
            createStudent("Brian", "Fuller", 4.5),
            createStudent("Sebastian", "Barnett", 3.0),
            createStudent("Tobias", "Brewer", 3.0),
            createStudent("Thomas", "Wilkinson", 5.0),
            createStudent("Oscar", "Garza", 3.5),
            createStudent("Eric", "Andrews", 4.0),
            createStudent("Alexander", "Herrera", 4.0),
            createStudent("Sean", "Moran", 4.0),
            createStudent("Douglas", "Owens", 4.5),
            createStudent("Albert", "Torres", 4.5),
            createStudent("Lloyd", "Waters", 3.0),
            createStudent("Lois", "Fischer", 3.0),
            createStudent("Olivia", "Quinn", 5.0),
            createStudent("Evelyn", "Burns", 5.0),
            createStudent("Natasha", "Summers", 3.5),
            createStudent("Maria", "Robinson", 3.0),
            createStudent("Michelle", "Kirby", 4.5),
            createStudent("Kathryn", "Thompson", 5.0),
            createStudent("Jennifer", "Berry", 4.5)
    );

    public List<Student> getStudents() {
        return students;
    }

    private Student createStudent(String name, String lastName, Double mean) {
        return Student.builder()
                .firstName(name)
                .lastName(lastName)
                .average(mean)
                .build();
    }
}
