package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Candidate.CandidateRequest;
import com.smarthire.project.model.dto.Candidate.CandidateResponse;
import com.smarthire.project.model.entity.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CandidateMapper {

    CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);


    Candidate candidateRequestToCandidate(CandidateRequest candidateRequest);

    CandidateResponse candidateToCandidateResponse(Candidate candidate);
}
