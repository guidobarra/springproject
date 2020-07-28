package com.guba.hibernate.crud.onetone.bidirectional.withall;

import com.guba.hibernate.entity.Instructor;
import com.guba.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();

			// get instructor by primary key / id
			int theId = 2;
			Instructor theInstructor = session.get(Instructor.class, theId);

			System.out.println("Found instructor: " + theInstructor);

			if (theInstructor != null) {
				System.out.println("Deleting: " + theInstructor);
				// Note: will ALSO delete associated "details" object
				// because of CascadeType.ALL for InstructorDetail
				session.delete(theInstructor);
			}

			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
