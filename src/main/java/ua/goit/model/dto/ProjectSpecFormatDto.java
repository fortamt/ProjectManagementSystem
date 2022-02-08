package ua.goit.model.dto;

import java.sql.Date;

public class ProjectSpecFormatDto {

    private Date date;
    private String name;
    private Integer count;

    public ProjectSpecFormatDto(Date date, String name, Integer count) {
        this.date = date;
        this.name = name;
        this.count = count;
    }

    public ProjectSpecFormatDto() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ProjectSpecFormatDto{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
