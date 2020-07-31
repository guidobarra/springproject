package com.guba.hibernate.crud.manytomany;

import com.guba.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateCoursesAndStudentDemo {

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
			int theId = 10;
			Student student = session.get(Student.class, theId);

			System.out.println("\nLoaded student: " + student);
			System.out.println("\nCourses: " + student.getCourses());

			student.setLastName("Maito");
			student.setFirstName("Gay");

			if (!student.getCourses().isEmpty()) {
				Course course = student.getCourses().get(0);
				course.setTitle("Angular 9");
			}
			session.save(student);
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
