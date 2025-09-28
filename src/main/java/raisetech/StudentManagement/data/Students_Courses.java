package raisetech.StudentManagement.data;

import java.time.LocalDate;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Students_Courses {

  private int ID;
  private int studentsID;
  private String course;
//  private LocalDateTime start_date;
  private LocalDate startDate;
//  private LocalDateTime end_date;
  private LocalDate endDate;

}
