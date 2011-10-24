/**
 * 
 */

/**
 * @author Gruppe 222
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

		Student student1 = new Student(matNr, firstName, lastName, email);
		Student student2 = new Student(matNr, firstName, lastName, email);
		Student student3 = new Student(matNr, firstName, lastName, email);
		Student student4 = new Student(matNr, firstName, lastName, email);
		Student student5 = new Student(matNr, firstName, lastName, email);
		Student student6 = new Student(matNr, firstName, lastName, email);
		Student student7 = new Student(matNr, firstName, lastName, email);
		Student student8 = new Student(matNr, firstName, lastName, email);
		
		/* Create Lecturer */
		
		Lecturer lecturer1 = new Lecturer(firstName, lastName, email);
		Lecturer lecturer2 = new Lecturer(firstName, lastName, email);
		Lecturer lecturer3 = new Lecturer(firstName, lastName, email);
		Lecturer lecturer4 = new Lecturer(firstName, lastName, email);
		
	    /* Add Lecturer to Course */
		
		
		
		/* Add Students to Courses */
		
		/* TODO Handle Exception throwed because student unfulfilled STEP or STEOP */
		
		
		course1.addStudent( student1 );
		course1.addStudent( student2 );
		course1.addStudent( student3 );	
		course1.addStudent( student4 );

		course2.addStudent( student1 );
		course2.addStudent( student2 );
		course2.addStudent( student3 );	
		course2.addStudent( student4 );
		
		course3.addStudent( student1 );
		course3.addStudent( student2 );
		course3.addStudent( student3 );	
		course3.addStudent( student4 );
		
		course4.addStudent( student1 );
		course4.addStudent( student2 );
		course4.addStudent( student3 );	
		course4.addStudent( student4 );
		
		/* Add the Courses to the Service */
		
		iService.addCourseToSystem(course1);
		iService.addCourseToSystem(course2);
		iService.addCourseToSystem(course3);
		iService.addCourseToSystem(course4);
		
		
		
		
		
		


	}

}
