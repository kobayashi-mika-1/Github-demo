package raisetech.StudentManagement.controllar;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.Students_Courses;
import raisetech.StudentManagement.service.StudentService;

@RestController
public class StudentControllar {

  private StudentService service;

  @Autowired
  public StudentControllar(StudentService service) {
    this.service = service;
  }

  @GetMapping("/studentList")
  public List<Student> getsearchStudentList() {
    return service.searchStudentList();
  }

  @GetMapping("/studentCourseList")
  public List<Students_Courses> getStudents_CoursestList() {
    return service.searchStudents_CoursesList();
  }
}
