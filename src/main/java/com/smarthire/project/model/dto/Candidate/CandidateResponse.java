package com.smarthire.project.model.dto.Candidate;

import com.smarthire.project.model.dto.Cv.CvCandidateResponse;
import com.smarthire.project.model.dto.Cv.CvResponse;
import com.smarthire.project.model.entity.Result;
import com.smarthire.project.model.entity.Search;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateResponse {

    private long id;
    private String name;
    private String surename;
    private CvResponse cvResponse;
}
