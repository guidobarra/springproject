package com.guba.hibernate.crud.lazyvseager;

import com.guba.hibernate.entity.Course;
import com.guba.hibernate.entity.Instructor;
import com.guba.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class LazyCloseSessionErrorSolutionTwoDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 4;

			// solution option Two: query HQL
			Query<Instructor> query =
					session.createQuery("select i from Instructor i " +
										   "JOIN FETCH i.courses " +
										   "where i.id=:theInstructorId", Instructor.class);

			// set parameter on query
			query.setParameter("theInstructorId", theId);

			// execute query and get instructor
			Instructor instructorGet = query.getSingleResult();

			// commit transaction
			session.getTransaction().commit();

			// close session
			session.close();

			System.out.println("\nThe session is now closed\n");

			// get the Course Associated, with LAZY call db ERROR session close: LazyCloseSessionErrorDemo.java:43
			System.out.println("\nAssociate the Course: " + instructorGet.getCourses());

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}

// NOTA CURIOSA: Cuando nosotros utilizamos el modo debugger en Eclipse, Intellij para ver la variable "instructorGet",
// 		 nos fijamos las lista de cources, y automaticamente llama a la base de datos y trae la lista.
// 		 la llamada a la base de datos tambien se hace cuando se utiliza el metddo getCourses o mas generico
//		 cuando alguien utiliza la varible "cources" que es un atributo de "Instructor".