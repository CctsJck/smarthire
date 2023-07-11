package com.smarthire.project.model.entity;

import lombok.*;

import javax.persistence.*;

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
    private String type;
    private String picture;
    private String video;

    @ManyToOne
    @JoinColumn(name = "search_id")
    private Search search;
}
