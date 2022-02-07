package ua.goit.model.dao;

import java.sql.Date;

public class ProjectsDao {

    private Integer projectId;
    private String projectName;
    private Date projectStartDate;
    private Integer cost;

    public ProjectsDao(Integer projectId, String projectName, Date projectStartDate, Integer cost) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStartDate = projectStartDate;
        this.cost = cost;
    }

    public ProjectsDao() {
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
