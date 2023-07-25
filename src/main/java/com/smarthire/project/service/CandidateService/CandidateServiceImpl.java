package com.smarthire.project.service.CandidateService;

import com.smarthire.project.mapper.CandidateMapper;
import com.smarthire.project.model.dto.Candidate.CandidateRequest;
import com.smarthire.project.model.dto.Candidate.CandidateResponse;
import com.smarthire.project.model.entity.Candidate;
import com.smarthire.project.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private CandidateRepository candidateRepository;

    private final CandidateMapper candidateMapper = CandidateMapper.INSTANCE;

    @Override
    public CandidateResponse createCandidate(CandidateRequest candidateRequest) {
        Candidate candidate = candidateMapper.candidateRequestToCandidate(candidateRequest);
        candidateRepository.save(candidate);
        CandidateResponse response = candidateMapper.candidateToCandidateResponse(candidate);
        return response;
    }
}
