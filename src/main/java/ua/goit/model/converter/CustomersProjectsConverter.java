package ua.goit.model.converter;

import ua.goit.model.dao.CustomersProjectsRelationDao;
import ua.goit.model.dto.CustomersProjectsRelationDto;

public class CustomersProjectsConverter {

    public CustomersProjectsRelationDao convert(CustomersProjectsRelationDto cpr){
        CustomersProjectsRelationDao customersProjectsRelationDao = new CustomersProjectsRelationDao();
        customersProjectsRelationDao.setProjectId(cpr.getProjectId());
        customersProjectsRelationDao.setCustomerId(cpr.getCustomerId());
        return customersProjectsRelationDao;
    }

    public CustomersProjectsRelationDto convert(CustomersProjectsRelationDao cpr){
        CustomersProjectsRelationDto customersProjectsRelationDto = new CustomersProjectsRelationDto();
        customersProjectsRelationDto.setCustomerId(cpr.getCustomerId());
        customersProjectsRelationDto.setProjectId(cpr.getProjectId());
        return customersProjectsRelationDto;
    }

}
