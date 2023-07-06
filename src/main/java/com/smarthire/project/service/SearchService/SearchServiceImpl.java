package com.smarthire.project.service.SearchService;

import com.smarthire.project.mappers.SearchMapper;
import com.smarthire.project.model.dto.SearchRequest;
import com.smarthire.project.model.dto.SearchResponse;
import com.smarthire.project.model.dto.SearchUpdateRequest;
import com.smarthire.project.model.entity.Search;
import com.smarthire.project.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private SearchService searchService;
    private final SearchMapper searchMapper = SearchMapper.INSTANCE;

    @Override
    public SearchResponse save(SearchRequest searchRequest) {
        Search search = searchMapper.searchRequestToSearch(searchRequest);
        search = searchRepository.save(search);
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
        return null;
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
