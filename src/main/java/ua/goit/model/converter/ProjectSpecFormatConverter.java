package ua.goit.model.converter;

import ua.goit.model.dao.ProjectSpecFormatDao;
import ua.goit.model.dto.ProjectSpecFormatDto;

public class ProjectSpecFormatConverter {

    public ProjectSpecFormatDto convert(ProjectSpecFormatDao specFormatDao){
        ProjectSpecFormatDto specFormatDto = new ProjectSpecFormatDto();
        specFormatDto.setDate(specFormatDao.getDate());
        specFormatDto.setName(specFormatDao.getName());
        specFormatDto.setCount(specFormatDao.getCount());
        return specFormatDto;
    }

    public ProjectSpecFormatDao convert(ProjectSpecFormatDto specFormatDto){
        ProjectSpecFormatDao specFormatDao = new ProjectSpecFormatDao();
        specFormatDao.setDate(specFormatDto.getDate());
        specFormatDao.setName(specFormatDto.getName());
        specFormatDao.setCount(specFormatDto.getCount());
        return specFormatDao;
    }

}
