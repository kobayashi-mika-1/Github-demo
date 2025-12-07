package raisetech.StudentManagement.data;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class students_Courses {

  private int id;
  private int studentsId;
  private String course;
//  private LocalDateTime start_date;
  private LocalDate startDate;
//  private LocalDateTime end_date;
  private LocalDate endDate;

}
