package com.guba.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create a student object
			System.out.println("Creating new student object");
			Student studentSave = new Student("Maiko", "Senboi", "maikoSenboi@gamil.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student");
			session.save(studentSave);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + studentSave.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student bases on the id: primary key
			System.out.println("\nGetting student with id: " + studentSave.getId());
			
			Student studentGet = session.get(Student.class, studentSave.getId());
			
			System.out.println("Get complete: " + studentGet);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
