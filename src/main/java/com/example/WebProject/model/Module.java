package com.example.WebProject.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy="module")
    private List<Lesson> lessons;

}

