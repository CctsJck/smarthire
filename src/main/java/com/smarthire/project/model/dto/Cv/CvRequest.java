package com.smarthire.project.model.dto.Cv;

import com.smarthire.project.model.entity.Candidate;
import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CvRequest {



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
