package com.monmouthvalley.tandoor.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "res_date")
    private Date resDate;

    @Column(name = "res_amount")
    private int resAmount;

    @Column(name = "res_active")
    private boolean isActive;

    @Column(name = "res_user")
    private String user;


    public  Reservation(){

    }

    public Reservation(Date resDate, int resAmount, boolean isActive, String user) {
        this.resDate = resDate;
        this.resAmount = resAmount;
        this.isActive = isActive;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

    public int getResAmount() {
        return resAmount;
    }

    public void setResAmount(int resAmount) {
        this.resAmount = resAmount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
