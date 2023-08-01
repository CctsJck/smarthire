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
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String type;
    private String picture;
    private String video;

    @ManyToOne
    @JoinColumn(name = "search_id")
    private Search search;


    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Result> results;


    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;




}
