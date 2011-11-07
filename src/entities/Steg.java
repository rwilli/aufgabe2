package entities;

import java.util.LinkedList;

/**
 * @author rainer
 *
 */
public class Steg extends Prerequisite {

	public Steg(LinkedList<Course> lst) {
		super(lst);
	}

	public Steg(Course c) {
		super(c);
	}

	
}
