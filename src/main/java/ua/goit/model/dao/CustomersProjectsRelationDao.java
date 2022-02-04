package ua.goit.model.dao;

public class CustomersProjectsRelationDao {

    private Integer customerId;
    private Integer projectId;

    public CustomersProjectsRelationDao(Integer customerId, Integer projectId) {
        this.customerId = customerId;
        this.projectId = projectId;
    }

    public CustomersProjectsRelationDao() {
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
