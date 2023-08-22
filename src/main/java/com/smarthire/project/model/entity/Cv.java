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

    @ElementCollection
    private List<String> experiencia;
    @ElementCollection
    private List<String> educacion;
    @ElementCollection
    private List<String> contacto;
    @ElementCollection
    private List<String> habilidades;
    @ElementCollection
    private List<String> idiomas;
    @ElementCollection
    private List<String> certifiaciones;

    @OneToOne(mappedBy = "cv")
    private  Candidate candidate;



}
