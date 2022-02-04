package ua.goit.model.dao;

public class DevelopersProjectsRelationDao {

    private Integer developerId;
    private Integer projectId;

    public DevelopersProjectsRelationDao(Integer developerId, Integer projectId) {
        this.developerId = developerId;
        this.projectId = projectId;
    }

    public DevelopersProjectsRelationDao() {
    }

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
