package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Question.QuestionRequest;
import com.smarthire.project.model.dto.Question.QuestionResponse;
import com.smarthire.project.model.dto.Question.QuestionUpdateRequest;
import com.smarthire.project.model.dto.Search.SearchByRecruiterResponse;
import com.smarthire.project.model.dto.Search.SearchRequest;
import com.smarthire.project.model.dto.Search.SearchResponse;
import com.smarthire.project.model.dto.Search.SearchUpdateRequest;
import com.smarthire.project.model.entity.Question;
import com.smarthire.project.model.entity.Search;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T11:48:58-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class SearchMapperImpl implements SearchMapper {

    @Override
    public Search searchRequestToSearch(SearchRequest searchRequest) {
        if ( searchRequest == null ) {
            return null;
        }

        Search.SearchBuilder search = Search.builder();

        search.name( searchRequest.getName() );
        search.description( searchRequest.getDescription() );
        search.endDate( searchRequest.getEndDate() );
        search.questions( questionRequestListToQuestionList( searchRequest.getQuestions() ) );

        return search.build();
    }

    @Override
    public SearchResponse searchToSearchResponse(Search search) {
        if ( search == null ) {
            return null;
        }

        SearchResponse.SearchResponseBuilder searchResponse = SearchResponse.builder();

        searchResponse.id( search.getId() );
        searchResponse.name( search.getName() );
        searchResponse.description( search.getDescription() );
        searchResponse.endDate( search.getEndDate() );
        searchResponse.questions( questionListToQuestionResponseList( search.getQuestions() ) );

        return searchResponse.build();
    }

    @Override
    public Search searchUpdateRequestToSearch(SearchUpdateRequest searchUpdateRequest) {
        if ( searchUpdateRequest == null ) {
            return null;
        }

        Search.SearchBuilder search = Search.builder();

        search.id( searchUpdateRequest.getId() );
        search.name( searchUpdateRequest.getName() );
        search.description( searchUpdateRequest.getDescription() );
        search.endDate( searchUpdateRequest.getEndDate() );
        search.questions( questionUpdateRequestListToQuestionList( searchUpdateRequest.getQuestions() ) );

        return search.build();
    }

    @Override
    public List<SearchResponse> searchToSearchResponse(List<Search> search) {
        if ( search == null ) {
            return null;
        }

        List<SearchResponse> list = new ArrayList<SearchResponse>( search.size() );
        for ( Search search1 : search ) {
            list.add( searchToSearchResponse( search1 ) );
        }

        return list;
    }

    @Override
    public List<SearchByRecruiterResponse> searchTosearchByRecruiterResponse(List<Search> searchList) {
        if ( searchList == null ) {
            return null;
        }

        List<SearchByRecruiterResponse> list = new ArrayList<SearchByRecruiterResponse>( searchList.size() );
        for ( Search search : searchList ) {
            list.add( searchToSearchByRecruiterResponse( search ) );
        }

        return list;
    }

    protected Question questionRequestToQuestion(QuestionRequest questionRequest) {
        if ( questionRequest == null ) {
            return null;
        }

        Question.QuestionBuilder question = Question.builder();

        question.name( questionRequest.getName() );
        question.type( questionRequest.getType() );
        question.picture( questionRequest.getPicture() );

        return question.build();
    }

    protected List<Question> questionRequestListToQuestionList(List<QuestionRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Question> list1 = new ArrayList<Question>( list.size() );
        for ( QuestionRequest questionRequest : list ) {
            list1.add( questionRequestToQuestion( questionRequest ) );
        }

        return list1;
    }

    protected QuestionResponse questionToQuestionResponse(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionResponse.QuestionResponseBuilder questionResponse = QuestionResponse.builder();

        questionResponse.id( question.getId() );
        questionResponse.name( question.getName() );
        questionResponse.type( question.getType() );
        questionResponse.picture( question.getPicture() );

        return questionResponse.build();
    }

    protected List<QuestionResponse> questionListToQuestionResponseList(List<Question> list) {
        if ( list == null ) {
            return null;
        }

        List<QuestionResponse> list1 = new ArrayList<QuestionResponse>( list.size() );
        for ( Question question : list ) {
            list1.add( questionToQuestionResponse( question ) );
        }

        return list1;
    }

    protected Question questionUpdateRequestToQuestion(QuestionUpdateRequest questionUpdateRequest) {
        if ( questionUpdateRequest == null ) {
            return null;
        }

        Question.QuestionBuilder question = Question.builder();

        question.id( questionUpdateRequest.getId() );
        question.name( questionUpdateRequest.getName() );
        question.type( questionUpdateRequest.getType() );
        question.picture( questionUpdateRequest.getPicture() );

        return question.build();
    }

    protected List<Question> questionUpdateRequestListToQuestionList(List<QuestionUpdateRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Question> list1 = new ArrayList<Question>( list.size() );
        for ( QuestionUpdateRequest questionUpdateRequest : list ) {
            list1.add( questionUpdateRequestToQuestion( questionUpdateRequest ) );
        }

        return list1;
    }

    protected SearchByRecruiterResponse searchToSearchByRecruiterResponse(Search search) {
        if ( search == null ) {
            return null;
        }

        SearchByRecruiterResponse.SearchByRecruiterResponseBuilder searchByRecruiterResponse = SearchByRecruiterResponse.builder();

        searchByRecruiterResponse.id( search.getId() );
        searchByRecruiterResponse.name( search.getName() );
        searchByRecruiterResponse.description( search.getDescription() );

        return searchByRecruiterResponse.build();
    }
}
