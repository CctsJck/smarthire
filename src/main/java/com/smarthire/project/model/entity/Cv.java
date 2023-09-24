package com.smarthire.project.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cv {

    @Id @GeneratedValue
    private long id;
    @Column(length = 3000)
    private String cv;
    @OneToOne(mappedBy = "cv")
    private  Candidate candidate;



}
