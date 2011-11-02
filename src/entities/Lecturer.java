package entities;

/**
 * The lecturer class extends the abstract person class
 * and implements method for grading students
 * 
 * @author Gruppe222 - Rainer
 */
public class Lecturer extends Person {
	// lecturer's degree
	private String degree; 
	
	/**
	 * default constructor
	 * 
	 * @param degree of the lecturer
	 * @param firstName of the lecturer
	 * @param lastName of the lecturer
	 * @param email of the lecturer
	 */
	public Lecturer(String degree, String firstName, String lastName, String email) {
		this.degree = degree;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lecturer [degree=" + degree + ", firstName=" + this.getFirstName()
				+ ", lastName=" + this.getLastName() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
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
		if (getClass() != obj.getClass())
			return false;
		Lecturer other = (Lecturer) obj;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		return true;
	}

	/**
	 * Grade student for one course with the given grade
	 * 
	 * @param st student to be graded
	 * @param cr complied course
	 * @param grade for the student
	 */
	public void gradeStudent(Student st, Course cr, GradeTypeEnum grade) {
		st.addGrade(cr, grade);
	}

}
