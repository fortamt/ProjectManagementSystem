package ua.goit.dl;

import ua.goit.config.DatabaseManager;
import ua.goit.model.dao.CompaniesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class CompaniesRepository implements Repository<CompaniesDao>{

    private final DatabaseManager connector;
    private static final String FIND_BY_ID = "SELECT * FROM companies c WHERE c.company_id = ? ;";
    private static final String INSERT = "INSERT INTO companies (company_id, company_name, company_address) VALUES (?, ?, ?)";
    private static final String DELETE_BY_ID = "DELETE FROM companies WHERE company_id = ?";
    private static final String UPDATE = "UPDATE companies SET company_name = ? , company_address = ? WHERE company_id = ?";

    public CompaniesRepository(DatabaseManager connector) {
        this.connector = connector;
    }

    @Override
    public CompaniesDao findById(Integer id) {
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCompaniesDao(resultSet).orElseThrow(() -> new IllegalArgumentException(String.format("Company with id %d not found", id)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(CompaniesDao companiesDao) {
        CompaniesDao existCompany = check(companiesDao.getCompanyId());
        if(Objects.nonNull(existCompany)){
            throw new IllegalArgumentException(String.format("Company with id %d already exists", companiesDao.getCompanyId()));
        }
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT)){
            preparedStatement.setInt(1, companiesDao.getCompanyId());
            preparedStatement.setString(2, companiesDao.getCompanyName());
            preparedStatement.setString(3, companiesDao.getCompanyAddress());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(CompaniesDao companiesDao) {
        findById(companiesDao.getCompanyId());
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)){
            preparedStatement.setInt(1, companiesDao.getCompanyId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(CompaniesDao companiesDao) {
        int rowsUpdated = 0;
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
            preparedStatement.setString(1, companiesDao.getCompanyName());
            preparedStatement.setString(2, companiesDao.getCompanyAddress());
            preparedStatement.setInt(3, companiesDao.getCompanyId());
            rowsUpdated = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    private Optional<CompaniesDao> mapToCompaniesDao(ResultSet resultSet) throws SQLException{
        CompaniesDao companiesDao = null;
        while(resultSet.next()){
            companiesDao = new CompaniesDao();
            companiesDao.setCompanyId(resultSet.getInt("company_id"));
            companiesDao.setCompanyName(resultSet.getString("company_name"));
            companiesDao.setCompanyAddress(resultSet.getString("company_address"));
        }
        return Optional.ofNullable(companiesDao);
    }

    private CompaniesDao check(Integer id) {
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCompaniesDao(resultSet).orElse(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
