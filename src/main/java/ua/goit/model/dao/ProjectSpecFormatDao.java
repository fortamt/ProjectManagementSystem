package ua.goit.model.dao;

import java.sql.Date;
import java.util.List;

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

    public static void printInfo(List<ProjectSpecFormatDao> list){
        for(ProjectSpecFormatDao psf : list){
            System.out.println("Project name: " + psf.getName());
            System.out.println("Date of start: " + psf.getDate());
            System.out.println("Count of developers: " + psf.getCount());
            System.out.println("---------");
        }
    }

    @Override
    public String toString() {
        return "Date: " + date +
                ", Project`s name: '" + name + '\'' +
                ", Count of developers: " + count;
    }
}
