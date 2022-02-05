package ua.goit;

import ua.goit.config.DatabaseManager;
import ua.goit.config.PostgresHikariProvider;
import ua.goit.config.PropertiesUtil;
import ua.goit.dl.CustomersRepository;
import ua.goit.dl.Repository;
import ua.goit.model.converter.CustomersConverter;
import ua.goit.model.dao.CustomersDao;
import ua.goit.model.dto.CustomersDto;
import ua.goit.service.CustomersService;


public class Main {
    public static void main(String[] args){

        PropertiesUtil util = new PropertiesUtil();

        DatabaseManager dbConnector = new PostgresHikariProvider(util.getHostname(), util.getPort(), util.getSchema(),
                util.getUser(), util.getPassword());

        Repository<CustomersDao> repository = new CustomersRepository(dbConnector);

        CustomersConverter customersConverter = new CustomersConverter();

        CustomersService customersService = new CustomersService(customersConverter, repository);

        CustomersDto customersDto = new CustomersDto();
        customersDto.setCustomerId(5);
        customersDto.setCustomerName("Artem");
        customersDto.setCustomerPhone("+380509982992");

//        customersService.update(customersDto);
//        customersService.create(customersDto);
//        customersService.delete(customersDto);

    }
}
