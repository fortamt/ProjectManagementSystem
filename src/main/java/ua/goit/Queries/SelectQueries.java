package ua.goit.Queries;

import ua.goit.config.DatabaseManager;
import ua.goit.model.dao.ProjectSpecFormatDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectQueries {

    private final DatabaseManager connector;
    private static final String SALARY_SUM= "SELECT SUM(salary) sum FROM projects p " +
            "JOIN developers_projects_relation dpr ON p.id = dpr.project_id " +
            "JOIN developers d ON dpr.developer_id = d.id WHERE p.id = ?";
    private static final String DEVELOPERS_LIST_BY_PROJECT = "SELECT developer_name developer FROM developers d " +
            "JOIN developers_projects_relation dpr ON d.id = dpr.developer_id " +
            "JOIN projects p ON p.id = dpr.project_id WHERE p.id = ?";
    private static final String DEVELOPERS_LIST_BY_LANGUAGE = "SELECT DISTINCT developer_name developer FROM developers d " +
            "JOIN developers_skills_relation dpr ON d.id = dpr.developer_id " +
            "JOIN skills s ON s.id = dpr.skill_id WHERE s.language = ?";
    private static final String DEVELOPERS_LIST_BY_SKILL = "SELECT DISTINCT developer_name developer FROM developers d " +
            "JOIN developers_skills_relation dpr ON d.id = dpr.developer_id " +
            "JOIN skills s ON s.id = dpr.skill_id WHERE s.skill_lvl = ?";
    private static final String PROJECTS = "SELECT p.project_start_date psd , p.project_name name, COUNT(dpr.developer_id) count FROM projects p " +
            "JOIN developers_projects_relation dpr ON p.id = dpr.project_id " +
            "GROUP BY p.project_start_date, p.project_name";

    public SelectQueries(DatabaseManager connector) {
        this.connector = connector;
    }

    public int separatedProjectSalary(Integer projectId){
        int sum = 0;
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SALARY_SUM)){
            preparedStatement.setInt(1, projectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sum = resultSet.getInt("sum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    public List<String> listOfDevelopersByProject(Integer projectId){
        List<String> result = new ArrayList<>();
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DEVELOPERS_LIST_BY_PROJECT)){
            preparedStatement.setInt(1, projectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getString("developer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> listOfDevelopersByLanguage(String language){
        List<String> result = new ArrayList<>();
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DEVELOPERS_LIST_BY_LANGUAGE)){
            preparedStatement.setString(1, language);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getString("developer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> listOfDevelopersBySkill(String skill_lvl){
        List<String> result = new ArrayList<>();
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DEVELOPERS_LIST_BY_SKILL)){
            preparedStatement.setString(1, skill_lvl);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getString("developer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<ProjectSpecFormatDao> listInfOfProjects(){
        List<ProjectSpecFormatDao> result = new ArrayList<>();
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(PROJECTS)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProjectSpecFormatDao specFormatDao = new ProjectSpecFormatDao();
                specFormatDao.setDate(resultSet.getDate("psd"));
                specFormatDao.setName(resultSet.getString("name"));
                specFormatDao.setCount(resultSet.getInt("count"));
                result.add(specFormatDao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }





}
