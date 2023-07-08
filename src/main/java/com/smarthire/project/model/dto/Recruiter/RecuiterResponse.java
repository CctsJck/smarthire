package com.smarthire.project.model.dto.Recruiter;

import com.smarthire.project.model.dto.Search.SearchResponse;
import com.smarthire.project.model.entity.Search;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecuiterResponse {


    private long id;

    private String name;
    private String surename;
    private String username;
    private String email;
    private String pass;

    private List<SearchResponse> searches;


}
