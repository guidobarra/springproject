package com.guba.hibernate.crud.onetomany;

import com.guba.hibernate.entity.Course;
import com.guba.hibernate.entity.Instructor;
import com.guba.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorCourseDemo {

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
			int theId = 10;
			Course courseDelete = session.get(Course.class, theId);

			// delete the Course
			System.out.println("Delete the Course: " + courseDelete);

			session.delete(courseDelete);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
