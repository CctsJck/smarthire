package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Cv.CvResponse;
import com.smarthire.project.model.entity.Candidate;
import com.smarthire.project.model.entity.Cv;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-28T11:33:40-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class CvMapperImpl implements CvMapper {

    @Override
    public CvResponse cvToCvResponse(Cv cv) {
        if ( cv == null ) {
            return null;
        }

        CvResponse.CvResponseBuilder cvResponse = CvResponse.builder();

        cvResponse.Cv( cv.getCv() );
        cvResponse.candidate( cvCandidateId( cv ) );
        cvResponse.id( cv.getId() );

        return cvResponse.build();
    }

    private Long cvCandidateId(Cv cv) {
        if ( cv == null ) {
            return null;
        }
        Candidate candidate = cv.getCandidate();
        if ( candidate == null ) {
            return null;
        }
        long id = candidate.getId();
        return id;
    }
}
