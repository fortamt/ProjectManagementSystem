package ua.goit.model.dto;

public class CustomersProjectsRelationDto {

    private Integer customerId;
    private Integer projectId;

    public CustomersProjectsRelationDto(Integer customerId, Integer projectId) {
        this.customerId = customerId;
        this.projectId = projectId;
    }

    public CustomersProjectsRelationDto() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
