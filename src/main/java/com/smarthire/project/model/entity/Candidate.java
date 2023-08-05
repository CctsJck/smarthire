package com.smarthire.project.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidate {

    @Id @GeneratedValue
    private long id;

    private String name;
    private String surename;

    @ManyToOne
    @JoinColumn(name = "search_id")
    private Search search;


    @OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Result> results;


    @OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

}
