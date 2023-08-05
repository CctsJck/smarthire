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

    @Id @GeneratedValue
    private long id;
    private Float angry;
    private Float disgust;
    private Float fear;
    private Float happy;
    private Float neutral;
    private Float sad;
    private Float surprise;


    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;











}
