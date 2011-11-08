
package service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import entities.Assessment;
import entities.Course;
import entities.Group;
import entities.Lecturer;
import entities.Message;
import entities.Student;
import entities.Person;
import entities.GradeTypeEnum;

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
	
	public void addPersonToSystem( Person p){
		this.lstPersons.add(p);
		
	}
	
	/**
	 * Delete Course from System and put it in the list deletedCourses
	 * 
	 * @param cr
	 * @throws ServiceException
	 */
	
	public void deleteCourseFromSystem(Course cr, Message m) throws ServiceException{
		
		int index = lstActiveCourses.indexOf( cr );
		if( index == -1 ) throw new ServiceException("Course "+cr.toString() + "not in the System");
	
		cr.cancelCourse(m);
		this.lstDeletedCourses.add( cr );
		this.lstActiveCourses.remove(cr);
		
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
	
	public void printAllStudentsWithMessageBox(){
	
		Iterator<Person> p = this.lstPersons.iterator();
		
		while(p.hasNext()){
			Person p1 = p.next();

			if(p1 instanceof Student){
				Student s = (Student) p1;
				System.out.println(s);
				
				System.out.println("\tMessages");
				LinkedList<Message> messages = s.getLstMessages();
				System.out.println("\t"+messages);
			}
			
		}
		
	}
	
	/**
	 * List all Course with their 
	 * Lecturer/Tutor and students 
	 */
	public void printAllCoursesWithLecturerAndStudents(){
		System.out.println("\n-----------------AllCoursesWithLecturerAndStudents----------------");

		Iterator<Course> iter = lstActiveCourses.iterator();

		while(iter.hasNext())
		{
			Course cr = iter.next();
			System.out.println( "\nTitel: "  + cr.toString() +"\t"+ "Lecturer: " + cr.getLecturer().toString());
			
			LinkedList<Student> lst_students =  cr.getAllRegisteredStudents();
			Iterator<Student> iter2 = lst_students.iterator();
	
		
			while(iter2.hasNext())
			{
				Student st = iter2.next();
				System.out.println( "\t" +  st.toString() );
				
				
			}

			
		}
	}
	public void printAllCoursesWithAll(){

		System.out.println("\n----------------------------AllCoursesWithAll----------------------");
		Iterator<Course> iter = lstActiveCourses.iterator();

		while(iter.hasNext())
		{
			Course cr = iter.next();
			System.out.println( "\nTitel: "  + cr.toString() +"\t"+ "Lecturer: " + cr.getLecturer().toString());
			
			LinkedList<Student> lstStudents =  cr.getAllRegisteredStudents();
			Iterator<Student> iter2 = lstStudents.iterator();
	
		
			while(iter2.hasNext())
			{
				Student st = iter2.next();
				System.out.println( "\t" +  st.toString() );
				
				
			}
			
			LinkedList<Assessment> lstAssessments = cr.getAllAssessments();
			Iterator<Assessment> iter3 = lstAssessments.iterator();
			
			while(iter3.hasNext())
			{
				Assessment a = iter3.next();
				System.out.println( "\t\t" +  a.toString() );
				
				LinkedList<Student> lstStudents2 = a.getLstStudents();
				Iterator<Student> iter4 = lstStudents2.iterator();
				

				while(iter4.hasNext())
				{
					Student s = iter4.next();
					System.out.println( "\t\t\t" +  s.toString() );
					
				}

				
			}		
			
		}
	}
	
	
	public void printAllCourseWithGroupsAndStudents(){
		
		System.out.println("\n----------------------------AllCoursesWithGroupsAndStudents()----------------------");
		Iterator<Course> iter = lstActiveCourses.iterator();

		while(iter.hasNext())
		{
			Course cr = iter.next();
			System.out.println( "\nTitel: "  + cr.toString() );
		 
			Iterator<Group> iter2 = cr.getGroups().iterator();
	
		
			while(iter2.hasNext())
			{
				Group g = iter2.next();
				System.out.println( "\t" +  g.toString() );
				
				Iterator<Student> iter3 = g.listAllStudents().iterator();
			
				while(iter3.hasNext())
				{
					Student s = iter3.next();
					System.out.println( "\t\t" +  s.toString() );
					
				}
			}
		}		
	}


	public void printAllStudentsWithGrades() {
		
		Iterator<Person> p = this.lstPersons.iterator();
		
		while(p.hasNext()){
			Person p1 = p.next();

			if(p1 instanceof Student){
				Student s = (Student) p1;
				System.out.println(s);
				
				System.out.println("\tGrades");
				HashMap<Course,GradeTypeEnum> grades = s.listAllGrades();//((Student) p).listAllGrades();
				System.out.println("\t"+grades);
			}
			
		}
		
	}
public void printAllLecturer(){
		
		Iterator<Person> p = this.lstPersons.iterator();
		
		while(p.hasNext()){
			Person p1 = p.next();

			if(p1 instanceof Lecturer){
				Lecturer l = (Lecturer) p1;
				System.out.println(l);
				
			}
			
		}
		
	}


}


