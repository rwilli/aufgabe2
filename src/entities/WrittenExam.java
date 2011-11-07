package entities;

import java.util.Date;

/**
 * @author rainer
 *
 */
public class WrittenExam extends Assessment {

	public WrittenExam(String title, int maxStudentNumber,
			 Date dateOfAssessment,
			Date firstRegDate, Date lastRegDate, Date lastDeRegDate) {
		super(title, maxStudentNumber, dateOfAssessment, firstRegDate,
				lastRegDate, lastDeRegDate);
	}

}
