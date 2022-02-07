package ua.goit.dl;

import ua.goit.config.DatabaseManager;
import ua.goit.model.dao.DevelopersDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DevelopersRepository implements Repository<DevelopersDao>{

    private final DatabaseManager connector;
    private static final String FIND_BY_ID = "SELECT * FROM developers d WHERE d.developer_id = ? ;";
    private static final String INSERT = "INSERT INTO developers (developer_id, developer_name, developer_age, developer_sex, salary) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_BY_ID = "DELETE FROM developers WHERE developer_id = ?";
    private static final String UPDATE = "UPDATE developers SET developer_name = ?, developer_age = ?, developer_sex = ?, salary = ? WHERE developer_id = ?";

    public DevelopersRepository(DatabaseManager connector) {
        this.connector = connector;
    }

    @Override
    public DevelopersDao findById(Integer id) {
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToDevelopersDao(resultSet).orElseThrow(() -> new IllegalArgumentException(String.format("Developer with id %d not found", id)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(DevelopersDao developersDao) {
        try{
            DevelopersDao exist = findById(developersDao.getDeveloperId());
            System.out.println(String.format("Developer with %d already exist", exist.getDeveloperId()));
        } catch (IllegalArgumentException e){
            try(Connection connection = connector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT)){
                preparedStatement.setInt(1, developersDao.getDeveloperId());
                preparedStatement.setString(2, developersDao.getDeveloperName());
                preparedStatement.setInt(3, developersDao.getDeveloperAge());
                preparedStatement.setString(4, developersDao.getDeveloperSex());
                preparedStatement.setInt(5, developersDao.getSalary());
                preparedStatement.execute();
            }
            catch (SQLException eq) {
                eq.printStackTrace();
            }
        }
    }

    @Override
    public void delete(DevelopersDao developersDao) {
        findById(developersDao.getDeveloperId());
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)){
            preparedStatement.setInt(1, developersDao.getDeveloperId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(DevelopersDao developersDao) {
        int rowsUpdated = 0;
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
            preparedStatement.setString(1, developersDao.getDeveloperName());
            preparedStatement.setInt(2, developersDao.getDeveloperAge());
            preparedStatement.setString(3, developersDao.getDeveloperSex());
            preparedStatement.setInt(4, developersDao.getSalary());
            preparedStatement.setInt(5, developersDao.getDeveloperId());
            rowsUpdated = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    private Optional<DevelopersDao> mapToDevelopersDao(ResultSet resultSet) throws SQLException {
        DevelopersDao developersDao = null;
        while(resultSet.next()){
            developersDao = new DevelopersDao();
            developersDao.setDeveloperId(resultSet.getInt("developer_id"));
            developersDao.setDeveloperName(resultSet.getString("developer_name"));
            developersDao.setDeveloperAge(resultSet.getInt("developer_age"));
            developersDao.setDeveloperSex(resultSet.getString("developer_sex"));
            developersDao.setSalary(resultSet.getInt("salary"));
        }
        return Optional.ofNullable(developersDao);
    }
}
