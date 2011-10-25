package entities;

/**
 * The lecturer class extends the abstract person class
 * and implements method for grading students
 * 
 * @author Gruppe222 - Rainer
 */
public class Lecturer extends Person {
	
	/**
	 * default constructor
	 */
	public Lecturer() {
		
	}
	
	/**
	 * Grade student for one course with the given grade
	 * 
	 * @param st student to be graded
	 * @param grade for the student
	 */
	public void gradeStudent(Student st, String grade) {
		st.addGrade(grade);
	}

}
