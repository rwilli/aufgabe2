
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import entities.Assessment;
import entities.Course;
import entities.DisposalExam;
import entities.GradeTypeEnum;
import entities.Group;
import entities.Lecturer;
import entities.Message;
import entities.Prerequisite;
import entities.SpokenExam;
import entities.Steg;
import entities.Steop;
import entities.Student;
import entities.Tutor;

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
		 * Course2: STEOP, RegDate Frame is now, maxNumOfStudents 3, STEG required
		 * Course3: STEG and STEOP required ,RegDate Frame is now, maxNumOfStudents 10
		 * Course4: FirstRegDate in Future,STEG and STEOP required
		 * Course5: to simulate Case4, deRegDate is set in past. 
		 * Course6: Group, RegDate Frame is now, maxNumOfStudents 3, to simulate with groups
		 * 			maxNumOfStudents is set to 3 because all groupse can take 3 students. 
		 */
		Course course1,course2,course3,course4,course5,course6;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LinkedList<Prerequisite> lstPrerequisite1 = new LinkedList<Prerequisite>();		
		LinkedList<Prerequisite> lstPrerequisite2 = new LinkedList<Prerequisite>();
		
		try{
			

			course1 = new Course( "LVA_STEG", 1 , sdf.parse("2011-11-2"), sdf.parse("2012-11-2"),
											sdf.parse("2012-11-2"));
			
			lstPrerequisite1.add(new Steg(course1));
			course2 = new Course( "LVA_STEOP", 3 , sdf.parse("2011-11-2"), sdf.parse("2012-11-2"),
											sdf.parse("2012-11-2"), lstPrerequisite1);
		
			lstPrerequisite2.add(new Steg(course1));
			lstPrerequisite2.add(new Steop(course2));
			course3 = new Course( "LVA_STEGSTEOP", 10 , sdf.parse("2011-11-2"), sdf.parse("2012-11-2"),
											sdf.parse("2012-11-2"), lstPrerequisite2);
		
			
			course4 = new Course( "LVA_STEG", 1 , sdf.parse("2012-11-2"), sdf.parse("2012-11-10"),
											sdf.parse("2012-11-10"),lstPrerequisite1);
			
			course5 = new Course( "LVA_STARTED", 1 , sdf.parse("2011-11-2"), sdf.parse("2012-11-10"),
					sdf.parse("2011-11-1"));
			
			course6 = new Course( "LVA_GROUPS", 3 , sdf.parse("2011-11-2"), sdf.parse("2012-11-2"),
					sdf.parse("2012-11-2"));
	
		
	
		/* Create Students */

		
		/**
		 * Student1 Properties: newly enrolled Student, no Course, no Assessments .. nothing
		 */
		Student student1 = new Student("1100000", "Student1", "Nothing", "ihave@nothing.at");
		
		
		/**
		 * Student2 Properties: STEG completed
		 */
		
		Student student2 = new Student("1123456", "Student2", "Fuerst", "patrick.fuerst@inode.at");
		student2.addGrade(course1, GradeTypeEnum.B3);
		
		/** 
		 * Student3 Properties: completed STEOP and STEP
		 */
		Student student3 = new Student("1099993", "Student3", "SteogAndSteg", "steopanssteg@as.at");
		student3.addGrade(course1, GradeTypeEnum.S1);
		student3.addGrade(course2, GradeTypeEnum.S1);
		
		/* Add the Students to the System */
		
		uniService.addPersonToSystem(student1);
		uniService.addPersonToSystem(student2);
		uniService.addPersonToSystem(student3);

		
		/* Create Tutor */
		
		Tutor tutor1 = new Tutor("0345334","Tutor1", "Adam", "asd@sa.sa");
		Tutor tutor2 = new Tutor("0567555","Tutor2", "Peter", "sdf@sa.sa");

	
		/* Add tutor to the system */
		uniService.addPersonToSystem(tutor1);
		uniService.addPersonToSystem(tutor2);

		
		/* Create Lecturer */
		
		Lecturer lecturer1 = new Lecturer("Dr","Peter", "Pan", "peter@pan.at");
		Lecturer lecturer2 = new Lecturer("Prof","Julian", "Potter", "julian@potter.at");
		Lecturer lecturer3 = new Lecturer("Prof.Assist","Kale", "Pot", "Kale@pot.at");
		Lecturer lecturer4 = new Lecturer("Dr","Moritz", "Hossen", "Moritz@hossen.at");
		
		/* Add the Lecturer to the System */
		uniService.addPersonToSystem(lecturer1);
		uniService.addPersonToSystem(lecturer2);
		uniService.addPersonToSystem(lecturer3);
		uniService.addPersonToSystem(lecturer4);

		
	    /* Set Lecturer to Course */
		
		course1.setLecturer(lecturer1);
		course2.setLecturer(lecturer2);
		course3.setLecturer(lecturer3);
		course4.setLecturer(lecturer4);
		course5.setLecturer(lecturer4);
		course6.setLecturer(lecturer2);
		
		/* Add the Courses to the Service */
		
		uniService.addCourseToSystem(course1);
		uniService.addCourseToSystem(course2);
		uniService.addCourseToSystem(course3);
		uniService.addCourseToSystem(course4);
		uniService.addCourseToSystem(course5);
		uniService.addCourseToSystem(course6);
		
		/*
		 * Start Testing all different TestCases
		 * 
		 */
		
		
		/* ---------Testcase: Subscribe and unsubscribe for courses   ------- */

		
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
		 * Student3 is able to register, but isn«t able to deregister
		 * 
		 * Expected Output: Deregistration expired
		 */
		try{
			student3.subscribe(course5);
			student3.unsubscribe(course5);
			
		}catch(SubscribeException e){
			System.out.println("Case4\t"+ e.toString() );	

		}
		catch(UnsubscribeException e){
			System.out.println("Case4\t"+ e.toString() );	

		}
		
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
		 * Expected Output:  Required Steop not completed
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
		
		/**
		 * Case8:
		 * Student 1 is not able to register to course1, because he is already attending it.
		 * 
		 * Expected Output: Student already attending this Course
		 */
		
		try{
			student1.subscribe(course1);

		}catch(SubscribeException e){
			System.out.println("Case8\t"+ e.toString() );	

		}
		
		/**
		 * Case8.5:
		 * Register a Tutor to a course
		 * 
		 * Expected Output: nothing
		 */
		
		try{
			tutor1.subscribe(course6);

		}catch(SubscribeException e){
			System.out.println("Case8.5\t"+ e.toString() );	

		}
		/* Print current Status of all Courses
		 * 
		 * Expected Output: All Courses and 
		 * 
		 * 			Course1 contains: Student1
		 * 			Course3 contains: Student3	
		 * 			Course5 contains: Student3
		 * 			Course6 contains: Tutor3
		 *  
		 *  */
		
		uniService.printAllCoursesWithLecturerAndStudents();
		
		/* ---------- Subscribe and unsubscribe testcases finished ------- */
		
	
		
		/* ---------- Start Test: Cancel a Course with more Students ------- */
		
		/**
		 * Case9:
		 * Add more Students to Course2 and cancel it. 
		 * 
		 * Expected Output: Email send to student2 and 3
		 */
		
		try{
			student2.subscribe(course2);
			student3.subscribe(course2);
			//TODO wie erscheint Message: Email send to
			uniService.deleteCourseFromSystem(course2, new Message("Course2 canceled!") );
			
			course2.cancelCourse(new Message("Course2 canceled!"));

		}catch(SubscribeException e){
			System.out.println("Case9\t"+ e.toString() );	

		} catch (ServiceException e) {
			System.out.println("Case9\t"+ e.toString() );	
			
		}
		
		/* ---------- End Test: Cancel a Course with more Students ------- */
		
		
		/* ---------- Start Test: Subscribe and unsubscribe for Assessments ------- */
		Assessment assessment1,assessment2;
		
		/**
		 * Assessment1 belongs to Course1
		 */
		assessment1 = new DisposalExam( "DisposalExam", 2 , sdf.parse("2011-11-20"), sdf.parse("2011-11-2"),
				sdf.parse("2011-11-19"),
				sdf.parse("2012-11-19"));
		
		/**
		 * Assessment2 belongs to Course1
		 */
		assessment2 = new SpokenExam( "SpokenExam", 1 , sdf.parse("2011-11-20"), sdf.parse("2011-11-2"),
				sdf.parse("2011-11-19"),
				sdf.parse("2012-11-19"));
		
		course1.addAssessment(assessment1);
		course1.addAssessment(assessment2);
		
		/**
		 * Case10:
		 * Student1 and Student 2 are able to subscribe for Assessment1,
		 * and Student3 to Assessment2, but  
		 * Student3 isn«t able to subscribe for Assessment1, 
		 * because course is full.
		 * 
		 * Expected Output: Course full
		 * 
		 */
		try{
			student1.subscribe(assessment1);
			student2.subscribe(assessment1);
			student3.subscribe(assessment2);
			student3.subscribe(assessment1);
		}catch(SubscribeException e){
			System.out.println( "Case10\t" +e.toString() );	

		}
		
		/* ---------- End Test: Subscribe and unsubscribe for Assessments ------- */

	
		/* Print current Status of all Courses
		 * 
		 * Expected Output: All Courses except Course 2, because it is canceled  and 
		 * 
		 * 			Course1 contains: Student1
		 * 					Assessment1 : 
		 * 								Student1, Student2
		 * 					Assessment2 : 
		 * 								Student3
		 * 			Course3 contains: Student3	
		 * 			Course5 contains: Student3
		 * 			Course6 contains: Tutor1
		 *  
		 *  */
		
		uniService.printAllCoursesWithAll();
		
		
		/* List all students with grades
		 * 
		 * Expected Output: 
		 * 					Student1:nothing
		 * 					Student2: Steg = 3
		 * 					Student3: Steop = 1 Steg = 1
		 * 					Tutor1: nothing
		 * 					Tutor2: nothin
		 *  */

		uniService.printAllStudentsWithGrades();
		
	
		
		/* ---------- Start Test: Subscribe to a Course with automatically join a group ------- */

		
		/*Create Groups */
		
		Group groupe1 = new Group(1,"Groupe1",1,tutor1 );
		Group groupe2 = new Group(2,"Groupe2",1,tutor2 );
		
		/* Add Groups to Course6 */
		
		course6.addGroup(groupe1);
		course6.addGroup(groupe2);
		
		/**
		 * Case11:
		 * Student1 can subscribe to course6/group1
		 * 
		 * Expected Output:nothing
		 * 
		 */
		try{
			student1.subscribe(course6);
			
		}catch(SubscribeException e){
			System.out.println( "Case11\t" +e.toString() );	

		}
		
		/**
		 * Case12:
		 * Student2 can subscribe to course6/group2
		 * Because Groupe1 is full it takes Groupe2
		 * 
		 * Expected Output:nothing
		 * 
		 */
		try{
			student2.subscribe(course6);
			
		}catch(SubscribeException e){
			System.out.println( "Case12\t" +e.toString() );	

		}
		/**
		 * Case13:
		 * Student3 can«t subscribe to course6/group1 or 2
		 * Because Groupe1 and 2  are full
		 * 
		 * Expected Output: All Groups are full
		 * 
		 */
		try{
			student3.subscribe(course6);
			
		}catch(SubscribeException e){
			System.out.println( "Case13\t" +e.toString() );	

		}
		
		
		/* List all courses with groups and students
		 * 
		 * Expected Output: 
		 * 			all courses except course2 because it was canceled and course6 has:
		 * 
		 * 			Group1 with Student1 and
		 * 			Group2 with Student2
		 *  */
		
		uniService.printAllCourseWithGroupsAndStudents();
		
		}catch(ParseException e){

			e.printStackTrace();

			}
		
	}
	

}
