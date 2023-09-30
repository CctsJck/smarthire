package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Candidate.CandidateRequest;
import com.smarthire.project.model.dto.Candidate.CandidateResponse;
import com.smarthire.project.model.entity.Candidate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T13:04:44-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class CandidateMapperImpl implements CandidateMapper {

    @Override
    public Candidate candidateRequestToCandidate(CandidateRequest candidateRequest) {
        if ( candidateRequest == null ) {
            return null;
        }

        Candidate.CandidateBuilder candidate = Candidate.builder();

        candidate.name( candidateRequest.getName() );
        candidate.surename( candidateRequest.getSurename() );

        return candidate.build();
    }

    @Override
    public CandidateResponse candidateToCandidateResponse(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        CandidateResponse.CandidateResponseBuilder candidateResponse = CandidateResponse.builder();

        candidateResponse.id( candidate.getId() );
        candidateResponse.name( candidate.getName() );
        candidateResponse.surename( candidate.getSurename() );

        return candidateResponse.build();
    }
}
