package com.smarthire.project.service.CvService;


import com.smarthire.project.mapper.CandidateMapper;
import com.smarthire.project.mapper.CvMapper;
import com.smarthire.project.model.dto.Cv.CvRequest;
import com.smarthire.project.model.dto.Cv.CvResponse;
import com.smarthire.project.model.entity.Candidate;
import com.smarthire.project.model.entity.Cv;
import com.smarthire.project.repository.CandidateRepository;
import com.smarthire.project.repository.CvRepository;
import com.smarthire.project.service.CandidateService.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class CvServiceImpl implements CvService{

    @Autowired
    CandidateService candidateService;

    @Autowired
    CvRepository cvRepository;

    @Autowired
    CandidateRepository candidateRepository;

    private final CvMapper cvMapper = CvMapper.INSTANCE;

    @Override
    public CvResponse create(CvRequest cvRequest, Long candidateId) {
        Candidate candidate = candidateService.findCandidateById(candidateId);
        Cv cv = new Cv();
        cv.setCv(cvRequest.getCv());
        cv.setCandidate(candidate);
        candidate.setCv(cv);

        log.info("Candidato:" + cv.getCandidate().getName());
        log.info(cv.getCv());
        cvRepository.save(cv);
        candidateRepository.save(candidate);
        CvResponse cvResponse = cvMapper.cvToCvResponse(cv);
        log.info(cvResponse.getCv());
        return cvResponse;

    }

    @Override
    public CvResponse getByCandidate(Long candidate) {
        Candidate candidate1 = candidateService.findCandidateById(candidate);
        Cv cv = candidate1.getCv();
        return cvMapper.cvToCvResponse(cv);
    }
}
