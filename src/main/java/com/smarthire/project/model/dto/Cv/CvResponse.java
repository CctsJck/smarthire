package com.smarthire.project.model.dto.Cv;

import javax.persistence.ElementCollection;
import java.util.List;

public class CvResponse {

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

    private Long candidateId;
}
