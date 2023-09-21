package com.smarthire.project.service.CvService;


import com.smarthire.project.mapper.CandidateMapper;
import com.smarthire.project.mapper.CvMapper;
import com.smarthire.project.model.dto.Cv.CvRequest;
import com.smarthire.project.model.dto.Cv.CvResponse;
import com.smarthire.project.model.entity.Candidate;
import com.smarthire.project.model.entity.Cv;
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

    private final CvMapper cvMapper = CvMapper.INSTANCE;

    @Override
    public CvResponse create(CvRequest cvRequest, Long candidateId) {
        Candidate candidate = candidateService.findCandidateById(candidateId);
        Cv cv = new Cv();
        cv.setCandidate(candidate);
        cv.setContacto(cvRequest.getContacto());
        cv.setCertifiaciones(cvRequest.getCertifiaciones());
        cv.setHabilidades(cvRequest.getHabilidades());
        cv.setExperiencia(cv.getExperiencia());
        cv.setIdiomas(cv.getIdiomas());
        cv.setEducacion(cv.getEducacion());

        cvRepository.save(cv);

        CvResponse cvResponse = cvMapper.CvToCvResponse(cv);
        return cvResponse;

    }

    @Override
    public CvResponse getByCandidate(Long candidate) {
        Candidate candidate1 = candidateService.findCandidateById(candidate);
        Cv cv = cvRepository.findByCandidate(candidate1);
        return cvMapper.CvToCvResponse(cv);
    }
}
