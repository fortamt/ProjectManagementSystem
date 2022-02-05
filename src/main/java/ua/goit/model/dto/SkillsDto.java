package ua.goit.model.dto;

public class SkillsDto {

    private Integer skillId;
    private String language;
    private String skillLevel;

    public SkillsDto(Integer skillId, String language, String skillLevel) {
        this.skillId = skillId;
        this.language = language;
        this.skillLevel = skillLevel;
    }

    public SkillsDto() {
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }
}
