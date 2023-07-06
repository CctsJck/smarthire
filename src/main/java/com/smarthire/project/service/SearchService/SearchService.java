package com.smarthire.project.service.SearchService;

import com.smarthire.project.model.dto.SearchRequest;
import com.smarthire.project.model.dto.SearchResponse;
import com.smarthire.project.model.entity.Search;

import java.util.List;

public interface SearchService {

    SearchResponse save(SearchRequest searchRequest);
    SearchResponse update(SearchRequest searchRequest);
    void delete(Long id);
    Search findById(Long id);
    SearchResponse getSearchResponseById(Long id);
    List<SearchResponse> getSearchByNombre(String nombre);
    List<SearchResponse> getSearchByDescripcion(String descripcion);

}
