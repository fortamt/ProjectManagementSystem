package ua.goit.model.dao;

public class CompaniesProjectsRelationDao {

    private Integer companyId;
    private Integer projectId;

    public CompaniesProjectsRelationDao(Integer companyId, Integer projectId) {
        this.companyId = companyId;
        this.projectId = projectId;
    }

    public CompaniesProjectsRelationDao() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
