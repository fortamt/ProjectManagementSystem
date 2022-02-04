package ua.goit.model.dao;

public class CompaniesProjectsRelationDao {

    private String companyId;
    private String projectId;

    public CompaniesProjectsRelationDao(String companyId, String projectId) {
        this.companyId = companyId;
        this.projectId = projectId;
    }

    public CompaniesProjectsRelationDao() {
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
