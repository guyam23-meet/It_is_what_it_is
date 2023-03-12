package com.example.devworkshop;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Startup {
    private String name;
    private String statusQuo;
    private Boolean hasSolution;

    public Startup(){}
    public Startup(String name, String statusQuo, Boolean hasSolution) {
        this.name = name;
        this.statusQuo = statusQuo;
        this.hasSolution = hasSolution;
    }

    public String getName() {
        return name;
    }

    public String getStatusQuo() {
        return statusQuo;
    }

    public Boolean getHasSolution() {return hasSolution;}

    public void setName(String name) {
        this.name = name;
    }

    public void setStatusQuo(String statusQuo) {
        this.statusQuo = statusQuo;
    }

    public void setHasSolution(Boolean hasSolution) {
        this.hasSolution = hasSolution;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + this.name +
                ", statusQuo=" + this.statusQuo +
                ", HasSolution=" + this.hasSolution +
                '}';
    }
}
