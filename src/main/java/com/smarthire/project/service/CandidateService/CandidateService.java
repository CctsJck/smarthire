package com.smarthire.project.service.CandidateService;

import com.smarthire.project.model.dto.Candidate.CandidateRequest;
import com.smarthire.project.model.dto.Candidate.CandidateResponse;

public interface CandidateService {

    CandidateResponse createCandidate(CandidateRequest candidateRequest);
}
