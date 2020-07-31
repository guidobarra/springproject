package com.guba.hibernate.crud.manytomany;

import com.guba.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();

			// get the course
			int theId = 19 ;
			Course course = session.get(Course.class, theId);

			System.out.println("\nDeleting course: " + course);

			// deleting course also register associated of table course_student
			// no deleting student
			session.delete(course);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
