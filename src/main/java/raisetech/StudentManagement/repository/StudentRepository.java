package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.students_Courses;

@Mapper

public interface StudentRepository {

  @Select("SELECT * FROM students ")
  List<Student> search();

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);

  @Select("SELECT * FROM students_courses")
  List<students_Courses> searchstudents_CoursesList();

  @Select("SELECT * FROM students_courses WHERE studentsId = #{studentsId}")
  List<students_Courses> searchstudents_Courses(int studentsId);


  @Insert("INSERT INTO students(fullName, furigana, nicname, email, address, age, gender, remark, isDeleted) VALUES(#{fullName}, #{furigana}, #{nicname}, #{email}, #{address}, #{age}, #{gender}, #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);

  @Insert("INSERT INTO students_courses(studentsID, course, start_date, end_date) VALUES(#{studentsId}, #{course}, #{startDate}, #{endDate})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentsCourses(students_Courses students_courses);


  @Update("UPDATE students SET fullName = #{fullName}, furigana = #{furigana}, nicname =#{nicname}, email = #{email}, address = #{address}, age = #{age}, gender = #{gender}, remark = #{remark}, isDeleted = #{isDeleted} WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE students_courses SET course = #{course} WHERE id = #{id} ")
  void updateStudentsCourses(students_Courses students_courses);
}
