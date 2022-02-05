package ua.goit.dl;

import ua.goit.config.DatabaseManager;
import ua.goit.model.dao.CompaniesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CompaniesRepository implements Repository{

    private final DatabaseManager connector;
    private static final String FIND_BY_ID = "SELECT * FROM companies s WHERE s.company_id = ? ;";



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
    public void create(Object o) {

    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public int update(Object o) {
        return 0;
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
}
