package ua.goit.model.dao;

import java.sql.Date;

public class ProjectSpecFormatDao {

    private Date date;
    private String name;
    private Integer count;

    public ProjectSpecFormatDao(Date date, String name, Integer count) {
        this.date = date;
        this.name = name;
        this.count = count;
    }

    public ProjectSpecFormatDao() {
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
        return "ProjectSpecFormatDao{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
