package com.guba.hibernate.crud.onetomany.unidirectional;

import com.guba.hibernate.entity.Course;
import com.guba.hibernate.entity.Instructor;
import com.guba.hibernate.entity.InstructorDetail;
import com.guba.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateReviewOnlyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get the course
			int theId = 11;
			Course courseUpdate = session.get(Course.class, theId);

			// print the course
			System.out.println("get Course: " + courseUpdate);

			// print the course reviews
			System.out.println("get Reviews associated: " + courseUpdate.getReviews());

			if (!courseUpdate.getReviews().isEmpty()) {
				courseUpdate.getReviews().get(1).setComment("Very Basic");
			}

			// print the course reviews
			System.out.println("Update Reviews associated: " + courseUpdate.getReviews());

			session.save(courseUpdate);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
