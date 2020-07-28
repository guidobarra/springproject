package com.guba.hibernate.entity;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}
