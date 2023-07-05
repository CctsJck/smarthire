package com.smarthire.project.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Search {

    @Id @GeneratedValue
    private long id;
    private String name;
    private String description;
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "search_id")
    private List<Question> questions;

}
