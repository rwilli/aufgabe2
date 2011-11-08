package entities;

import java.util.Date;
import java.util.LinkedList;

/**
 * The assessment class
 * 
 * @author Gruppe222 - Gianni
 */
public abstract class Assessment {
	// title of the assessment
	private String title;
	
	// maximum student number
	private int maxStudentNumber;
	
	// date of assessment
	private Date dateOfAssessment;
	
	// first date of registration
	private Date firstRegistrationDate;
	
	// last date of registration
	private Date lastRegistrationDate;
	
	// last date of deregistration
	private Date lastDeregistrationDate;
	
	// currently attending student number
	private int studentNumber;
	
	// list of attending students
	private LinkedList<Student> lstStudents;

	/**
	 * default constructor
	 * 
	 * @param title of the assessment
	 * @param maxStudentNumber of the assessment
	 * @param dateOfAssessment of the assessment
	 * @param firstRegDate of the assessment
	 * @param lastRegDate of the assessment
	 * @param lastDeRegDate of the assessment
	 */
	public Assessment(String title, int maxStudentNumber,
			 Date dateOfAssessment, Date firstRegDate,
			Date lastRegDate, Date lastDeRegDate) {
		this.title = title;
		this.maxStudentNumber = maxStudentNumber;
		this.dateOfAssessment = dateOfAssessment;
		this.setFirstRegistrationDate(firstRegDate);
		this.setLastRegistrationDate(lastRegDate);
		this.setLastDeregistrationDate(lastDeRegDate);
		this.studentNumber = 0;
		this.setLstStudents(new LinkedList<Student>());
	}
	
	/**
	 * Increment the currently student number
	 */
	public void incrementStudentCounter() {
		this.studentNumber++;
	}
	
	/**
	 * Decrement the currently student number
	 */
	public void decrementStudentCounter() {
		this.studentNumber--;
	}

	/**
	 * Getter firstRegDate
	 * 
	 * @return the firstRegDate
	 */
	public Date getFirstRegistrationDate() {
		return firstRegistrationDate;
	}

	/**
	 * Setter firstRegDate
	 * 
	 * @param firstRegDate the firstRegDate to set
	 */
	public void setFirstRegistrationDate(Date firstRegistrationDate) {
		this.firstRegistrationDate = firstRegistrationDate;
	}

	/**
	 * Getter lastRegDate
	 * 
	 * @return the lastRegDate
	 */
	public Date getLastRegistrationDate() {
		return lastRegistrationDate;
	}

	/**
	 * Setter lastRegDate
	 * 
	 * @param lastRegDate the lastRegDate to set
	 */
	public void setLastRegistrationDate(Date lastRegistrationDate) {
		this.lastRegistrationDate = lastRegistrationDate;
	}

	/**
	 * Getter lastDeRegDate
	 * 
	 * @return the lastDeRegDate
	 */
	public Date getLastDeregistrationDate() {
		return lastDeregistrationDate;
	}

	/**
	 * Setter lastDeRegDate
	 * 
	 * @param lastDeRegDate the lastDeRegDate to set
	 */
	public void setLastDeregistrationDate(Date lastDeregistrationDate) {
		this.lastDeregistrationDate = lastDeregistrationDate;
	}

	/**
	 * Getter lstStudents
	 * 
	 * @return the lstStudents
	 */
	public LinkedList<Student> getLstStudents() {
		return lstStudents;
	}

	/**
	 * Setter lstStudents
	 * 
	 * @param lstStudents the lstStudents to set
	 */
	public void setLstStudents(LinkedList<Student> lstStudents) {
		this.lstStudents = lstStudents;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
	
}
