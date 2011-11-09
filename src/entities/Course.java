package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import exception.DateException;

/**
 * The course class
 * 
 * @author Gruppe222 - Gianni
 */
public class Course {

	// static variable necessary to create unique course IDs
	private static int count = 0;

	// unique Course number
	private final int id;

	// Course title
	private String title;

	// first date of registration
	private Date firstRegistrationDate;

	// last date of registration
	private Date lastRegistrationDate;

	// last date of deregistration
	private Date lastDeregistrationDate;

	// date when students are informed
	private Date infoDate;

	// student registration counter
	private int studentCount;

	// list of registered students
	private LinkedList<Student> lstStudents;

	// Lecturer of the course
	private Lecturer lecturer;

	// list of the groups
	private LinkedList<Group> lstGroups;

	// maximum number of registrations
	private int maxStudentCount;

	// RegistrationType for this course
	private RegistrationTypeEnum regType;

	// determines whether course is active or not;
	private boolean active;

	// calendar variable
	private Calendar cal;

	// Assessments for this Course
	private LinkedList<Assessment> lstAssessments;

	// required Courses for the current course, can be null.
	private LinkedList<Prerequisite> lstPrerequisite;

	/**
	 * Constructor for Course. This constructor creates a course without
	 * prerequisites.
	 * 
	 * @param title
	 *            the course title
	 * @param firstRegistrationDate
	 *            the first registration date of the course
	 * @param lastRegistrationDate
	 *            the last registration date of the course
	 * @param lastDeregistrationDate
	 *            the last deregistration date of the course
	 */
	public Course(String title, int maxStudent, Date firstRegistrationDate,
			Date lastRegistrationDate, Date lastDeregistrationDate) {
		this.id = ++count;
		this.title = title;
		this.maxStudentCount = maxStudent;
		this.firstRegistrationDate = firstRegistrationDate;
		this.lastRegistrationDate = lastRegistrationDate;
		this.lastDeregistrationDate = lastDeregistrationDate;
		this.studentCount = 0;
		this.lstStudents = new LinkedList<Student>();
		this.lstGroups = new LinkedList<Group>();
		this.regType = RegistrationTypeEnum.elektronisch;
		this.active = true;
		cal = Calendar.getInstance();
		this.setAllAssessment(new LinkedList<Assessment>());

	}

	/**
	 * Alternative Constructor for Entity Course. This constructor creates a
	 * course with prerequisites.
	 * 
	 * @param title
	 * @param maxStudent
	 * @param firstRegistrationDate
	 * @param lastRegistrationDate
	 * @param lastDeregistrationDate
	 * @param lst
	 */
	public Course(String title, int maxStudent, Date firstRegistrationDate,
			Date lastRegistrationDate, Date lastDeregistrationDate,
			LinkedList<Prerequisite> lst) {
		this.id = ++count;
		this.title = title;
		this.maxStudentCount = maxStudent;
		this.firstRegistrationDate = firstRegistrationDate;
		this.lastRegistrationDate = lastRegistrationDate;
		this.lastDeregistrationDate = lastDeregistrationDate;
		this.studentCount = 0;
		this.lstStudents = new LinkedList<Student>();
		this.lstGroups = new LinkedList<Group>();
		this.regType = RegistrationTypeEnum.elektronisch;
		this.active = true;
		cal = Calendar.getInstance();
		this.lstPrerequisite = lst;
		this.setAllAssessment(new LinkedList<Assessment>());

	}

	/**
	 * Getter for the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Setter for the title.
	 * 
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Getter for the first Registration Date.
	 * 
	 * @return the firstRegistrationDate
	 */
	public Date getFirstRegistrationDate() {
		return firstRegistrationDate;
	}

	/**
	 * Setter for the first Registration Date.
	 * 
	 * @param firstRegistrationDate
	 *            the firstRegistrationDate to set
	 */
	public void setFirstRegistrationDate(Date firstRegistrationDate) {
		this.firstRegistrationDate = firstRegistrationDate;
	}

	/**
	 * Getter for the Last Registration Date.
	 * 
	 * @return the lastRegistrationDate
	 */
	public Date getLastRegistrationDate() {
		return lastRegistrationDate;
	}

	/**
	 * Setter for the Last Registration Date.
	 * 
	 * @param lastRegistrationDate
	 *            the lastRegistrationDate to set
	 * @throws DateException
	 *             if the Date is in the past.
	 */
	public void setLastRegistrationDate(Date lastRegistrationDate)
			throws DateException {
		if (lastRegistrationDate.before(cal.getTime())) {
			throw new DateException("Date is in the past.");
		}
		this.lastRegistrationDate = lastRegistrationDate;
	}

	/**
	 * Getter for the Last Deregistration Date.
	 * 
	 * @return the lastDeregistrationDate
	 */
	public Date getLastDeregistrationDate() {
		return lastDeregistrationDate;
	}

	/**
	 * Setter for the Last Deregistration Date.
	 * 
	 * @param lastDeregistrationDate
	 *            the lastDeregistrationDate to set
	 * @throws DateException
	 *             when the chose date is in the past or
	 */
	public void setLastDeregistrationDate(Date lastDeregistrationDate)
			throws DateException {
		if (lastDeregistrationDate.before(cal.getTime())) {
			throw new DateException("Date is in the past.");
		}
		this.lastDeregistrationDate = lastDeregistrationDate;
	}

	/**
	 * Getter for the student Count.
	 * 
	 * @return the studentCount as Integer.
	 */
	public int getStudentCount() {
		return studentCount;
	}

	/**
	 * Getter for the ID of the course.
	 * 
	 * @return the id as Integer.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter for the list of all registered students.
	 * 
	 * @return the lstStudents
	 */
	public LinkedList<Student> getAllRegisteredStudents() {
		return lstStudents;
	}

	/**
	 * Setter for the list of students registered for the course.
	 * 
	 * @param lstStudents
	 *            the lstStudents to set
	 */
	public void setLstStudents(LinkedList<Student> lstStudents) {
		this.lstStudents = lstStudents;
	}

	/**
	 * Setter for the list of groups.
	 * 
	 * @param lstGroups
	 *            the lstGroups to set
	 */
	public void setLstGroups(LinkedList<Group> lstGroups) {
		this.lstGroups = lstGroups;
	}
	
	/**
	 * Adds Group to the list
	 *
	 * @param g Group
	 */
	public void addGroup(Group g) {
		this.lstGroups.add(g);
	}

	/**
	 * Getter for the list of groups.
	 * 
	 * @return the lstGroups
	 */
	public LinkedList<Group> getGroups() {
		return lstGroups;
	}

	/**
	 * Setter for the lecturer of the course.
	 * 
	 * @param lecturer
	 *            the lecturer to set
	 */
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	/**
	 * Getter for the lecturer of the course.
	 * 
	 * @return the lecturer of the course
	 */
	public Lecturer getLecturer() {
		return lecturer;
	}

	/**
	 * Getter for the maximum amount of students in this course.
	 * 
	 * @return the maxStudentCount
	 */
	public int getMaxStudentCount() {
		return maxStudentCount;
	}

	/**
	 * Setter for the maximum amount of students.
	 * 
	 * @param maxStudentCount
	 *            the maxStudentCount to set
	 */
	public void setMaxStudentCount(int maxStudentCount) {
		this.maxStudentCount = maxStudentCount;
	}

	/**
	 * Getter for the Date when information is sent.
	 * 
	 * @return the infoDate
	 */
	public Date getInfoDate() {
		return infoDate;
	}

	/**
	 * Setter for Date when information is sent.
	 * 
	 * @param infoDate
	 *            the infoDate to set
	 * @throws DateException
	 *             if the date is in the past.
	 */
	public void setInfoDate(Date infoDate) throws DateException {
		if (infoDate.before(cal.getTime())) {
			throw new DateException("Date is in the past.");
		}
		this.infoDate = infoDate;
	}

	/**
	 * Getter for the Registration Type of the course.
	 * 
	 * @return the regType
	 */
	public RegistrationTypeEnum getRegType() {
		return regType;
	}

	/**
	 * Setter for the Registration Type of the course.
	 * 
	 * @param regType
	 *            the regType to set
	 */
	public void setRegType(RegistrationTypeEnum regType) {
		this.regType = regType;
	}

	/**
	 * Method to determine whether the course is active or canceled.
	 * 
	 * @return whether the course is active or not as Boolean.
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the coures to active
	 */
	public void setActive() {
		this.active = true;
	}

	/**
	 * Sets the course to inactive
	 */
	public void setInactive() {
		this.active = false;
	}

	/**
	 * Returns all Assessments
	 * 
	 * @return
	 */
	public LinkedList<Assessment> getAllAssessments() {
		return lstAssessments;
	}

	/**
	 * Sets all assessments
	 * 
	 * @param lstAssessments
	 *            the list containing Assessments
	 */
	public void setAllAssessment(LinkedList<Assessment> lstAssessments) {
		this.lstAssessments = lstAssessments;
	}

	/**
	 * Adds an assessment to the List
	 * 
	 * @param a
	 *            an assessment
	 */
	public void addAssessment(Assessment a) {
		this.lstAssessments.add(a);

	}

	/**
	 * Cancels the course with the given message
	 * 
	 * @param m
	 *            reason for the cancellation
	 */
	public void cancelCourse(Message m) {
		if (this.active == true) {
			this.active = false;
			if (this.lecturer != null) {
				inform(this.lstStudents, this.lecturer, m);
			} else {
				inform(this.lstStudents, m);
			}
		}
	}

	/**
	 * Informs the students attending this course with the given message.
	 * 
	 * @param students
	 *            the list of registered students
	 * @param m
	 *            the message to send
	 */
	public void inform(LinkedList<Student> students, Message m) {
		for (Student s : students) {
			s.inform(m);
		}
	}

	/**
	 * Informs the students attending this course and the lecturer with the
	 * given message.
	 * 
	 * @param students
	 *            the list of registered students
	 * @param l
	 *            the lecturer of the course
	 * @param m
	 *            the message to send
	 */
	public void inform(LinkedList<Student> students, Lecturer l, Message m) {
		l.inform(m);
		for (Student s : students) {
			s.inform(m);
		}

	}

	/**
	 * Getter for the list of prerequisites.
	 * 
	 * @return the lstPrerequisites a list of prerequisites for the course.
	 */
	public LinkedList<Prerequisite> getPrerequisites() {
		return this.lstPrerequisite;
	}

	/**
	 * Increments the student count by 1.
	 */
	public void incrementStudentCounter() {
		this.studentCount++;
	}

	/**
	 * Decrements the student count by 1.
	 */
	public void decrementStudentCounter() {
		this.studentCount--;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return this.id + "\t" + this.title + "\t\t"
				+ sdf.format(this.firstRegistrationDate) + "\t"
				+ sdf.format(this.lastRegistrationDate) + "\t"
				+ sdf.format(this.lastDeregistrationDate) + "\t"
				+ this.studentCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public boolean equals(Object obj) {

		Course c = (Course) obj;
		if (c.getId() == this.id) {
			return true;
		}
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public int hashCode() {
		return 31 * (31 * getId());

	}

}
