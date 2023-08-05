package com.zoosite.test;

import java.io.Serializable;

public class Animals implements Serializable {

    private int id;
    private String name;
    private String gender;
    private int active;
    private String Sname;
    private Zoo zoo;

    public Animals() {
        this.active = 1;
    }

    public Zoo getZoo() {

        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

}
