package entities;

import java.util.LinkedList;

/**
 * The Steop class is a subtype of the abstract class Prerequisite and inherits
 * all its methods.
 * 
 * @author Gruppe222 - Gianni
 * 
 */
public class Steop extends Prerequisite {

	/**
	 * Constructor calls the constructor of the super class.
	 * 
	 * @param lst
	 *            the list of required courses.
	 */
	public Steop(LinkedList<Course> lst) {
		super(lst);
	}
	
	/**
	 * Alternative constructor calls the constructor of the super class.
	 * 
	 * @param c
	 *            a course to add to the required courses.
	 */
	public Steop(Course c) {
		super(c);
	}

}
