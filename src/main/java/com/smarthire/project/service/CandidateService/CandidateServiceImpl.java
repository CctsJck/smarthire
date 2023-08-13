package com.smarthire.project.service.CandidateService;

import com.smarthire.project.exception.CandidateNotFoundException;
import com.smarthire.project.mapper.CandidateMapper;
import com.smarthire.project.model.dto.Candidate.CandidateRequest;
import com.smarthire.project.model.dto.Candidate.CandidateResponse;
import com.smarthire.project.model.entity.Candidate;
import com.smarthire.project.model.entity.Search;
import com.smarthire.project.repository.CandidateRepository;
import com.smarthire.project.service.SearchService.SearchService;
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
    @Autowired
    private SearchService searchService;

    private final CandidateMapper candidateMapper = CandidateMapper.INSTANCE;

    @Override
    public CandidateResponse createCandidate(CandidateRequest candidateRequest) {
        Search search= searchService.findById(candidateRequest.getIdSearch());
        Candidate candidate = candidateMapper.candidateRequestToCandidate(candidateRequest);
        candidate.setSearch(search);
        candidateRepository.save(candidate);
        log.info(candidate.getSearch().getName());
        CandidateResponse response = candidateMapper.candidateToCandidateResponse(candidate);
        return response;
    }

    @Override
    public Candidate findCandidateById(Long id) {
        if(candidateRepository.findById(id).isPresent()){
            return candidateRepository.findById(id).get();
        }else{
            throw new CandidateNotFoundException("No se encontro el candidato seleccionado");
        }
    }
}
