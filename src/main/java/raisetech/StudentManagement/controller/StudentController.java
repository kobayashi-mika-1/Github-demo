package raisetech.StudentManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import raisetech.StudentManagement.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.Students_Courses;
import raisetech.StudentManagement.service.StudentService;

@Controller
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service , StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public String studentList (Model model) {
    List<Student> students = service.searchStudentList();
    List<Students_Courses> studentsCourses = service.searchStudents_CoursesList();

    model.addAttribute( "studentList" , converter.convertStudentDetails(students, studentsCourses));
    return "studentList";
  }



  @GetMapping("/studentCourseList")
  public List<Students_Courses> getStudents_CoursestList() {
    return service.searchStudents_CoursesList();
  }
}
