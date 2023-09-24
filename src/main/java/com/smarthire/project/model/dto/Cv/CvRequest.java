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

    private String Cv;

}
