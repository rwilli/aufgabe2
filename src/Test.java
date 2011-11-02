import java.util.Iterator;
import java.util.LinkedList;

import entities.Course;
import entities.GradeTypeEnum;
import entities.Lecturer;
import entities.Student;
import entities.Tutor;

import exception.*;

/**
 * @author Gruppe 222 - Patrick
 * 
 * Class for testing 
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/* Create Service which contains all Courses */	
		
		UniService uniService = new UniService();
		
		/* Create different Course */
		
		/**
		 * STEG includes Course 1  (StudieneingangsgesprŠch)
		 * STEOP includes Course 1 and 2  
		 * 
		 * Course1: STEG, RegDate Frame is now, maxNumOfStudents 1
		 * Course2: STEOP, RegDate Frame is now
		 * Course3: STEG and STEOP required 
		 * Course4: FirstRegDate in Future
		 */
		
		Course course1 = new Course(ID, Name, maxStudentNumber, firstRegDate, lastRegDate, lastDeRegDate, infoDate, reqSteop, reqSteg, regTyp);
	    Course course2 = new Course(ID, Name, maxStudentNumber, firstRegDate, lastRegDate, lastDeRegDate, infoDate, reqSteop, reqSteg, regTyp);
		Course course3 = new Course(ID, Name, maxStudentNumber, firstRegDate, lastRegDate, lastDeRegDate, infoDate, reqSteop, reqSteg, regTyp);
		Course course4 = new Course(ID, Name, maxStudentNumber, firstRegDate, lastRegDate, lastDeRegDate, infoDate, reqSteop, reqSteg, regTyp);
		
		/* Create Students */

		
		/**
		 * Student1 Properties: newly enrolled Student, no Course, no Assessments .. nothing
		 */
		Student student1 = new Student("1100000", "Ihave", "Nothing", "ihave@nothing.at");
		
		
		/**
		 * Student2 Properties: STEG completed
		 */
		
		Student student2 = new Student("1123456", "Patrick", "Fuerst", "patrick.fuerst@inode.at");
		student2.addGrade(course1.getTitle() +" " + GradeTypeEnum.B3);
				
		
		/** 
		 * Student3 Properties: completed STEOP and STEP
		 */
		
		Student student3 = new Student(1099993, Ihave, SteopAndSteg, steopanssteg@as.at);
		student2.addGrade(course1.getTitle() +" " + GradeTypeEnum.S1);
		student2.addGrade(course2.getTitle() +" " + GradeTypeEnum.S1);

	

	
		Student student4 = new Student(matNr, firstName, lastName, email);
		Student student5 = new Student(matNr, firstName, lastName, email);
		Student student6 = new Student(matNr, firstName, lastName, email);
		Student student7 = new Student(matNr, firstName, lastName, email);
		Student student8 = new Student(matNr, firstName, lastName, email);
		
		/* Create Tutor */
		
		Tutor tutor1 = new Tutor(matNr,firstName, lastName, email);
		Tutor tutor2 = new Tutor(matNr,firstName, lastName, email);
		Tutor tutor3 = new Tutor(matNr,firstName, lastName, email);
		Tutor tutor4 = new Tutor(matNr,firstName, lastName, email);
		
		
		/* Create Lecturer */
		
		Lecturer lecturer1 = new Lecturer(firstName, lastName, email);
		Lecturer lecturer2 = new Lecturer(firstName, lastName, email);
		Lecturer lecturer3 = new Lecturer(firstName, lastName, email);
		Lecturer lecturer4 = new Lecturer(firstName, lastName, email);
		
	    /* Set Lecturer to Course */
		
		course1.setLecturer(lecturer1);
		course2.setLecturer(lecturer2);
		course3.setLecturer(lecturer3);
		course4.setLecturer(lecturer4);
		
		
		
		
		/*
		 * Start Testing all different TestCases
		 * 
		 */
		
		
		/* ---------- Subscribe and unsubscribe testcases  ------- */

		
		/**
		 * Case1:
		 * Student1 is able to subscribe for Course1 (Steg), 
		 * but not able to subscribe course 2, because
		 * he didn«t completed STEG
		 * 
		 * Expected Output: SubscribeException, Steg not completed
		 * 
		 */
		try{
			student1.subscribe(course1);
			student1.subscribe(course2);

		}catch(SubscribeException e){
			System.out.println( e.toString() );	

		}
		
		/**
		 * Case2: 
		 * Student1 isn«t able to subscribe to Course4 because it is to early 
		 * 
		 * Expected Output: SubscribeException, Look at the RegDate
		 */
		
		try{
			student1.subscribe(course4);

		}catch(SubscribeException e){
			System.out.println( e.toString() );	

		}
		
		/**
		 * Case3:
		 * Student1 registered before for course1 is now able to deregister
		 * 		 
		 *  Expected Output: Nothing
		 */
		
		try{
			student1.unsubscribe(course1);

		}catch(SubscribeException e){
			System.out.println( e.toString() );	

		}
		
		/**
		 * Case4:
		 * Student is able to register, but isn«t able to deregister
		 */
		
		/**
		 * Case5:
		 * Student2 isn«t able to register, because maxNumber of Students is reached
		 * 
		 * Expected Output: MaxNum of Students reached
		 */
		try{
			student1.subscribe(course1);
			student2.subscribe(course1);

		}catch(SubscribeException e){
			System.out.println( e.toString() );	

		}
		
		/**
		 * Case6:
		 * Student2 isnt«able to register to course 3 because of STEOP
		 * 
		 * Expected Output: Steop not completed
		 */
		
		try{
			student2.subscribe(course1);

		}catch(SubscribeException e){
			System.out.println( e.toString() );	

		}
		
		/**
		 * Case7:
		 * Student3 is able to subscribe to course 3 
		 * 
		 * Expected Output: Nothing
		 */
		
		try{
			student3.subscribe(course3);

		}catch(SubscribeException e){
			System.out.println( e.toString() );	

		}
		
		/* Print current Status of all Courses
		 * 
		 * Expected Output:
		 * 
		 * 			Course1 contains: Student1
		 * 			Course3 contains: Student3	
		 *  
		 *  */
		
		uniService.printAllCoursesWithStudents();
		
		/* ---------- Subscribe and unsubscribe testcases finished ------- */
		
		
		
		/* Add the Courses to the Service */
		
		iService.addCourseToSystem(course1);
		iService.addCourseToSystem(course2);
		iService.addCourseToSystem(course3);
		iService.addCourseToSystem(course4);
		
		
		/* List all Course with their Lecturer/Tutor and students */
		
		LinkedList<Course> lst_courses =  iService.getAllCoursefromSystem();
		Iterator<Course> iter = lst_courses.iterator();
		
		
		
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
