package com.example.onlinecomplaint_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "complaint")
public class ComplaintModel {

    @Id
    @GeneratedValue
    private int id;
    private int userid;
    private String complaint;

    public ComplaintModel() {
    }

    public ComplaintModel(int id, int userid, String complaint) {
        this.id = id;
        this.userid = userid;
        this.complaint = complaint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
