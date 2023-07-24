package com.smarthire.project.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Float angry;
    private Float disgust;
    private Float fear;
    private Float happy;
    private Float neutral;
    private Float sad;
    private Float surprise;


    @OneToOne(mappedBy = "result")
    private Candidate candidate;



}
