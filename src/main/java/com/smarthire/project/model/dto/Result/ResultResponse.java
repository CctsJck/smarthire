package com.smarthire.project.model.dto.Result;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultResponse {

    private long id;
    private Float angry;
    private Float disgust;
    private Float fear;
    private Float happy;
    private Float neutral;
    private Float sad;
    private Float surprise;
}
