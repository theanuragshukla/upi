package com.anurag.upi.Entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "upiusers")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userid;
    }

    public void setUserId(String userId) {
        System.out.println(userId);
        this.userid = userid;
    }

    public String getCreatedOn() {
        return createdon;
    }

    public void setCreatedOn(String createdOn) {
        this.createdon = createdOn;
    }

    private String name;
    private String userid;

    private String createdon;

}
