package ua.goit.service;

import ua.goit.dl.Repository;
import ua.goit.model.converter.CompaniesConverter;
import ua.goit.model.dao.CompaniesDao;
import ua.goit.model.dto.CompaniesDto;

import java.util.Objects;

public class CompaniesService {

    private final CompaniesConverter converter;
    private final Repository<CompaniesDao> repository;

    public CompaniesService(CompaniesConverter converter, Repository<CompaniesDao> repository) {
        this.converter = converter;
        this.repository = repository;
    }

    public CompaniesDto findById(Integer id){
        return converter.convert(repository.findById(id));
    }

    public void create(CompaniesDto dto){
        repository.create(converter.convert(dto));
    }

    public void delete(CompaniesDto dto){
        repository.delete(converter.convert(dto));
    }

    public int update(CompaniesDto dto){
        return repository.update(converter.convert(dto));
    }
}
