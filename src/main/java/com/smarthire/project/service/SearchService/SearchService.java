package com.smarthire.project.service.SearchService;

import com.smarthire.project.model.dto.Search.SearchRequest;
import com.smarthire.project.model.dto.Search.SearchResponse;
import com.smarthire.project.model.dto.Search.SearchUpdateRequest;
import com.smarthire.project.model.entity.Search;

import java.util.List;

public interface SearchService {

    SearchResponse save(SearchRequest searchRequest);
    SearchResponse update(SearchUpdateRequest searchUpdateRequest);
    void delete(Long id);
    Search findById(Long id);
    SearchResponse getSearchResponseById(Long id);
    List<SearchResponse> getSearchByNombre(String nombre);
    List<SearchResponse> getSearchByDescripcion(String descripcion);

}
