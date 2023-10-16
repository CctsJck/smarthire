package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Question.QuestionRequest;
import com.smarthire.project.model.dto.Question.QuestionResponse;
import com.smarthire.project.model.dto.Question.QuestionUpdateRequest;
import com.smarthire.project.model.entity.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-16T19:57:07-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionRequestToQuestion(QuestionRequest questionRequest) {
        if ( questionRequest == null ) {
            return null;
        }

        Question.QuestionBuilder question = Question.builder();

        question.name( questionRequest.getName() );
        question.time( questionRequest.getTime() );

        return question.build();
    }

    @Override
    public QuestionResponse questionToQuestionResponse(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionResponse.QuestionResponseBuilder questionResponse = QuestionResponse.builder();

        questionResponse.id( question.getId() );
        questionResponse.name( question.getName() );
        questionResponse.time( question.getTime() );

        return questionResponse.build();
    }

    @Override
    public Question questionUpdateRequestToQuestion(QuestionUpdateRequest questionUpdateRequest) {
        if ( questionUpdateRequest == null ) {
            return null;
        }

        Question.QuestionBuilder question = Question.builder();

        question.id( questionUpdateRequest.getId() );
        question.name( questionUpdateRequest.getName() );

        return question.build();
    }

    @Override
    public List<QuestionResponse> questionToQuestionResponse(List<Question> question) {
        if ( question == null ) {
            return null;
        }

        List<QuestionResponse> list = new ArrayList<QuestionResponse>( question.size() );
        for ( Question question1 : question ) {
            list.add( questionToQuestionResponse( question1 ) );
        }

        return list;
    }
}
