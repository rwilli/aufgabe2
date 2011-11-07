/**
 * 
 */
package entities;

import java.util.LinkedList;

/**
 * @author rainer
 *
 */
public class Steop extends Prerequisite {

	public Steop(LinkedList<Course> lst) {
		super(lst);
	}
	
	public Steop(Course c) {
		super(c);
	}

}
