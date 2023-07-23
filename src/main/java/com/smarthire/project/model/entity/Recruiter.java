package com.smarthire.project.model.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Recruiter {

    @Id @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surename;
    private String username;
    private String email;
    private String pass;
    private boolean isEnabled;


    @OneToMany(mappedBy = "recruiter",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Search> searches;




}
