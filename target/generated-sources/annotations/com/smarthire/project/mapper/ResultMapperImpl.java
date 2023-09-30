package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Candidate.CandidateResponse;
import com.smarthire.project.model.dto.Result.ResultFilterResponse;
import com.smarthire.project.model.dto.Result.ResultRequest;
import com.smarthire.project.model.dto.Result.ResultResponse;
import com.smarthire.project.model.entity.Candidate;
import com.smarthire.project.model.entity.Result;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T13:04:44-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class ResultMapperImpl implements ResultMapper {

    @Override
    public Result resultRequestToResult(ResultRequest resultRequest) {
        if ( resultRequest == null ) {
            return null;
        }

        Result.ResultBuilder result = Result.builder();

        result.angry( resultRequest.getAngry() );
        result.happy( resultRequest.getHappy() );
        result.neutral( resultRequest.getNeutral() );
        result.sad( resultRequest.getSad() );

        return result.build();
    }

    @Override
    public ResultResponse resultToResultResponse(Result result) {
        if ( result == null ) {
            return null;
        }

        ResultResponse.ResultResponseBuilder resultResponse = ResultResponse.builder();

        resultResponse.id( result.getId() );
        resultResponse.angry( result.getAngry() );
        resultResponse.disgust( result.getDisgust() );
        resultResponse.fear( result.getFear() );
        resultResponse.happy( result.getHappy() );
        resultResponse.neutral( result.getNeutral() );
        resultResponse.sad( result.getSad() );
        resultResponse.surprise( result.getSurprise() );

        return resultResponse.build();
    }

    @Override
    public ResultFilterResponse resultToResultFilterResponse(Result result) {
        if ( result == null ) {
            return null;
        }

        ResultFilterResponse.ResultFilterResponseBuilder resultFilterResponse = ResultFilterResponse.builder();

        resultFilterResponse.id( result.getId() );
        resultFilterResponse.angry( result.getAngry() );
        resultFilterResponse.disgust( result.getDisgust() );
        resultFilterResponse.fear( result.getFear() );
        resultFilterResponse.happy( result.getHappy() );
        resultFilterResponse.neutral( result.getNeutral() );
        resultFilterResponse.sad( result.getSad() );
        resultFilterResponse.surprise( result.getSurprise() );
        resultFilterResponse.candidate( candidateToCandidateResponse( result.getCandidate() ) );

        return resultFilterResponse.build();
    }

    @Override
    public List<ResultFilterResponse> resultToResultFilterResponse(List<Result> results) {
        if ( results == null ) {
            return null;
        }

        List<ResultFilterResponse> list = new ArrayList<ResultFilterResponse>( results.size() );
        for ( Result result : results ) {
            list.add( resultToResultFilterResponse( result ) );
        }

        return list;
    }

    protected CandidateResponse candidateToCandidateResponse(Candidate candidate) {
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
