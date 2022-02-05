package ua.goit.model.dto;

public class DevelopersDto {

    private Integer developerId;
    private String developerName;
    private Integer developerAge;
    private String developerSex;
    private Integer salary;

    public DevelopersDto(Integer developerId, String developerName, Integer developerAge, String developerSex, Integer salary) {
        this.developerId = developerId;
        this.developerName = developerName;
        this.developerAge = developerAge;
        this.developerSex = developerSex;
        this.salary = salary;
    }

    public DevelopersDto() {
    }

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public Integer getDeveloperAge() {
        return developerAge;
    }

    public void setDeveloperAge(Integer developerAge) {
        this.developerAge = developerAge;
    }

    public String getDeveloperSex() {
        return developerSex;
    }

    public void setDeveloperSex(String developerSex) {
        this.developerSex = developerSex;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
