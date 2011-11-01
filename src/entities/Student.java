package entities;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import exception.SubscribeException;
import exception.UnsubscribeException;

/**
 * The student class extends the abstract person class
 * and implements methods for student actions
 * 
 * @author Gruppe222 - Rainer
 */
public class Student extends Person {
	// student id
	private final String matrNr;
	
	// steop reached
	private boolean hasSteop = false;
	
	// steg reached
	private boolean hasSteg = false;
	
	// list with the student's courses
	private List<Course> lst_courses;
	
	// list with the student's groups
	private List<Group> lst_groups;
	
	// list with the student's assessments
	private List<Assessment> lst_assessments;
	
	// list with the student's grades
	private List<String> lst_grades;
	
	/**
	 * default constructor with given matrNr
	 * 
	 * @param matrNr student unique id
	 * @param firstName of the student
	 * @param lastName of the student
	 * @param email of the student
	 */
	public Student(String matrNr, String firstName, String lastName, String email) {
		this.matrNr = matrNr;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.lst_courses = new LinkedList<Course>();
		this.lst_groups = new LinkedList<Group>();
		this.lst_assessments = new LinkedList<Assessment>();
		this.lst_grades = new LinkedList<String>();
	}

	/**
	 * Getter matrNr
	 * 
	 * @return the matrNr
	 */
	public String getMatrNr() {
		return matrNr;
	}

	/**
	 * Setter matrNr
	 * 
	 * @param matrNr the matrNr to set
	 */
	public void setMatrNr(String matrNr) {
		this.matrNr = matrNr;
	}
	
	/**
	 * Getter steop
	 * 
	 * @return the hasSteop
	 */
	public boolean isHasSteop() {
		return hasSteop;
	}

	/**
	 * Setter steop
	 * 
	 * @param hasSteop the hasSteop to set
	 */
	public void setHasSteop(boolean hasSteop) {
		this.hasSteop = hasSteop;
	}

	/**
	 * Getter steg
	 * 
	 * @return the hasSteg
	 */
	public boolean isHasSteg() {
		return hasSteg;
	}

	/**
	 * Setter steg
	 * 
	 * @param hasSteg the hasSteg to set
	 */
	public void setHasSteg(boolean hasSteg) {
		this.hasSteg = hasSteg;
	}

	/**
	 * List all groups of the student for which
	 * he is registered.
	 * 
	 * @return list of the student's groups
	 */
	public List<Group> listAllGroups() {
		return this.lst_groups;
	}
	
	/**
	 * List all assessments of the student for
	 * which he is registered.
	 * 
	 * @return list of the student's assessments
	 */
	public List<Assessment> listAllAssessments() {
		return this.lst_assessments;
	}
	
	/**
	 * Add assessment to student. Only used after
	 * created an instance from Student to add 
	 * some Assessments
	 * 
	 * @return void
	 */
	public void addAssessments(Assessment a) {
		this.lst_assessments.add(a);
	}
	
	/**
	 * List all grades of the student
	 * 
	 * @return list of the student's grades
	 */
	public List<String> listAllGrades() {
		return this.lst_grades;
	}
	
	/**
	 * Subscribe student for course
	 * 
	 * @param cr Course
	 */
	public void subscribe(Course cr) {
		Calendar cal = Calendar.getInstance();
	    
	    if (cr.getFirstRegistrationDate().after(cal.getTime()) || cr.getLastRegistrationDate().before(cal.getTime())) {
	    	throw new SubscribeException("Look at the registration time");
	    }
		
		if (!cr.getLstStudents().contains(this)) {
			cr.incrementStudentCounter();
			cr.getLstStudents().add(this);
			this.lst_courses.add(cr);
		} else {
			throw new SubscribeException("Student already attending this course.");
		}
	}
	
	/**
	 * Unsubscribe student for course
	 * 
	 * @param cr Course
	 */
	public void unsubscribe(Course cr) {
		Calendar cal = Calendar.getInstance();
	    
	    if (cr.getLastDeregistrationDate().before(cal.getTime())) {
	    	throw new UnsubscribeException("Deregistration expired.");
	    } else {	
	    	if (cr.getLstStudents().remove(this)) {
				cr.decrementStudentCounter();
				this.lst_courses.remove(cr);
	    	} else  		
	    		throw new UnsubscribeException("No Registration found.");  
	    }
	}
	
	/**
	 * Subscribe student for assessment
	 * 
	 * @param ass Assessment
	 */
	public void subscribe(Assessment ass) {
		Calendar cal = Calendar.getInstance();
	    
	    if (ass.getFirstRegistrationDate().after(cal.getTime()) || ass.getLastRegistrationDate().before(cal.getTime())) {
	    	throw new SubscribeException("Look at the registration time");
	    }
		
		if (!ass.getLstStudents().contains(this)) {
			ass.incrementStudentCounter();
			ass.getLstStudents().add(this);
			this.lst_assessments.add(ass);
		} else {
			throw new SubscribeException("Student already attending this course.");
		}
	}
	
	/**
	 * Unsubscribe student for assessment
	 * 
	 * @param ass Assessment
	 */
	public void unsubscribe(Assessment ass) {
		Calendar cal = Calendar.getInstance();
	    
	    if (ass.getLastDeregistrationDate().before(cal.getTime())) {
	    	throw new UnsubscribeException("Deregistration expired.");
	    } else {	
	    	if (ass.getLstStudents().remove(this)) {
				ass.decrementStudentCounter();
				this.lst_assessments.remove(ass);
	    	} else  		
	    		throw new UnsubscribeException("No Registration found.");  
	    }
	}
	
	/**
	 * Subscribe student for group
	 * 
	 * @param gr Group
	 */
	public void subscribe(Group gr) {
		this.lst_groups.add(gr);
	}
	
	/**
	 * Unsubscribe student for group
	 * 
	 * @param gr Group
	 */
	public void unsubscribe(Group gr) {
		this.lst_groups.remove(gr);
	}
	
	/**
	 * Add grade to the student's grade list
	 * 
	 * @param grade Grade
	 */
	public void addGrade(String grade) {
		this.lst_grades.add(grade);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (hasSteg ? 1231 : 1237);
		result = prime * result + (hasSteop ? 1231 : 1237);
		result = prime * result
				+ ((lst_courses == null) ? 0 : lst_courses.hashCode());
		result = prime * result
				+ ((lst_grades == null) ? 0 : lst_grades.hashCode());
		result = prime * result
				+ ((lst_groups == null) ? 0 : lst_groups.hashCode());
		result = prime * result + ((matrNr == null) ? 0 : matrNr.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (hasSteg != other.hasSteg)
			return false;
		if (hasSteop != other.hasSteop)
			return false;
		if (lst_courses == null) {
			if (other.lst_courses != null)
				return false;
		} else if (!lst_courses.equals(other.lst_courses))
			return false;
		if (lst_grades == null) {
			if (other.lst_grades != null)
				return false;
		} else if (!lst_grades.equals(other.lst_grades))
			return false;
		if (lst_groups == null) {
			if (other.lst_groups != null)
				return false;
		} else if (!lst_groups.equals(other.lst_groups))
			return false;
		if (matrNr == null) {
			if (other.matrNr != null)
				return false;
		} else if (!matrNr.equals(other.matrNr))
			return false;
		return true;
	}
	
}