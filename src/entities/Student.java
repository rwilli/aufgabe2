package entities;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

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
	
	// list with the student's courses
	private List<Course> lst_courses;
	
	// list with the student's groups
	private List<Group> lst_groups;
	
	// list with the student's assessments
	private List<Assessment> lst_assessments;
	
	// list with the student's grades
	private HashMap<Course,GradeTypeEnum> map_grades;
	
	/**
	 * default constructor with given matrNr
	 * 
	 * @param matrNr student unique id
	 * @param firstName of the student
	 * @param lastName of the student
	 * @param email of the student
	 */
	
	/* TODO set STEG and STEOP automatically */
	
	public Student(String matrNr, String firstName, String lastName, String email) {
		this.matrNr = matrNr;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.lst_courses = new LinkedList<Course>();
		this.lst_groups = new LinkedList<Group>();
		this.lst_assessments = new LinkedList<Assessment>();
		this.map_grades = new HashMap<Course, GradeTypeEnum>();
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
	public HashMap<Course,GradeTypeEnum> listAllGrades() {
		return this.map_grades;
	}
	
	/**
	 * Subscribe student for course
	 * 
	 * @param cr Course
	 * @throws SubscribeException 
	 */
	public void subscribe(Course cr) throws SubscribeException {
		Calendar cal = Calendar.getInstance();
	    
	    if (cr.getFirstRegistrationDate().after(cal.getTime()) || cr.getLastRegistrationDate().before(cal.getTime())) {
	    	throw new SubscribeException("Look at the registration time");
	    }
	    
	    // check course requirements
	    if( cr.getPrerequisites() != null){
	    	for (Prerequisite p: cr.getPrerequisites()) {
		    	for (Course c: p.listRequiredCourses()) {
		    		if (!this.map_grades.containsKey(c))
			    		throw new SubscribeException("Required Course not complied " + c.getTitle());
		    	}
	    	}
	    }
		
		if (!cr.getAllRegisteredStudents().contains(this)) {
			if (cr.getStudentCount() <= cr.getMaxStudentCount()) {
				cr.incrementStudentCounter();
				cr.getAllRegisteredStudents().add(this);
				this.lst_courses.add(cr);
			} else
				throw new SubscribeException("Course reached maximum student number.");
		} else {
			throw new SubscribeException("Student already attending this course.");
		}
	}
	
	/**
	 * Unsubscribe student for course
	 * 
	 * @param cr Course
	 * @throws UnsubscribeException 
	 */
	public void unsubscribe(Course cr) throws UnsubscribeException {
		Calendar cal = Calendar.getInstance();
	    
	    if (cr.getLastDeregistrationDate().before(cal.getTime())) {
	    	throw new UnsubscribeException("Deregistration expired.");
	    } else {	
	    	if (cr.getAllRegisteredStudents().remove(this)) {
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
	 * @throws SubscribeException 
	 */
	public void subscribe(Assessment ass) throws SubscribeException {
		Calendar cal = Calendar.getInstance();
	    
	    if (ass.getFirstRegistrationDate().after(cal.getTime()) || ass.getLastRegistrationDate().before(cal.getTime())) {
	    	throw new SubscribeException("Look at the registration time");
	    }
		
		if (!ass.getLstStudents().contains(this)) {
			ass.incrementStudentCounter();
			ass.getLstStudents().add(this);
			this.lst_assessments.add(ass);
		} else {
			throw new SubscribeException("Student already attending this assessment.");
		}
	}
	
	/**
	 * Unsubscribe student for assessment
	 * 
	 * @param ass Assessment
	 * @throws UnsubscribeException 
	 */
	public void unsubscribe(Assessment ass) throws UnsubscribeException {
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
	public void addGrade(Course cr, GradeTypeEnum grade) {
		
		/* if grade already exists, it will be overwritten */
		
		this.map_grades.put(cr, grade );
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((lst_assessments == null) ? 0 : lst_assessments.hashCode());
		result = prime * result
				+ ((lst_courses == null) ? 0 : lst_courses.hashCode());
		result = prime * result
				+ ((lst_groups == null) ? 0 : lst_groups.hashCode());
		result = prime * result
				+ ((map_grades == null) ? 0 : map_grades.hashCode());
		result = prime * result + ((matrNr == null) ? 0 : matrNr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (lst_assessments == null) {
			if (other.lst_assessments != null)
				return false;
		} else if (!lst_assessments.equals(other.lst_assessments))
			return false;
		if (lst_courses == null) {
			if (other.lst_courses != null)
				return false;
		} else if (!lst_courses.equals(other.lst_courses))
			return false;
		if (lst_groups == null) {
			if (other.lst_groups != null)
				return false;
		} else if (!lst_groups.equals(other.lst_groups))
			return false;
		if (map_grades == null) {
			if (other.map_grades != null)
				return false;
		} else if (!map_grades.equals(other.map_grades))
			return false;
		if (matrNr == null) {
			if (other.matrNr != null)
				return false;
		} else if (!matrNr.equals(other.matrNr))
			return false;
		return true;
	}
	
}
