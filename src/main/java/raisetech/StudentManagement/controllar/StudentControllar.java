package raisetech.StudentManagement.controllar;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.Students_Courses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

@RestController
public class StudentControllar {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentControllar(StudentService service , StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public List<StudentDetail> getsearchStudentList() {
    List<Student> students = service.searchStudentList();
    List<Students_Courses> studentsCourses = service.searchStudents_CoursesList();

    return converter.convertStudentDetails(students, studentsCourses);
  }



  @GetMapping("/studentCourseList")
  public List<Students_Courses> getStudents_CoursestList() {
    return service.searchStudents_CoursesList();
  }
}
