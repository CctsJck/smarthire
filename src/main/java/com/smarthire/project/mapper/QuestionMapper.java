package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Question.QuestionRequest;
import com.smarthire.project.model.dto.Question.QuestionResponse;
import com.smarthire.project.model.dto.Question.QuestionUpdateRequest;
import com.smarthire.project.model.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    Question questionRequestToQuestion(QuestionRequest questionRequest);

    QuestionResponse questionToQuestionResponse(Question question);
    @Mapping(source = "time", target = "time")
    Question questionUpdateRequestToQuestion(QuestionUpdateRequest questionUpdateRequest);

    List<QuestionResponse> questionToQuestionResponse(List<Question> question);
}
