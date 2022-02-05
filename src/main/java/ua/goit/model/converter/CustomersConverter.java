package ua.goit.model.converter;

import ua.goit.model.dao.CustomersDao;
import ua.goit.model.dto.CompaniesDto;
import ua.goit.model.dto.CustomersDto;

public class CustomersConverter {

    public CustomersDao convert(CustomersDto customersDto){
        CustomersDao customersDao = new CustomersDao();
        customersDao.setCustomerId(customersDto.getCustomerId());
        customersDao.setCustomerName(customersDto.getCustomerName());
        customersDao.setCustomerPhone(customersDto.getCustomerPhone());
        return customersDao;
    }

    public CustomersDto convert(CustomersDao customersDao){
        CustomersDto customersDto = new CustomersDto();
        customersDto.setCustomerId(customersDao.getCustomerId());
        customersDto.setCustomerName(customersDao.getCustomerName());
        customersDto.setCustomerPhone(customersDao.getCustomerPhone());
        return customersDto;
    }

}
