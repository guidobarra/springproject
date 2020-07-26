package com.guba.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentID = 4;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary jey
			System.out.println("\nGetting student with id: " + studentID);
			Student studentDelete = session.get(Student.class, studentID);
			
			System.out.println("Deliting student: " + studentID);
			session.delete(studentDelete);
			
			//NEW DELETE
			
			// update email for all students with lastName Tachira	
			System.out.println("Delete Students with email tachira@yahoo.com");
			
			session.createQuery("delete Student s " +
								"where s.email='tachira@yahoo.com'")
								.executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
