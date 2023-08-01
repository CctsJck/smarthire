package com.smarthire.project.service.CandidateService;

import com.smarthire.project.model.dto.Candidate.CandidateRequest;
import com.smarthire.project.model.dto.Candidate.CandidateResponse;
import com.smarthire.project.model.entity.Candidate;

public interface CandidateService {

    CandidateResponse createCandidate(CandidateRequest candidateRequest);

    Candidate findCandidateById(Long id);
}
