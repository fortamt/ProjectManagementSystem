package ua.goit.dl;

import ua.goit.config.DatabaseManager;
import ua.goit.model.dao.SkillsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class SkillsRepository implements Repository<SkillsDao>{

    private final DatabaseManager connector;
    private static final String FIND_BY_ID = "SELECT * FROM skills s WHERE s.skill_id = ? ;";
    private static final String INSERT = "INSERT INTO skills (skill_id, language, skill_lvl) VALUES (?, ?, ?)";
    private static final String DELETE_BY_ID = "DELETE FROM skills WHERE skill_id = ?";
    private static final String UPDATE = "UPDATE skills SET language = ? , skill_lvl = ? WHERE skill_id = ?";

    public SkillsRepository(DatabaseManager connector) {
        this.connector = connector;
    }

    @Override
    public SkillsDao findById(Integer id) {
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToSkillsDao(resultSet).orElseThrow(() -> new IllegalArgumentException(String.format("Skill with id %d not found", id)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(SkillsDao skillsDao) {
        try{
            SkillsDao exist = findById(skillsDao.getSkillId());
            System.out.println(String.format("Skill with %d already exist", exist.getSkillId()));
        } catch (IllegalArgumentException e){
            try(Connection connection = connector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT)){
                preparedStatement.setInt(1, skillsDao.getSkillId());
                preparedStatement.setString(2, skillsDao.getLanguage());
                preparedStatement.setString(3, skillsDao.getSkillLevel());
                preparedStatement.execute();
            }
            catch (SQLException eq) {
                eq.printStackTrace();
            }
        }
    }

    @Override
    public void delete(SkillsDao skillsDao) {
        findById(skillsDao.getSkillId());
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)){
            preparedStatement.setInt(1, skillsDao.getSkillId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(SkillsDao skillsDao) {
        int rowsUpdated = 0;
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
            preparedStatement.setString(1, skillsDao.getLanguage());
            preparedStatement.setString(2, skillsDao.getSkillLevel());
            preparedStatement.setInt(3, skillsDao.getSkillId());
            rowsUpdated = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    private Optional<SkillsDao> mapToSkillsDao(ResultSet resultSet) throws SQLException {
        SkillsDao skillsDao = null;
        while(resultSet.next()){
            skillsDao = new SkillsDao();
            skillsDao.setSkillId(resultSet.getInt("skill_id"));
            skillsDao.setLanguage(resultSet.getString("language"));
            skillsDao.setSkillLevel(resultSet.getString("skill_lvl"));
        }
        return Optional.ofNullable(skillsDao);
    }
}
