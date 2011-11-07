
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import entities.Course;
import entities.GradeTypeEnum;
import entities.Lecturer;
import entities.Prerequisite;
import entities.Steg;
import entities.Steop;
import entities.Student;

import service.UniService;

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
		 * Course2: STEOP, RegDate Frame is now, maxNumOfStudents 3
		 * Course3: STEG and STEOP required ,RegDate Frame is now, maxNumOfStudents 10
		 * Course4: FirstRegDate in Future,STEG and STEOP required
		 */
		Course course1,course2,course3,course4;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LinkedList<Prerequisite> lstPrerequisite1 = new LinkedList<Prerequisite>();
		LinkedList<Course> lst1 = new LinkedList<Course>();
		
		try{
			

			course1 = new Course( "LVA_STEG", 1 , sdf.parse("2011-11-2"), sdf.parse("2012-11-2"),
											sdf.parse("2012-11-2"));
			course2 = new Course( "LVA_STEOP", 3 , sdf.parse("2011-11-2"), sdf.parse("2012-11-2"),
											sdf.parse("2012-11-2"));
			lstPrerequisite1.add(new Steg(course1));
			lstPrerequisite1.add(new Steop(course2));
			course3 = new Course( "LVA_REQ_STEG_AND_STEOP", 10 , sdf.parse("2011-11-2"), sdf.parse("2012-11-2"),
											sdf.parse("2012-11-2"), lstPrerequisite1);
			course4 = new Course( "LVA_STEG", 1 , sdf.parse("2012-11-2"), sdf.parse("2012-11-10"),
											sdf.parse("2012-11-10"));
		
	
		
	
		/* Create Students */

		
		/**
		 * Student1 Properties: newly enrolled Student, no Course, no Assessments .. nothing
		 */
		Student student1 = new Student("1100000", "Ihave", "Nothing", "ihave@nothing.at");
		
		
		/**
		 * Student2 Properties: STEG completed
		 */
		/* TODO set STEG and STEOP automatically */
		
		Student student2 = new Student("1123456", "Patrick", "Fuerst", "patrick.fuerst@inode.at");
		student2.addGrade(course1, GradeTypeEnum.B3);
		//student2.setHasSteg(true);
		
		/** 
		 * Student3 Properties: completed STEOP and STEP
		 */
		/* TODO set STEG and STEOP automatically */
		Student student3 = new Student("1099993", "Ihave", "SteogAndSteg", "steopanssteg@as.at");
		student3.addGrade(course1, GradeTypeEnum.S1);
		student3.addGrade(course2, GradeTypeEnum.S1);
		//student3.setHasSteg(true);
		//student3.setHasSteop(true);

	

//	
//		Student student4 = new Student(matNr, firstName, lastName, email);
//		Student student5 = new Student(matNr, firstName, lastName, email);
//		Student student6 = new Student(matNr, firstName, lastName, email);
//		Student student7 = new Student(matNr, firstName, lastName, email);
//		Student student8 = new Student(matNr, firstName, lastName, email);
		
		/* Create Tutor */
//		
//		Tutor tutor1 = new Tutor(matNr,firstName, lastName, email);
//		Tutor tutor2 = new Tutor(matNr,firstName, lastName, email);
//		Tutor tutor3 = new Tutor(matNr,firstName, lastName, email);
//		Tutor tutor4 = new Tutor(matNr,firstName, lastName, email);
		
		
		/* Create Lecturer */
		
		Lecturer lecturer1 = new Lecturer("Dr","Peter", "Pan", "peter@pan.at");
		Lecturer lecturer2 = new Lecturer("Prof","Julian", "Potter", "julian@potter.at");
		Lecturer lecturer3 = new Lecturer("Prof.Assist","Kale", "Pot", "Kale@pot.at");
		Lecturer lecturer4 = new Lecturer("Dr","Moritz", "Hossen", "Moritz@hossen.at");
		
	    /* Set Lecturer to Course */
		
		course1.setLecturer(lecturer1);
		course2.setLecturer(lecturer2);
		course3.setLecturer(lecturer3);
		course4.setLecturer(lecturer4);
		
		/* Add the Courses to the Service */
		
		uniService.addCourseToSystem(course1);
		uniService.addCourseToSystem(course2);
		uniService.addCourseToSystem(course3);
		uniService.addCourseToSystem(course4);
		
		
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
		 * Expected Output: SubscribeException: Required Steg not complied
		 * 
		 */
		try{
			student1.subscribe(course1);
			student1.subscribe(course2);

		}catch(SubscribeException e){
			System.out.println( "Case1\t" +e.toString() );	

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
			System.out.println("Case2\t"+ e.toString() );	

		}
		
		/**
		 * Case3:
		 * Student1 registered before for course1 is now able to deregister
		 * 		 
		 *  Expected Output: Nothing
		 */
		
		try{
			student1.unsubscribe(course1);

		}catch(UnsubscribeException e){
			System.out.println("Case3\t"+ e.toString() );	

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
			System.out.println("Case5\t"+ e.toString() );	

		}
		
		/**
		 * Case6:
		 * Student2 isnt«able to register to course 3 because of STEOP
		 * 
		 * Expected Output:  Required Steg not completed
		 */
		
		try{
			student2.subscribe(course3);

		}catch(SubscribeException e){
			System.out.println("Case6\t"+ e.toString() );	

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
			System.out.println("Case7\t"+ e.toString() );	

		}
		
		/* Print current Status of all Courses
		 * 
		 * Expected Output: All Courses and 
		 * 
		 * 			Course1 contains: Student1
		 * 			Course3 contains: Student3	
		 *  
		 *  */
		
		uniService.printAllCoursesWithLecturerAndStudents();
		
		/* ---------- Subscribe and unsubscribe testcases finished ------- */
		
		
		
	}catch(ParseException e){
			
			e.printStackTrace();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		


	}

}
