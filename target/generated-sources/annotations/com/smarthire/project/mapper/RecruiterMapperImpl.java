package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Question.QuestionRequest;
import com.smarthire.project.model.dto.Question.QuestionResponse;
import com.smarthire.project.model.dto.Recruiter.RecruiterRequest;
import com.smarthire.project.model.dto.Recruiter.RecruiterResponse;
import com.smarthire.project.model.dto.Recruiter.RecruiterResponseEmail;
import com.smarthire.project.model.dto.Recruiter.RecruiterUpdateRequest;
import com.smarthire.project.model.dto.Search.SearchRequest;
import com.smarthire.project.model.dto.Search.SearchResponse;
import com.smarthire.project.model.entity.Question;
import com.smarthire.project.model.entity.Recruiter;
import com.smarthire.project.model.entity.Search;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-14T11:22:58-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class RecruiterMapperImpl implements RecruiterMapper {

    @Override
    public Recruiter recruiterRequestToRecruiter(RecruiterRequest recruiterRequest) {
        if ( recruiterRequest == null ) {
            return null;
        }

        Recruiter.RecruiterBuilder recruiter = Recruiter.builder();

        recruiter.name( recruiterRequest.getName() );
        recruiter.surename( recruiterRequest.getSurename() );
        recruiter.username( recruiterRequest.getUsername() );
        recruiter.email( recruiterRequest.getEmail() );
        recruiter.pass( recruiterRequest.getPass() );
        recruiter.searches( searchRequestListToSearchList( recruiterRequest.getSearches() ) );

        return recruiter.build();
    }

    @Override
    public RecruiterResponse recruiterToRecruiterResponse(Recruiter recruiter) {
        if ( recruiter == null ) {
            return null;
        }

        RecruiterResponse.RecruiterResponseBuilder recruiterResponse = RecruiterResponse.builder();

        recruiterResponse.id( recruiter.getId() );
        recruiterResponse.name( recruiter.getName() );
        recruiterResponse.surename( recruiter.getSurename() );
        recruiterResponse.username( recruiter.getUsername() );
        recruiterResponse.email( recruiter.getEmail() );
        recruiterResponse.pass( recruiter.getPass() );
        recruiterResponse.searches( searchListToSearchResponseList( recruiter.getSearches() ) );

        return recruiterResponse.build();
    }

    @Override
    public Recruiter recruiterUpdateRequestToRecruiter(RecruiterUpdateRequest recruiter) {
        if ( recruiter == null ) {
            return null;
        }

        Recruiter.RecruiterBuilder recruiter1 = Recruiter.builder();

        if ( recruiter.getId() != null ) {
            recruiter1.id( recruiter.getId() );
        }
        recruiter1.name( recruiter.getName() );
        recruiter1.surename( recruiter.getSurename() );
        recruiter1.username( recruiter.getUsername() );
        recruiter1.email( recruiter.getEmail() );
        recruiter1.pass( recruiter.getPass() );

        return recruiter1.build();
    }

    @Override
    public RecruiterResponseEmail recruiterToRecruiterResponseEmail(Recruiter recruiter) {
        if ( recruiter == null ) {
            return null;
        }

        RecruiterResponseEmail.RecruiterResponseEmailBuilder recruiterResponseEmail = RecruiterResponseEmail.builder();

        recruiterResponseEmail.id( recruiter.getId() );
        recruiterResponseEmail.name( recruiter.getName() );
        recruiterResponseEmail.surename( recruiter.getSurename() );
        recruiterResponseEmail.username( recruiter.getUsername() );
        recruiterResponseEmail.email( recruiter.getEmail() );

        return recruiterResponseEmail.build();
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

    protected Search searchRequestToSearch(SearchRequest searchRequest) {
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

    protected List<Search> searchRequestListToSearchList(List<SearchRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Search> list1 = new ArrayList<Search>( list.size() );
        for ( SearchRequest searchRequest : list ) {
            list1.add( searchRequestToSearch( searchRequest ) );
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

    protected SearchResponse searchToSearchResponse(Search search) {
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

    protected List<SearchResponse> searchListToSearchResponseList(List<Search> list) {
        if ( list == null ) {
            return null;
        }

        List<SearchResponse> list1 = new ArrayList<SearchResponse>( list.size() );
        for ( Search search : list ) {
            list1.add( searchToSearchResponse( search ) );
        }

        return list1;
    }
}
