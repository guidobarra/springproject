package com.guba.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentID = 1;
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary jey
			System.out.println("\nGetting student with id: " + studentID);
			Student studentUpdate = session.get(Student.class, studentID);
			
			System.out.println("Updating student");
			studentUpdate.setFirstName("Scooby");
			
			// commit transactionX
			session.getTransaction().commit();
			
			//NEW UPDATE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students with lastName Tachira	
			System.out.println("Update email for all students with lastName Tachira");
			
			session.createQuery("update Student s " +
								"set s.email='tachira@yahoo.com' " +
								"where s.lastName='Tachira'")
								.executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
