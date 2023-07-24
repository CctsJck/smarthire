package com.smarthire.project.service.SearchService;

import com.smarthire.project.exception.EmptySearchesException;
import com.smarthire.project.exception.SearchNotFoundException;
import com.smarthire.project.mapper.SearchMapper;
import com.smarthire.project.model.dto.Search.SearchByRecruiterResponse;
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
        Recruiter recruiter = recruiterService.findByIdEntity(searchRequest.getUserId());
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
        if(searchRepository.findById(id).isPresent()) {
            Search search = searchRepository.findById(id).get();
            return searchMapper.searchToSearchResponse(search);
        }
        throw new SearchNotFoundException("No se encontro una busqueda con ese ID");


    }

    @Override
    public List<SearchResponse> getSearchByNombre(String nombre) {
        return null;
    }

    @Override
    public List<SearchResponse> getSearchByDescripcion(String descripcion) {
        return null;
    }

    @Override
    public List<SearchByRecruiterResponse> getSearchesByRecruiter(Long id) {
        Recruiter recruiter = recruiterService.findByIdEntity(id);
        List<Search> searches = searchRepository.findByRecruiter(recruiter);
        if (searches.isEmpty()){
            throw new EmptySearchesException("El usuario ingresado no tiene busquedas creadas");
        }
        return searchMapper.searchTosearchByRecruiterResponse(searches);
    }

    @Override
    public String generateShareLink(Long id) {

        if (searchRepository.findById(id).isPresent()){
            Search search = searchRepository.findById(id).get();
            return "http://localhost:5000/search/"+search.getId();
        }else {
            throw new SearchNotFoundException("La busqueda no existe o expiró!");
        }


    }
}
