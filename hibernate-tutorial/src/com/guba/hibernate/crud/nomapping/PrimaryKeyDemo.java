package com.guba.hibernate.crud.nomapping;

import com.guba.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

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
			Student student1 = new Student("Lucia", "Tachira", "luciasTachira@gmail.com");
			Student student2 = new Student("Carlos", "Tachibana", "carlosTachibana@gmail.com");
			Student student3 = new Student("Maria", "Sekai", "mariaSekai@gmail.com");
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the trhee student");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
