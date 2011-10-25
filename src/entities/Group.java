package entities;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Gruppe222 - Rainer
 */
public class Group {
	private int id;
	private String name;
	private int maxGroupSize;
	private Tutor tutor;
	private List<Student> lst_students;
	
	public Group(int id, String name, int size) {
		this.id = id;
		this.name = name;
		this.maxGroupSize = size;
		//this.tutor = new Tutor() ??
		this.lst_students = new LinkedList<Student>();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the maxGroupSize
	 */
	public int getMaxGroupSize() {
		return maxGroupSize;
	}

	/**
	 * @param maxGroupSize the maxGroupSize to set
	 */
	public void setMaxGroupSize(int maxGroupSize) {
		this.maxGroupSize = maxGroupSize;
	}

	/**
	 * @return the tutor
	 */
	public Tutor getTutor() {
		return tutor;
	}

	/**
	 * @param tutor the tutor to set
	 */
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	/**
	 * @return the lst_students
	 */
	public List<Student> getLst_students() {
		return lst_students;
	}

	/**
	 * @param lst_students the lst_students to set
	 */
	public void setLst_students(List<Student> lst_students) {
		this.lst_students = lst_students;
	}

}
