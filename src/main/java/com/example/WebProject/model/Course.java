package com.example.WebProject.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }

    public List<Module> getModules() {
        return modules;
    }

    @OneToMany(mappedBy="course")
    private List<Module> modules;

    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setCreated(Date created){
        this.created = created;
    }

    public void setModified(Date modified){
        this.modified = modified;
    }

    public void setModules(List<Module> modules){
        this.modules = new ArrayList<>();
    }
}


