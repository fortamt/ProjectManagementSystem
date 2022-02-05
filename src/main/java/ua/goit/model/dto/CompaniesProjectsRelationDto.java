package ua.goit.model.dto;

public class CompaniesProjectsRelationDto {

    private String companyId;
    private String projectId;

    public CompaniesProjectsRelationDto(String companyId, String projectId) {
        this.companyId = companyId;
        this.projectId = projectId;
    }

    public CompaniesProjectsRelationDto() {
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
