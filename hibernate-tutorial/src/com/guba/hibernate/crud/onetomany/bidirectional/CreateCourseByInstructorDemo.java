package com.guba.hibernate.crud.onetomany.bidirectional;

import com.guba.hibernate.entity.Course;
import com.guba.hibernate.entity.Instructor;
import com.guba.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseByInstructorDemo {

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

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 1;
			Instructor instructorSave = session.get(Instructor.class, theId);

			// create some Courses
			Course tempCourseOne = new Course("Python with Django and Flask");
			Course tempCourseTwo = new Course("Go basic for beginner");

			// add courses to instructor
			instructorSave.add(tempCourseOne);
			instructorSave.add(tempCourseTwo);


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
