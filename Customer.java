package com.exercise.customerapi.model;


import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cusId;

    @Column(length = 20, nullable = false)
    private String cusFirstName;

    @Column(length = 20, nullable = false)
    private String cusLastName;

    @Column(length = 20, unique = true, nullable = false)
    private String cusPhonenumber;

    // Getters and setters
    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getCusFirstName() {
        return cusFirstName;
    }

    public void setCusFirstName(String cusFirstName) {
        this.cusFirstName = cusFirstName;
    }

    public String getCusLastName() {
        return cusLastName;
    }

    public void setCusLastName(String cusLastName) {
        this.cusLastName = cusLastName;
    }

    public String getCusPhonenumber() {
        return cusPhonenumber;
    }

    public void setCusPhonenumber(String cusPhonenumber) {
        this.cusPhonenumber = cusPhonenumber;
    }
}

