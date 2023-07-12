package com.smarthire.project.service.SearchService;

import com.smarthire.project.exception.SearchNotFoundException;
import com.smarthire.project.mapper.SearchMapper;
import com.smarthire.project.model.dto.Search.SearchRequest;
import com.smarthire.project.model.dto.Search.SearchResponse;
import com.smarthire.project.model.dto.Search.SearchUpdateRequest;
import com.smarthire.project.model.entity.Recruiter;
import com.smarthire.project.model.entity.Search;
import com.smarthire.project.repository.SearchRepository;
import com.smarthire.project.service.RecruiterService.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private SearchService searchService;
    @Autowired
    private RecruiterService recruiterService;
    private final SearchMapper searchMapper = SearchMapper.INSTANCE;

    @Override
    public SearchResponse save(SearchRequest searchRequest) {
        Search search = searchMapper.searchRequestToSearch(searchRequest);
        Recruiter recruiter = recruiterService.findById(searchRequest.getUserId());
        search.setRecruiter(recruiter);
        searchRepository.save(search);
        return searchMapper.searchToSearchResponse(search);
    }

    @Override
    public SearchResponse update(SearchUpdateRequest searchUpdateRequest) {
        Search searchEntity = searchRepository.save(searchMapper.searchUpdateRequestToSearch(searchUpdateRequest));
        return searchMapper.searchToSearchResponse(searchEntity);
    }

    @Override
    public void delete(Long id) {
        Search search= this.findById(id);
        searchRepository.delete(search);
    }

    @Override
    public Search findById(Long id) {
        return searchRepository.findById(id)
                .orElseThrow(() -> new SearchNotFoundException("Search not found with ID " + id));
    }

    @Override
    public SearchResponse getSearchResponseById(Long id) {
        return null;
    }

    @Override
    public List<SearchResponse> getSearchByNombre(String nombre) {
        return null;
    }

    @Override
    public List<SearchResponse> getSearchByDescripcion(String descripcion) {
        return null;
    }
}
