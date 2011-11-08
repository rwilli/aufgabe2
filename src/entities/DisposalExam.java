package entities;

import java.util.Date;

/**
 * @author rainer
 *
 */
public class DisposalExam extends Assessment {

	/**
	 * 
	 * @param title
	 * @param maxStudentNumber
	 * @param dateOfAssessment
	 * @param firstRegDate
	 * @param lastRegDate
	 * @param lastDeRegDate
	 */
	public DisposalExam(String title, int maxStudentNumber,
			Date dateOfAssessment, Date firstRegDate, Date lastRegDate,
			Date lastDeRegDate) {
		super(title, maxStudentNumber, dateOfAssessment, firstRegDate, lastRegDate,
				lastDeRegDate);
	}

}
