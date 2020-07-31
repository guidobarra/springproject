package com.guba.hibernate.crud.manytomany;

import com.guba.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForStudentDemo {

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

			// create more courses
			Course course = new Course("OpenShift basic");
			Course course1 = new Course("Kubernetes Meddle");

			// add student to courses
			course.addStudent(student);
			course1.addStudent(student);

			// save the courses
			System.out.println("\nSaving the courses ....");

			session.save(course);
			session.save(course1);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
