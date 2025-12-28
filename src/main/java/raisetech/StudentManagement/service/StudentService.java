package raisetech.StudentManagement.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.students_Courses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.repository.StudentRepository;

@Service

public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.search();
  }

  public StudentDetail searchStudent(String id) {
  Student student = repository.searchStudent(id);
  repository.searchstudents_Courses(student.getId());
  List<students_Courses> studentsCourses = repository.searchstudents_Courses(student.getId());
  StudentDetail studentDetail = new StudentDetail();
  studentDetail.setStudent(student);
  studentDetail.setStudentsCourses(studentsCourses);
  return studentDetail;
}

  public List<students_Courses> searchStudents_CoursesList() {
    return repository.searchstudents_CoursesList();
  }

@Transactional
  public void registerStudent(StudentDetail studentDetail) {
  repository.registerStudent(studentDetail.getStudent());
  for (students_Courses students_courses : studentDetail.getStudentsCourses()) {
    students_courses.setStudentsId(studentDetail.getStudent().getId());
    students_courses.setStartDate(LocalDate.from(LocalDateTime.now()));
    students_courses.setEndDate(LocalDate.from(LocalDateTime.now().plusYears(1)));
    repository.registerStudentsCourses(students_courses);
  }
}


  @Transactional
  public void updateStudent(StudentDetail studentDetail) {
    repository.updateStudent(studentDetail.getStudent());
    for (students_Courses students_courses : studentDetail.getStudentsCourses()) {
      repository.updateStudentsCourses(students_courses);
    }
  }
}
