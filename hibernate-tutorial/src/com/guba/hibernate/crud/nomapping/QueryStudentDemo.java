package com.guba.hibernate.crud.nomapping;

import java.util.List;

import com.guba.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		List<Student> theStudents;
		try {
			
			// start a transaction
			session.beginTransaction();
			
			theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s " +
											  "where s.firstName = 'Lucia'")
											  .getResultList();
			
			System.out.println("\n\nStudents who have first name of Lucia");
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName=Carlos OR lastName=Senboi
			theStudents = session.createQuery("from Student s " +
											  "where s.firstName = 'Carlos' OR "+
											  "s.lastName = 'Senboi'")
											  .getResultList();

			System.out.println("\n\nStudents who have lastName Carlos OR lastName Senboi");
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName=Carlos OR lastName=Senboi
			theStudents = session.createQuery("from Student s " +
											  "where s.email LIKE '%ai@gmail.com'")
											  .getResultList();
			
			System.out.println("\n\nStudents who email ends with ai.gmail.com");
			// display the students
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
