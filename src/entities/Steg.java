package entities;

import java.util.LinkedList;

/**
 * The Steg class is a subtype of the abstract class Prerequisite and inherits
 * all its methods.
 * 
 * @author Gruppe222 - Gianni
 * 
 */
public class Steg extends Prerequisite {

	/**
	 * Constructor calls the constructor of the super class.
	 * 
	 * @param lst
	 *            the given list of courses.
	 */
	public Steg(LinkedList<Course> lst) {
		super(lst);
	}

	/**
	 * Alternative constructor calls the alternative constructor of the super
	 * class.
	 * 
	 * @param c
	 *            a course to add to the required courses.
	 */
	public Steg(Course c) {
		super(c);
	}

	
}
