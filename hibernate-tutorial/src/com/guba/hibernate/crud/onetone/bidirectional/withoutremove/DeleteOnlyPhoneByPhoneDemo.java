package com.guba.hibernate.crud.onetone.bidirectional.withoutremove;

import com.guba.hibernate.entity.Client;
import com.guba.hibernate.entity.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteOnlyPhoneByPhoneDemo {

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
			int theId = 8;
			Phone phone = session.get(Phone.class, theId);

			System.out.println("Found phone: " + phone);

			System.out.println("the associated client: " + phone.getClient());

			System.out.println("Deleting only phone: " + phone + "\n no deleting the associated client: " + phone.getClient());

			System.out.println("Deleting: " + phone);

			// remove the associated object reference
			// break bi-directional link
			Client client = phone.getClient();
			client.setPhone(null);

			session.delete(phone);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
