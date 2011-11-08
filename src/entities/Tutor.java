package entities;

/**
 * The tutor class extends the student class
 * 
 * @author Gruppe222 - Rainer
 */
public class Tutor extends Student {

	/**
	 * default constructor
	 * 
	 * @param matrNr student/tutor unique id
	 * @param firstName of the tutor
	 * @param lastName of the tutor
	 * @param email of the tutor
	 */
	public Tutor(String matrNr, String firstName, String lastName, String email) {
		super(matrNr, firstName, lastName, email);
	}
	
}
