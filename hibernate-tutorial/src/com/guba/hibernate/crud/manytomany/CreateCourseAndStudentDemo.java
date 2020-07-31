package com.guba.hibernate.crud.manytomany;

import com.guba.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {

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

			// save the course
			System.out.println("\nSaving the course ...");
			Course tempCourse1 = new Course("Angular 9");
			Course tempCourse2 = new Course("Angular js");
			session.save(tempCourse1);
			session.save(tempCourse2);
			System.out.println("Saved the course: " + tempCourse1);
			System.out.println("Saved the course: " + tempCourse2);

			// create some Student
			Student student = new Student("Isabelle","Barra","isaBarra@gmail.com");
			Student student1 = new Student("Carlos","Edd","carlosEdd@gmail.com");
			Student student2 = new Student("Lucia","Nisekoi","luciaNisekoi@gmail.com");

			// save the course ... and leverage the cascade all :-)
			tempCourse1.addStudent(student);
			tempCourse1.addStudent(student1);
			tempCourse1.addStudent(student2);

			tempCourse2.addStudent(student1);
			tempCourse2.addStudent(student2);

			// save the students
			System.out.println("\nSaving students ...");
			session.save(student);
			session.save(student1);
			session.save(student2);
			System.out.println("Saved students: " + tempCourse1.getStudents());
			System.out.println("Saved students: " + tempCourse2.getStudents());

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
