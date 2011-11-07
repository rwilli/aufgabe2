package entities;

import java.util.LinkedList;

/**
 * @author rainer
 *
 */
public abstract class Prerequisite {
	private LinkedList<Course> lstCourses;
	
	
	public Prerequisite(LinkedList<Course> lst) {
		this.lstCourses = new LinkedList<Course>();
		this.lstCourses = lst;
	}
	
	public Prerequisite(Course c) {
		this.lstCourses = new LinkedList<Course>();
		this.lstCourses.add(c);
	}
	
	public LinkedList<Course> listRequiredCourses() {
		return this.lstCourses;
	}
}
