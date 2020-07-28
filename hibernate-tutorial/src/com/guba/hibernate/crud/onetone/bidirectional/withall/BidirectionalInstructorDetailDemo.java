package com.guba.hibernate.crud.onetone.bidirectional.withall;

import com.guba.hibernate.entity.Instructor;
import com.guba.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectionalInstructorDetailDemo {

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
			int theId = 3;
			InstructorDetail theInstructorDetail =
					 session.get(InstructorDetail.class, theId);

			System.out.println("Found instructor detail : " + theInstructorDetail);

			System.out.println("the associated instructor : " + theInstructorDetail.getInstructor());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

}
