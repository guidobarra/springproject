package com.guba.hibernate.crud.onetone.bidirectional.withoutremove;

import com.guba.hibernate.entity.Client;
import com.guba.hibernate.entity.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteClientByClientDemo {

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

			// start a transaction
			session.beginTransaction();

			// get instructor by primary key / id
			int theId = 3;
			Client client = session.get(Client.class, theId);

			System.out.println("Found client: " + client);

			System.out.println("the associated phone: " + client.getPhone());

			System.out.println("Deleting only phone: " + client.getPhone() + "\nno deleting the associated client: " + client);

			System.out.println("Deleting: " + client.getPhone());

			// remove the associated object reference
			// break bi-directional link
			//Phone phoneDelete = client.getPhone();
			//phoneDelete.setClient(null);
			client.setPhone(null);

			session.delete(client);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
