package entities;

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
	
	public Course(String title, int maxStudent, Date firstRegistrationDate,
			Date lastRegistrationDate, Date lastDeregistrationDate, LinkedList<Prerequisite> lst) {
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the firstRegistrationDate
	 */
	public Date getFirstRegistrationDate() {
		return firstRegistrationDate;
	}

	/**
	 * @param firstRegistrationDate
	 *            the firstRegistrationDate to set
	 */
	public void setFirstRegistrationDate(Date firstRegistrationDate) {
		this.firstRegistrationDate = firstRegistrationDate;
	}

	/**
	 * @return the lastRegistrationDate
	 */
	public Date getLastRegistrationDate() {
		return lastRegistrationDate;
	}

	/**
	 * @param lastRegistrationDate
	 *            the lastRegistrationDate to set
	 * @throws AdministrationException
	 */
	public void setLastRegistrationDate(Date lastRegistrationDate) throws DateException {
		if (lastRegistrationDate.before(cal.getTime())) {
			throw new DateException("Date is in the past.");
		}
		this.lastRegistrationDate = lastRegistrationDate;
	}

	/**
	 * @return the lastDeregistrationDate
	 */
	public Date getLastDeregistrationDate() {
		return lastDeregistrationDate;
	}

	/**
	 * @param lastDeregistrationDate
	 *            the lastDeregistrationDate to set
	 * @throws AdministrationException 
	 */
	public void setLastDeregistrationDate(Date lastDeregistrationDate) throws DateException {
		if (lastDeregistrationDate.before(cal.getTime())) {
			throw new DateException("Date is in the past.");
		}
		this.lastDeregistrationDate = lastDeregistrationDate;
	}

	/**
	 * @return the studentCount
	 */
	public int getStudentCount() {
		return studentCount;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the lstStudents
	 */
	public LinkedList<Student> getAllRegisteredStudents() {
		return lstStudents;
	}

	/**
	 * @param lstGroups
	 *            the lstGroups to set
	 */
	public void setLstGroups(LinkedList<Group> lstGroups) {
		this.lstGroups = lstGroups;
	}
	
	public void addGroup( Group g) {
		this.lstGroups.add(g);
	}

	/**
	 * @return the lstGroups
	 */
	public LinkedList<Group> getGroups() {
		return lstGroups;
	}

	/**
	 * @param lstStudents
	 *            the lstStudents to set
	 */
	public void setLstStudents(LinkedList<Student> lstStudents) {
		this.lstStudents = lstStudents;
	}
	
	/**
	 * @param lecturer
	 *            the lecturer to set
	 */
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	/**
	 * @return the lecturer of the course
	 */
	public Lecturer getLecturer() {
		return lecturer;
	}

	/**
	 * @return the maxStudentCount
	 */
	public int getMaxStudentCount() {
		return maxStudentCount;
	}

	/**
	 * @param maxStudentCount
	 *            the maxStudentCount to set
	 */
	public void setMaxStudentCount(int maxStudentCount) {
		this.maxStudentCount = maxStudentCount;
	}

	/**
	 * @return the infoDate
	 */
	public Date getInfoDate() {
		return infoDate;
	}

	/**
	 * @param infoDate
	 *            the infoDate to set
	 * @throws AdministrationException if the date is in the past.
	 */
	public void setInfoDate(Date infoDate) throws DateException {
		if (infoDate.before(cal.getTime())) {
			throw new DateException("Date is in the past.");
		}
		this.infoDate = infoDate;
	}

	/**
	 * @return the regType
	 */
	public RegistrationTypeEnum getRegType() {
		return regType;
	}

	/**
	 * @param regType
	 *            the regType to set
	 */
	public void setRegType(RegistrationTypeEnum regType) {
		this.regType = regType;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * sets the coures to active
	 */
	public void setActive() {
		this.active = true;
	}

	/**
	 * sets the course to inactive
	 */
	public void setInactive() {
		this.active = false;
	}
	
	/**
	 * Returns all Assessments
	 * @return
	 */
	public LinkedList<Assessment> getAllAssessments() {
		return lstAssessments;
	}

	/**
	 * sets all Assessments
	 * @param lstAssessments
	 */
	public void setAllAssessment(LinkedList<Assessment> lstAssessments) {
		this.lstAssessments = lstAssessments;
	}
	
	/**
	 * Adds an Assessment to the List
	 * @param a
	 */
	public void addAssessment( Assessment a){
		this.lstAssessments.add(a);
		
	}

	/**
	 * cancels the course with the given message
	 * @param m reason for the cancel
	 * @throws AdministrationException if the course was already canceled before;
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
	 * Informs the students attending this course.
	 * @param students
	 */
	public void inform(LinkedList<Student> students, Message m) {
		for (Student s : students) {
			s.inform(m);
		}
	}
	
	
	/**
	 * Informs the students attending this course and the lecturer.
	 * @param students
	 * @param l
	 */
	public void inform(LinkedList<Student> students, Lecturer l, Message m) {
		l.inform(m);
		for (Student s : students) {
			s.inform(m);
		}
		
	}

	/**
	 * @return the reqCourses
	 */
	public LinkedList<Prerequisite> getPrerequisites() {
		return this.lstPrerequisite;
	}
	
	/**
	 * increments the student count by 1.
	 */
	public void incrementStudentCounter() {
		this.studentCount++;
	}
	
	/**
	 * decrements the student count by 1.
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

		return this.id + "\t" + this.title;
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
