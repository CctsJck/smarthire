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

    @Id @GeneratedValue
    private long id;

    private String name;
    private Integer time;

    @ManyToOne
    @JoinColumn(name = "search_id")
    private Search search;


    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Result> results;




}
