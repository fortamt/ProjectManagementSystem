package ua.goit.model.dto;

public class CompaniesProjectsRelationDto {

    private Integer companyId;
    private Integer projectId;

    public CompaniesProjectsRelationDto(Integer companyId, Integer projectId) {
        this.companyId = companyId;
        this.projectId = projectId;
    }

    public CompaniesProjectsRelationDto() {
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
