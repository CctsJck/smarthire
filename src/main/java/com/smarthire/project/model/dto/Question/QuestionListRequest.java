package com.smarthire.project.model.dto.Question;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionListRequest {
    @NotBlank (message = "Ingresar por lo menos 1 pregunta!")
    private List<QuestionRequest> questionRequests;
}
