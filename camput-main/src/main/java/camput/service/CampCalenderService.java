package camput.service;

import java.time.LocalDate;
import java.util.List;

public interface CampCalenderService {
   List<LocalDate> campBookedCalender(String campName);
}
