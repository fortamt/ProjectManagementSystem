package ua.goit.model.converter;

import ua.goit.model.dao.ProjectsDao;
import ua.goit.model.dto.ProjectsDto;

public class ProjectsConverter {

    public ProjectsDao convert(ProjectsDto projectsDto){
        ProjectsDao projectsDao = new ProjectsDao();
        projectsDao.setProjectId(projectsDto.getProjectId());
        projectsDao.setProjectName(projectsDto.getProjectName());
        projectsDao.setProjectStartDate(projectsDto.getProjectStartDate());
        projectsDao.setCost(projectsDto.getCost());
        return projectsDao;
    }

    public ProjectsDto convert(ProjectsDao projectsDao){
        ProjectsDto projectsDto = new ProjectsDto();
        projectsDto.setProjectId(projectsDao.getProjectId());
        projectsDto.setProjectName(projectsDao.getProjectName());
        projectsDto.setProjectStartDate(projectsDao.getProjectStartDate());
        projectsDto.setCost(projectsDao.getCost());
        return projectsDto;
    }

}
