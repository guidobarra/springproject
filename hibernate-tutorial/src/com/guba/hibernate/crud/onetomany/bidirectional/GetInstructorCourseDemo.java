package com.guba.hibernate.crud.onetomany.bidirectional;

import com.guba.hibernate.entity.Course;
import com.guba.hibernate.entity.Instructor;
import com.guba.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourseDemo {

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
			int theId = 2;
			Instructor instructorGet = session.get(Instructor.class, theId);

			// get the instructor
			System.out.println("Get the Instructor: " + instructorGet);

			// get the Course
			System.out.println("Associate the Course: " + instructorGet.getCourses());

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
