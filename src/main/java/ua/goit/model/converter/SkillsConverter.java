package ua.goit.model.converter;

import ua.goit.model.dao.SkillsDao;
import ua.goit.model.dto.SkillsDto;

public class SkillsConverter {

    public SkillsDao convert(SkillsDto skillsDto){
        SkillsDao skillsDao = new SkillsDao();
        skillsDao.setSkillId(skillsDto.getSkillId());
        skillsDao.setLanguage(skillsDto.getLanguage());
        skillsDao.setSkillLevel(skillsDto.getSkillLevel());
        return skillsDao;
    }

    public SkillsDto convert(SkillsDao skillsDao){
        SkillsDto skillsDto = new SkillsDto();
        skillsDto.setSkillId(skillsDao.getSkillId());
        skillsDto.setLanguage(skillsDao.getLanguage());
        skillsDto.setSkillLevel(skillsDao.getSkillLevel());
        return skillsDto;
    }

}
