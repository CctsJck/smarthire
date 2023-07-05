package com.smarthire.project.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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



}
