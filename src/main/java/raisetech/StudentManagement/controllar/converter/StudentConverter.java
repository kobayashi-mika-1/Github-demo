package raisetech.StudentManagement.controllar.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.Students_Courses;
import raisetech.StudentManagement.domain.StudentDetail;

@Component
public class StudentConverter {

  public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<Students_Courses> studentsCourses) {
    List<StudentDetail> studentDetailList = new ArrayList<>();
    students.forEach(student -> {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);
      List<Students_Courses> convertStudentCourses = studentsCourses.stream()
          .filter(studentsCourse -> student.getId() == studentsCourse.getStudentsId())
          .collect(Collectors.toList());
      studentDetail.setStudentsCourses(convertStudentCourses);
      studentDetailList.add(studentDetail);
    });
    return studentDetailList;
  }

}
