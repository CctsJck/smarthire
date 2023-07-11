package com.smarthire.project.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Search {

    @Id @GeneratedValue
    private long id;

    private String name;
    private String description;
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;

    @OneToMany(mappedBy = "search",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

}
