package com.smarthire.project.model.dto.Cv;

import lombok.*;

import javax.persistence.ElementCollection;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CvResponse {

    private long id;

    private String Cv;

    private Long candidate;
}
