
package service;

import java.util.Iterator;
import java.util.LinkedList;

import entities.Course;
import entities.Student;
import entities.Person;

import exception.ServiceException;

/**
 * Class for administration
 * 
 * @author Gruppe222 - Patrick
 */

public class UniService {


	LinkedList<Course> lstActiveCourses;
	LinkedList<Course> lstDeletedCourses; 
	LinkedList<Person> lstPersons;
	
	public UniService() {
		
		/* sollten hier vlt was anderes wie LinkedList verwenden */
		
		this.lstActiveCourses = new LinkedList<Course>();
		this.lstDeletedCourses = new LinkedList<Course>();
		this.lstPersons = new LinkedList<Person>();
	
	}


	/**
	 * Add Course to System
	 * 
	 * @param cr
	 */
	public void addCourseToSystem(Course cr){
		this.lstActiveCourses.add(cr);
	}
	
	/**
	 * Delete Course from System and put it in the list deletedCourses
	 * 
	 * @param cr
	 * @throws ServiceException
	 */
	
	public void deleteCourseFromSystem(Course cr) throws ServiceException{
		
		int index = lstActiveCourses.indexOf( cr );
		if( index == -1 ) throw new ServiceException("Course "+cr.toString() + "not in the System");
		
		/* Weitere Exception handling? */
		
		this.lstDeletedCourses.add( lstActiveCourses.get( index ) );
		
		lstActiveCourses.remove(cr);
		
	}
	
	/**
	 * Restore course to System
	 * 
	 * @param cr
	 * @throws ServiceException
	 */
	
	public void restoreCourseToSystem(Course cr) throws ServiceException{
		
		int index = lstDeletedCourses.indexOf( cr );
		if( index == -1 ) throw new ServiceException("Course "+cr.toString() + "not in the DeleteList");
		
		/* Weitere Exception handling? */
		
		this.lstActiveCourses.add( lstDeletedCourses.get( index ) );
		
		lstDeletedCourses.remove(cr);
		
		
	}
	
	/**
	 * List all Course with their 
	 * Lecturer/Tutor and students 
	 */
	
	public void printAllCoursesWithLecturerAndStudents(){

		Iterator<Course> iter = lstActiveCourses.iterator();

		while(iter.hasNext())
		{
			Course cr = iter.next();
			System.out.println( "Titel: "  + cr.toString() +"\t"+ "Lecturer: " + cr.getLecturer().toString());
			
			LinkedList<Student> lst_students =  cr.getAllRegisteredStudents();
			Iterator<Student> iter2 = lst_students.iterator();
	
		
			while(iter2.hasNext())
			{
				Student st = iter2.next();
				System.out.println( "\t" +  st.toString() );
				
				
			}
			
			// TODO List Tutors? 
		
			
		}
	}

}


