package com.guba.hibernate.crud.manytomany;

import com.guba.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

			// get the student
			int theId = 8 ;
			Student student = session.get(Student.class, theId);

			System.out.println("\nDeleting student: " + student);

			// deleting student also register associated of table course_student
			// no deleting course
			session.delete(student);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
