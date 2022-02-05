package ua.goit;

import ua.goit.config.DatabaseManager;
import ua.goit.config.PostgresHikariProvider;
import ua.goit.config.PropertiesUtil;
import ua.goit.dl.CompaniesRepository;
import ua.goit.dl.Repository;
import ua.goit.model.converter.CompaniesConverter;
import ua.goit.model.dao.CompaniesDao;
import ua.goit.model.dto.CompaniesDto;
import ua.goit.service.CompaniesService;



public class Main {
    public static void main(String[] args){

        PropertiesUtil util = new PropertiesUtil();

        DatabaseManager dbConnector = new PostgresHikariProvider(util.getHostname(), util.getPort(), util.getSchema(),
                util.getUser(), util.getPassword());

        Repository<CompaniesDao> repository = new CompaniesRepository(dbConnector);

        CompaniesConverter companiesConverter = new CompaniesConverter();

        CompaniesService companiesService = new CompaniesService(companiesConverter, repository);

        CompaniesDto companiesDto = companiesService.findById(1);



    }
}
