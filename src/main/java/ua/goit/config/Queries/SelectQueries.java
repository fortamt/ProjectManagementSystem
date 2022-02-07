package ua.goit.config.Queries;

import ua.goit.config.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectQueries {

    private final DatabaseManager connector;
    private static final String SALARY_SUM= "SELECT SUM(salary) sum FROM projects p " +
            "JOIN developers_projects_relation dpr ON p.project_id = dpr.project_id " +
            "JOIN developers d ON dpr.developer_id = d.developer_id WHERE p.project_id = ?";
    private static final String DEVELOPERS_LIST = "SELECT developer_name developer FROM developers d " +
            "JOIN developers_projects_relation dpr ON d.developer_id = dpr.developer_id " +
            "JOIN projects p ON p.project_id = dpr.project_id WHERE p.project_id = ?";
    private static final String JAVA_DEVELOPERS_LIST = "SELECT developer_name developer FROM developers d " +
            "JOIN developers_skills_relation dpr ON d.developer_id = dpr.developer_id " +
            "JOIN skills s ON s.skill_id = dpr.skill_id WHERE s.language = '?'";

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
            PreparedStatement preparedStatement = connection.prepareStatement(DEVELOPERS_LIST)){
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
            PreparedStatement preparedStatement = connection.prepareStatement(DEVELOPERS_LIST)){
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



}
