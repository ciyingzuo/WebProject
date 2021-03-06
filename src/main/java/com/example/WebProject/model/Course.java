package com.example.WebProject.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Course {

    public Course.visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Course.visibility visibility) {
        this.visibility = visibility;
    }

    public static enum visibility {
        PUBLIC,
        PRIVATE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private visibility visibility;
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = Calendar.getInstance().getTime();
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified = Calendar.getInstance().getTime();
    @OneToMany(mappedBy = "course")
    private List<Module> module;

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

    public List<Module> getModule() {
        return module;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public void setModule(List<Module> module) {
        this.module = module;
    }
}