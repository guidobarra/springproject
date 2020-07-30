package com.guba.hibernate.crud.onetomany;

import com.guba.hibernate.entity.Course;
import com.guba.hibernate.entity.Instructor;
import com.guba.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorCourseDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
						
			// create a Instructor object
			System.out.println("Creating new Instructor object");
			Instructor thInstructor =
					new Instructor("Lucas", "Tachibana", "LucasTachibana@gmail.com");
			InstructorDetail theInstructorDetail =
					new InstructorDetail("http://www.guba.com/youtube", "Goland Code");

			// create some Courses
			Course tempCourseOne = new Course("Java with Spring and Hibernate");
			Course tempCourseTwo = new Course("Node basic for beginner");

			// add courses to instructor
			thInstructor.add(tempCourseOne);
			thInstructor.add(tempCourseTwo);

			// associate the objects
			thInstructor.setInstructorDetail(theInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			// Note: this will ALSO save the details object
			// Note: this will NOT save the courses object
			// because of CascadeType.ALL
			System.out.println("Saving the Instructor");
			session.save(thInstructor);

			// save the courses object
			System.out.println("Saving the Courses");
			session.save(tempCourseOne);
			session.save(tempCourseTwo);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
