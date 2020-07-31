package com.guba.hibernate.crud.onetomany.unidirectional;

import com.guba.hibernate.entity.Course;
import com.guba.hibernate.entity.Instructor;
import com.guba.hibernate.entity.InstructorDetail;
import com.guba.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {

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

			// create some Course
			Course tempCourse = new Course("Angular 8");

			// create some Review
			tempCourse.addReview(new Review("Great course ... loved it!"));
			tempCourse.addReview(new Review("Cool course, job well done"));
			tempCourse.addReview(new Review("Great course ... loved it!"));

			// save the course ... and leverage the cascade all :-)
			System.out.println("Saving the course");
			System.out.println("Course: " + tempCourse);
			System.out.println("Reviews: " + tempCourse.getReviews());

			session.save(tempCourse);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
