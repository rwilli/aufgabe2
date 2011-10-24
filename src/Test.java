import java.util.LinkedList;

/**
 * 
 */

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
		
		IService iService = new IService();
		
		/* Create different Course */
		
		Course course1 = new Course(ID, Name, maxStudentNumber, firstRegDate, lastRegDate, lastDeRegDate, infoDate, reqSteop, reqStep, regTyp).
	    Course course2 = new Course(ID, Name, maxStudentNumber, firstRegDate, lastRegDate, lastDeRegDate, infoDate, reqSteop, reqStep, regTyp).
		Course course3 = new Course(ID, Name, maxStudentNumber, firstRegDate, lastRegDate, lastDeRegDate, infoDate, reqSteop, reqStep, regTyp).
		Course course4 = new Course(ID, Name, maxStudentNumber, firstRegDate, lastRegDate, lastDeRegDate, infoDate, reqSteop, reqStep, regTyp).
		
		/* Create Students */

		
		/**
		 * Student1 Properties: newly enrolled Student, no Course, no Assessments .. nothing
		 */
		Student student1 = new Student(matNr, firstName, lastName, email);
		
		
		/**
		 * Student2 Properties: some Assessments, but not completed STEOP or STEP
		 */
		
		Student student2 = new Student(matNr, firstName, lastName, email);
		
		//TODO add Assesments to Student2
		
		
		/** 
		 * Student3 Properties: completed STEOP, but not STEP 
		 */
		
		Student student3 = new Student(matNr, firstName, lastName, email);
		
		//TODO add Assesments to Student3

		
		/** 
		 * Student4 Properties: completed STEOP and STEP
		 */
		Student student4 = new Student(matNr, firstName, lastName, email);
		
		//TODO add Assesments to Student4

		
		
		Student student5 = new Student(matNr, firstName, lastName, email);
		Student student6 = new Student(matNr, firstName, lastName, email);
		Student student7 = new Student(matNr, firstName, lastName, email);
		Student student8 = new Student(matNr, firstName, lastName, email);
		
		/* Create Tutor */
		
		Tutor tutor1 = new Tutor(firstName, lastName, email);
		Tutor tutor2 = new Tutor(firstName, lastName, email);
		Tutor tutor3 = new Tutor(firstName, lastName, email);
		Tutor tutor4 = new Tutor(firstName, lastName, email);
		
		
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
		
		/**
		 * Case1:
		 * Student is able to register for Course
		 */
		
		/**
		 * Case2: 
		 * Student isn«t able to register because it is to early 
		 */
		
		/**
		 * Case3:
		 * Student is able to register, and is able to deregister
		 * 
		 */
		
		/**
		 * Case4:
		 * Student is able to register, but isn«t able to deregister
		 */
		
		/**
		 * Case6:
		 * Student isn«t able to register, because maxNumber of Students is reached
		 */
		
		/**
		 * Case6:
		 * Student isnt«able to register because of STEOP
		 */
		
		/**
		 * Case7:
		 * Student isnt«t able to register because of STEP
		 */
		
		
		
//		course1.addStudent( student1 );
//		course1.addStudent( student2 );
//		course1.addStudent( student3 );	
//		course1.addStudent( student4 );
//
//		course2.addStudent( student1 );
//		course2.addStudent( student2 );
//		course2.addStudent( student3 );	
//		course2.addStudent( student4 );
//		
//		course3.addStudent( student1 );
//		course3.addStudent( student2 );
//		course3.addStudent( student3 );	
//		course3.addStudent( student4 );
//		
//		course4.addStudent( student1 );
//		course4.addStudent( student2 );
//		course4.addStudent( student3 );	
//		course4.addStudent( student4 );
		
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
