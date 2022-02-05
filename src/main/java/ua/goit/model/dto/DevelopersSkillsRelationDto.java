package ua.goit.model.dto;

public class DevelopersSkillsRelationDto {

    private Integer developerId;
    private Integer skillId;

    public DevelopersSkillsRelationDto(Integer developerId, Integer skillId) {
        this.developerId = developerId;
        this.skillId = skillId;
    }

    public DevelopersSkillsRelationDto() {
    }

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }
}
