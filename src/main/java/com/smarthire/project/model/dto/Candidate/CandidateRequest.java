package com.smarthire.project.model.dto.Candidate;

import com.smarthire.project.model.dto.Search.SearchRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CandidateRequest {
    @NotBlank(message = "Ingrese su nombre")
    private String name;
    @NotBlank(message = "Ingrese su apellido")
    private String surename;

    @NotNull
    private SearchRequest searchRequest;


}
