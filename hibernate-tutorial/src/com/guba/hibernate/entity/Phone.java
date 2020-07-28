package com.guba.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name="phone")
public class Phone {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="number")
    private int number;

    @Column(name="company")
    private String company;

    @OneToOne(mappedBy="phone", cascade = {CascadeType.DETACH,
                                           CascadeType.MERGE,
                                           CascadeType.PERSIST,
                                           CascadeType.REFRESH } )
    private Client client;

    public Phone() {
        super();
    }

    public Phone(int number, String company) {
        this.number = number;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getCompany() {
        return company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number=" + number +
                ", company='" + company + '\'' +
                '}';
    }
}
