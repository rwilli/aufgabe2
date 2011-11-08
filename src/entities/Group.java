package entities;

import java.util.LinkedList;
import java.util.List;

/**
 * The class group stands for a group of students.
 * 
 * @author Gruppe222 - Rainer
 */
public class Group {
	// group id
	private int id;
	
	// name of the group
	private String name;
	
	// maximum group size
	private int maxGroupSize;
	
	// given tutor for the group
	private Tutor tutor;
	
	// list of students, that belong to the group
	private List<Student> lst_students;
	
	/**
	 * default constructor
	 * 
	 * @param id of the group
	 * @param name of the group 
	 * @param size maximum student size of the group
	 * @param tu tutor of the group
	 */
	public Group(int id, String name, int size, Tutor tu) {
		this.id = id;
		this.name = name;
		this.maxGroupSize = size;
		this.lst_students = new LinkedList<Student>();
		this.tutor = tu;
	}

	/**
	 * Getter maxGroupSize
	 * 
	 * @return the maxGroupSize
	 */
	public int getMaxGroupSize() {
		return maxGroupSize;
	}

	/**
	 * Setter maxGroupSize
	 * 
	 * @param maxGroupSize the maxGroupSize to set
	 */
	public void setMaxGroupSize(int maxGroupSize) {
		this.maxGroupSize = maxGroupSize;
	}

	/**
	 * @param tutor the tutor to set
	 */
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "id= " +this.id + "\t" + this.name;
	}
	
	/**
	 * List responsible tutor
	 * 
	 * @return the tutor
	 */
	public String listTutor() {
		return this.tutor.getFirstName() + " " + this.tutor.getLastName();
	}

	/**
	 * List all students of this group
	 * 
	 * @return the lst_students
	 */
	public List<Student> listAllStudents() {
		return lst_students;
	}
	
	/**
	 * Get number of students attending Course
	 */
	public int getStudentNumber(){
		return this.lst_students.size();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((lst_students == null) ? 0 : lst_students.hashCode());
		result = prime * result + maxGroupSize;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tutor == null) ? 0 : tutor.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Group))
			return false;
		Group other = (Group) obj;
		if (id != other.id)
			return false;
		if (lst_students == null) {
			if (other.lst_students != null)
				return false;
		} else if (!lst_students.equals(other.lst_students))
			return false;
		if (maxGroupSize != other.maxGroupSize)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tutor == null) {
			if (other.tutor != null)
				return false;
		} else if (!tutor.equals(other.tutor))
			return false;
		return true;
	}

}
