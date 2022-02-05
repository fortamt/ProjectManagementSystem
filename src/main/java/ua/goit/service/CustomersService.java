package ua.goit.service;

import ua.goit.dl.Repository;
import ua.goit.model.converter.CustomersConverter;
import ua.goit.model.dao.CustomersDao;
import ua.goit.model.dto.CustomersDto;

public class CustomersService {

    private final CustomersConverter converter;
    private final Repository<CustomersDao> repository;

    public CustomersService(CustomersConverter converter, Repository<CustomersDao> repository) {
        this.converter = converter;
        this.repository = repository;
    }

    public CustomersDto findById(Integer id){
        return converter.convert(repository.findById(id));
    }

    public void create(CustomersDto dto){
        repository.create(converter.convert(dto));
    }

    public void delete(CustomersDto dto){
        repository.delete(converter.convert(dto));
    }

    public int update(CustomersDto dto){
        return repository.update(converter.convert(dto));
    }
}
