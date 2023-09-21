package com.smarthire.project.service.CvService;

import com.smarthire.project.model.dto.Cv.CvRequest;
import com.smarthire.project.model.dto.Cv.CvResponse;

public interface CvService {

    CvResponse create(CvRequest cvRequest,Long id);

    CvResponse getByCandidate(Long candidate);
}
