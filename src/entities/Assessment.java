package entities;

import java.util.Date;
import java.util.LinkedList;

public abstract class Assessment {

	private String title;
	private int maxStudentNumber;
	//private AssessmentTypeEnum assessmentType;
	private Date dateOfAssessment;
	private Date firstRegistrationDate;
	private Date lastRegistrationDate;
	private Date lastDeregistrationDate;
	private int studentNumber;
	private LinkedList<Student> lstStudents;

	public Assessment(String title, int maxStudentNumber,
			 Date dateOfAssessment, Date firstRegDate,
			Date lastRegDate, Date lastDeRegDate) {
		this.setTitle(title);
		this.setMaxStudentNumber(maxStudentNumber);
		//this.assessmentType = assessmentType;
		this.setDateOfAssessment(dateOfAssessment);
		this.setFirstRegistrationDate(firstRegDate);
		this.setLastRegistrationDate(lastRegDate);
		this.setLastDeregistrationDate(lastDeRegDate);
		this.setStudentNumber(0);
		this.setLstStudents(new LinkedList<Student>());
	}
	
	public void incrementStudentCounter() {
		this.setStudentNumber(this.getStudentNumber() + 1);
	}
	
	public void decrementStudentCounter() {
		this.setStudentNumber(this.getStudentNumber() - 1);
	}

	/**
	 * @return the firstRegDate
	 */
	public Date getFirstRegistrationDate() {
		return firstRegistrationDate;
	}

	/**
	 * @param firstRegDate the firstRegDate to set
	 */
	public void setFirstRegistrationDate(Date firstRegistrationDate) {
		this.firstRegistrationDate = firstRegistrationDate;
	}

	/**
	 * @return the lastRegDate
	 */
	public Date getLastRegistrationDate() {
		return lastRegistrationDate;
	}

	/**
	 * @param lastRegDate the lastRegDate to set
	 */
	public void setLastRegistrationDate(Date lastRegistrationDate) {
		this.lastRegistrationDate = lastRegistrationDate;
	}

	/**
	 * @return the lastDeRegDate
	 */
	public Date getLastDeregistrationDate() {
		return lastDeregistrationDate;
	}

	/**
	 * @param lastDeRegDate the lastDeRegDate to set
	 */
	public void setLastDeregistrationDate(Date lastDeregistrationDate) {
		this.lastDeregistrationDate = lastDeregistrationDate;
	}

	/**
	 * @return the lstStudents
	 */
	public LinkedList<Student> getLstStudents() {
		return lstStudents;
	}

	/**
	 * @param lstStudents the lstStudents to set
	 */
	public void setLstStudents(LinkedList<Student> lstStudents) {
		this.lstStudents = lstStudents;
	}

<<<<<<< HEAD
	@Override
	public String toString() {
		return "Assessment: " + title + ", "
				+ maxStudentNumber + ", " + dateOfAssessment
				+ ", " + firstRegistrationDate
				+ ", " + lastRegistrationDate
				+ ", " + lastDeregistrationDate
				+ ", " + studentNumber + ", "
				+ lstStudents;
	}
	
=======
	public Date getDateOfAssessment() {
		return dateOfAssessment;
	}

	public void setDateOfAssessment(Date dateOfAssessment) {
		this.dateOfAssessment = dateOfAssessment;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getMaxStudentNumber() {
		return maxStudentNumber;
	}

	public void setMaxStudentNumber(int maxStudentNumber) {
		this.maxStudentNumber = maxStudentNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
>>>>>>> getter and setter added
}
