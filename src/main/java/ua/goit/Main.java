package ua.goit;

import ua.goit.config.DatabaseManager;
import ua.goit.config.PostgresHikariProvider;
import ua.goit.config.PropertiesUtil;
import ua.goit.dl.Repository;
import ua.goit.dl.SkillsRepository;
import ua.goit.model.converter.SkillsConverter;
import ua.goit.model.dao.SkillsDao;
import ua.goit.model.dto.SkillsDto;
import ua.goit.service.SkillsService;

public class Main {
    public static void main(String[] args){

        PropertiesUtil util = new PropertiesUtil();

        DatabaseManager dbConnector = new PostgresHikariProvider(util.getHostname(), util.getPort(), util.getSchema(),
                util.getUser(), util.getPassword());

        Repository<SkillsDao> repository = new SkillsRepository(dbConnector);

        SkillsConverter skillsConverter = new SkillsConverter();

        SkillsService skillsService = new SkillsService(skillsConverter, repository);

        SkillsDto dto = new SkillsDto();
        dto.setSkillId(13);
        dto.setLanguage("None");
        dto.setSkillLevel("Pro");

        skillsService.delete(dto);


    }
}
