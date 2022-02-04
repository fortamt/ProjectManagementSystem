package ua.goit.model.dao;

public class SkillsDao {

    private Integer skillId;
    private String language;
    private String skillLevel;

    public SkillsDao(Integer skillId, String language, String skillLevel) {
        this.skillId = skillId;
        this.language = language;
        this.skillLevel = skillLevel;
    }

    public SkillsDao() {
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
