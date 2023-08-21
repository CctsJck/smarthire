package com.smarthire.project.model.dto.Result;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultRequest {

    private Float angry;
    private Float disgusted;
    private Float fearful;
    private Float happy;
    private Float neutral;
    private Float sad;
    private Float surprise;
}
