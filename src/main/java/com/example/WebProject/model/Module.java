package com.example.WebProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy="module")
    private List<Lesson> lesson;
    @ManyToOne
    @JsonIgnore
    private Course course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Lesson> getLessons() {
        return lesson;
    }

    public void setLesson(List<Lesson> lesson) {
        this.lesson = new ArrayList<>();
    }
}

