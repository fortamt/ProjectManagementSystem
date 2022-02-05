package ua.goit.model.converter;

import ua.goit.model.dao.CompaniesProjectsRelationDao;
import ua.goit.model.dto.CompaniesProjectsRelationDto;

public class CompaniesProjectsRelationConverter {

    public CompaniesProjectsRelationDto convert(CompaniesProjectsRelationDao cpr){
        CompaniesProjectsRelationDto companiesProjectsRelationDto = new CompaniesProjectsRelationDto();
        companiesProjectsRelationDto.setCompanyId(cpr.getCompanyId());
        companiesProjectsRelationDto.setProjectId(cpr.getProjectId());
        return companiesProjectsRelationDto;
    }

    public CompaniesProjectsRelationDao convert(CompaniesProjectsRelationDto cpr){
        CompaniesProjectsRelationDao companiesProjectsRelationDao = new CompaniesProjectsRelationDao();
        companiesProjectsRelationDao.setCompanyId(cpr.getCompanyId());
        companiesProjectsRelationDao.setProjectId(cpr.getProjectId());
        return companiesProjectsRelationDao;
    }

}
