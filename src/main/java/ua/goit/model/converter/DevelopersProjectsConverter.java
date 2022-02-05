package ua.goit.model.converter;

import ua.goit.model.dao.DevelopersProjectsRelationDao;
import ua.goit.model.dto.DevelopersProjectsRelationDto;

public class DevelopersProjectsConverter {

    public DevelopersProjectsRelationDao convert(DevelopersProjectsRelationDto drp){
        DevelopersProjectsRelationDao developersProjectsRelationDao = new DevelopersProjectsRelationDao();
        developersProjectsRelationDao.setDeveloperId(drp.getDeveloperId());
        developersProjectsRelationDao.setProjectId(drp.getProjectId());
        return developersProjectsRelationDao;
    }

    public DevelopersProjectsRelationDto convert(DevelopersProjectsRelationDao drp){
        DevelopersProjectsRelationDto developersProjectsRelationDto = new DevelopersProjectsRelationDto();
        developersProjectsRelationDto.setDeveloperId(drp.getDeveloperId());
        developersProjectsRelationDto.setProjectId(drp.getProjectId());
        return developersProjectsRelationDto;
    }

}
