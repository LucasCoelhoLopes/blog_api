package blog.domain.post.dateUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	public static String getCurrentDate() {
		LocalDate currentDate = LocalDate.now();	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");	
		String formattedDate = currentDate.format(formatter);
        
        return formattedDate;
	}
	
}
