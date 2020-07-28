package com.guba.hibernate.crud.onetone.bidirectional.withall;

import com.guba.hibernate.entity.Instructor;
import com.guba.hibernate.entity.InstructorDetail;
import com.guba.hibernate.entity.Phone;
import com.guba.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Instructor.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
						
			// create a student object
			System.out.println("Creating new Instructor object");
			Instructor thInstructor =
					new Instructor("Wanda", "Gimenez", "wandaGimenez@gmail.com");
			InstructorDetail theInstructorDetail =
					new InstructorDetail("http://www.wanda.com/youtube", "Goland Code");

			// associate the objects
			thInstructor.setInstructorDetail(theInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			System.out.println("Saving the Instructor");
			session.save(thInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
