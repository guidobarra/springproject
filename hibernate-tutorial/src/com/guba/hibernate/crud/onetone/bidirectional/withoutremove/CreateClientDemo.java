package com.guba.hibernate.crud.onetone.bidirectional.withoutremove;

import com.guba.hibernate.entity.Client;
import com.guba.hibernate.entity.Instructor;
import com.guba.hibernate.entity.InstructorDetail;
import com.guba.hibernate.entity.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateClientDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Client.class)
								 .addAnnotatedClass(Phone.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
						
			// create a student object
			System.out.println("Creating new student object");
			Client client =
					new Client("Lucia", "Tamachiro", "luciaTamachiro@gmail.com");
			Phone phone =
					new Phone(1132464788, "Movistar");

			// associate the objects
			client.setPhone(phone);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			System.out.println("Saving the Instructor");
			session.save(client);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
