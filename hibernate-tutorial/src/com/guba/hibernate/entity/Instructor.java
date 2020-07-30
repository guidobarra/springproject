package com.guba.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    //@OneToOne(cascade= {CascadeType.DETACH, Si la entidad está separada (no asociada con sesión), entonces la entidad relacionada también será separada
    //                    CascadeType.MERGE, Si la entidad se fusiona, la entidad relacionada también se fusionará.
    //                    CascadeType.PERSIST, Si la entidad se conserva / guarda, la entidad relacionada y relacionada también se conservará
    //                    CascadeType.REFRESH, si la entidad se actualiza, la entidad relacionada también se actualizará
    //                    CascadeType.REMOVE}) si la entidad se elimina / remueve, la entidad relacionada también se eliminará
    //                    CascadeType.ALL   Todos los tipos de cascada anteriores
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail instructorDetail;

// When we fetch / retrieve data, should we retrieve EVERYTHING?
// Eager will retrieve everything
//      Eager loading will load all dependent entities
//      Load instructor and all of their courses at one
// Lazy will retrieve on request
//      Lazy loading will load the main entity first
//      Load dependent entities on demand (Lazy)

// Conclusion: Lazy loading is preferred, load on demand (lazy), Because if we have
// register 50.000 of student relationships with course, we context application java
// would have register 50.000 of student and we don't really need that information

// Best Practice
// Only load data when absolutely needed, Prefer Lazy loading instead of Eager loading

// Note: To retrieve lazy data, you will need to open a Hibernate session
// Retrieve lazy data using
//          option 1: session.get and call appropriate getter method/s
//          option 2: Hibernate query with HQL

    // look at the instructor property in the Course class
    // Use information from the Course class @JoinColumn
    // To help find associated course for instructor
    @OneToMany(fetch=FetchType.LAZY,
               mappedBy="instructor",
               cascade={CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.PERSIST,
                        CascadeType.REFRESH})
    private List<Course> courses;

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Instructor() {
        super();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    // with LAZY call db
    public List<Course> getCourses() {
        return courses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // add convenience methods for bi-directional relationship
    public void add(Course theCourse) {
        if (this.courses == null) {
            this.courses = new ArrayList<>();
        }

        // Bi-directional link
        courses.add(theCourse);
        theCourse.setInstructor(this);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                //", courses=" + courses + // with LAZY call db
                '}';
    }
}
