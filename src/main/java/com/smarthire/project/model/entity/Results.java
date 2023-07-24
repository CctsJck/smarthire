package com.smarthire.project.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Results {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


}
