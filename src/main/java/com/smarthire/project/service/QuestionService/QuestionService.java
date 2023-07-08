package com.smarthire.project.service.QuestionService;

import com.smarthire.project.model.dto.Question.QuestionRequest;
import com.smarthire.project.model.dto.Question.QuestionResponse;
import com.smarthire.project.model.dto.Question.QuestionUpdateRequest;
import com.smarthire.project.model.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    QuestionResponse save (QuestionRequest questionRequest);

    QuestionResponse update (QuestionUpdateRequest questionUpdateRequest);

    void delete(Long id);

    Question findById(Long id);

    QuestionResponse getQuestionResponseById(Long id);
    List<QuestionResponse> getQuestionByName(String name);

}
