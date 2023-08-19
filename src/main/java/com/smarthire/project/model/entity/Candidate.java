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


    @OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL)
    private List<Result> results;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cv_id", referencedColumnName = "id")
    private Cv cv;

}
