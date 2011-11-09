package entities;

import java.util.LinkedList;

/**
 * Abstract Prerequisite class. A List of courses may be a prerequisite for
 * another course. In order to register for a given course. The student has to
 * fulfill the requirements.
 * 
 * @author Gruppe222 - Gianni
 * 
 */
public abstract class Prerequisite {
	private LinkedList<Course> lstCourses;
	
	/**
	 * Constructor receives a Linked List as parameter.
	 * 
	 * @param lst
	 *            a list of required courses.
	 */
	public Prerequisite(LinkedList<Course> lst) {
		this.lstCourses = new LinkedList<Course>();
		this.lstCourses = lst;
	}
	
	/**
	 * Alternative constructor. This constructor adds a course to the list of
	 * required courses.
	 * 
	 * @param c
	 *            the course to add.
	 */
	public Prerequisite(Course c) {
		this.lstCourses = new LinkedList<Course>();
		this.lstCourses.add(c);
	}
	
	/**
	 * A method to return all the required Courses.
	 * 
	 * @return lstCourses the list of the required courses.
	 */
	public LinkedList<Course> listRequiredCourses() {
		return this.lstCourses;
	}
}
