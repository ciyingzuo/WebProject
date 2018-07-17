package com.example.WebProject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy="module")
    private List<Lesson> lessons;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = new ArrayList<>();
    }
}

