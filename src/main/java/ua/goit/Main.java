package ua.goit;

import ua.goit.config.DatabaseManager;
import ua.goit.config.PostgresHikariProvider;
import ua.goit.config.PropertiesUtil;
import ua.goit.dl.CustomersRepository;
import ua.goit.dl.DevelopersRepository;
import ua.goit.dl.Repository;
import ua.goit.model.converter.CustomersConverter;
import ua.goit.model.converter.DevelopersConverter;
import ua.goit.model.dao.CustomersDao;
import ua.goit.model.dao.DevelopersDao;
import ua.goit.model.dto.CustomersDto;
import ua.goit.model.dto.DevelopersDto;
import ua.goit.service.CustomersService;
import ua.goit.service.DevelopersService;


public class Main {
    public static void main(String[] args){

        PropertiesUtil util = new PropertiesUtil();

        DatabaseManager dbConnector = new PostgresHikariProvider(util.getHostname(), util.getPort(), util.getSchema(),
                util.getUser(), util.getPassword());

        Repository<DevelopersDao> repository = new DevelopersRepository(dbConnector);

        DevelopersConverter developersConverter = new DevelopersConverter();

        DevelopersService developersService = new DevelopersService(developersConverter, repository);

        DevelopersDto developersDto = new DevelopersDto();
        developersDto.setDeveloperId(11);
        developersDto.setDeveloperName("Kirill");
        developersDto.setDeveloperAge(26);
        developersDto.setDeveloperSex("F");
        developersDto.setSalary(500);

//        developersService.update(developersDto);
//        developersService.create(developersDto);
//        developersService.delete(developersDto);

    }
}
