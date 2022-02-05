package ua.goit.model.converter;

import ua.goit.model.dao.DevelopersSkillsRelationDao;
import ua.goit.model.dto.DevelopersSkillsRelationDto;

public class DevelopersSkillsConverter {

    public DevelopersSkillsRelationDao convert(DevelopersSkillsRelationDto dsr){
        DevelopersSkillsRelationDao developersSkillsRelationDao = new DevelopersSkillsRelationDao();
        developersSkillsRelationDao.setDeveloperId(dsr.getDeveloperId());
        developersSkillsRelationDao.setSkillId(dsr.getSkillId());
        return developersSkillsRelationDao;
    }

    public DevelopersSkillsRelationDto convert(DevelopersSkillsRelationDao dsr){
        DevelopersSkillsRelationDto developersSkillsRelationDto = new DevelopersSkillsRelationDto();
        developersSkillsRelationDto.setDeveloperId(dsr.getDeveloperId());
        developersSkillsRelationDto.setSkillId(dsr.getSkillId());
        return developersSkillsRelationDto;
    }

}
