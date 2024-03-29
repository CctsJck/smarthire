package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Result.ResultFilterResponse;
import com.smarthire.project.model.dto.Result.ResultRequest;
import com.smarthire.project.model.dto.Result.ResultResponse;
import com.smarthire.project.model.entity.Result;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ResultMapper {

    ResultMapper INSTANCE = Mappers.getMapper(ResultMapper.class);

    Result resultRequestToResult(ResultRequest resultRequest);

    ResultResponse resultToResultResponse(Result result);
    @Mapping(target = "candidate.cvResponse.candidate", ignore = true)
    @Mapping(source = "candidate.cv", target = "candidate.cvResponse")
    @Mapping(source = "candidate.cv.cv", target = "candidate.cvResponse.Cv")
    ResultFilterResponse resultToResultFilterResponse(Result result);
    @Mapping(source = "result.candidate.cv.cv", target = "candidate.cvResponse.Cv") // Specify the mapping between field names
    List<ResultFilterResponse> resultToResultFilterResponse(List<Result> results);

}
