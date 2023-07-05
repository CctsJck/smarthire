package com.smarthire.project.model.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Recruiter {

    @Id @GeneratedValue
    private long id;

    private String name;
    private String surename;
    private String username;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "recruiter_id")
    private List<Search> searchs;




}
