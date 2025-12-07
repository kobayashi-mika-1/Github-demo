package raisetech.StudentManagement.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.students_Courses;

@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<students_Courses> studentsCourses;

}
