package ua.goit.model.converter;

import ua.goit.dl.CompaniesRepository;
import ua.goit.model.dao.CompaniesDao;
import ua.goit.model.dto.CompaniesDto;

public class CompaniesConverter {

    public CompaniesDao convert(CompaniesDto companiesDto){
        CompaniesDao dao = new CompaniesDao();
        dao.setCompanyId(companiesDto.getCompanyId());
        dao.setCompanyName(companiesDto.getCompanyName());
        dao.setCompanyAddress(companiesDto.getCompanyAddress());
        return dao;
    }

    public CompaniesDto convert(CompaniesDao companiesDao){
        CompaniesDto dto = new CompaniesDto();
        dto.setCompanyId(companiesDao.getCompanyId());
        dto.setCompanyName(companiesDao.getCompanyName());
        dto.setCompanyAddress(companiesDao.getCompanyAddress());
        return dto;
    }
}
