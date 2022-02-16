package ua.goit;

import ua.goit.config.*;
import ua.goit.Queries.SelectQueries;
import ua.goit.dl.*;
import ua.goit.model.converter.*;
import ua.goit.model.dao.*;
import ua.goit.model.dto.*;
import ua.goit.service.*;

import java.sql.Date;

public class Main {
    public static void main(String[] args){

        PropertiesUtil util = new PropertiesUtil();

        DatabaseManager dbConnector = new PostgresHikariProvider(util.getHostname(), util.getPort(), util.getSchema(),
                util.getUser(), util.getPassword());

        SelectQueries selectQueries = new SelectQueries(dbConnector);

        System.out.println("Sum of salary of the project : " + selectQueries.separatedProjectSalary(3));           //зп одного проекта
        System.out.println();
        System.out.println("Developer`s list of project: " + selectQueries.listOfDevelopersByProject(1));        //список разработчиков на проекте
        System.out.println();
        System.out.println("Developers by language: " + selectQueries.listOfDevelopersByLanguage("Java"));          //разработчики по языкам
        System.out.println();
        System.out.println("Developers by skill: " + selectQueries.listOfDevelopersBySkill("Middle"));    //разработчики по скилу
        System.out.println();
        ProjectSpecFormatDao.printInfo(selectQueries.listInfOfProjects());      //список проектов инфо



        /*  CRUD  */

        Repository<CompaniesDao> companiesRepository = new CompaniesRepository(dbConnector);
        CompaniesConverter companiesConverter = new CompaniesConverter();
        CompaniesService companiesService = new CompaniesService(companiesConverter, companiesRepository);
        CompaniesDto companiesDto = new CompaniesDto(4, "Samsung", "MINATO-KU, TOKYO, Japan");
        companiesService.create(companiesDto);
        companiesService.findById(4);
        companiesDto.setCompanyName("Konami");
        companiesService.update(companiesDto);
        companiesService.delete(companiesDto);

        Repository<CustomersDao> customersRepository = new CustomersRepository(dbConnector);
        CustomersConverter customersConverter = new CustomersConverter();
        CustomersService customersService = new CustomersService(customersConverter, customersRepository);
        CustomersDto customersDto = new CustomersDto(4, "Artem", "380669315397");
        customersService.create(customersDto);
        customersService.findById(4);
        customersDto.setCustomerName("Nikola");
        customersService.update(customersDto);
        customersService.delete(customersDto);

        Repository<DevelopersDao> developersRepository = new DevelopersRepository(dbConnector);
        DevelopersConverter developersConverter = new DevelopersConverter();
        DevelopersService developersService = new DevelopersService(developersConverter, developersRepository);
        DevelopersDto developersDto = new DevelopersDto(11, "Genius", 100, "F", 1000000);
        developersService.create(developersDto);
        developersService.findById(11);
        developersDto.setSalary(1578456);
        developersService.update(developersDto);
        developersService.delete(developersDto);

        Repository<ProjectsDao> projectsRepository = new ProjectsRepository(dbConnector);
        ProjectsConverter projectsConverter = new ProjectsConverter();
        ProjectsService projectsService = new ProjectsService(projectsConverter, projectsRepository);
        ProjectsDto projectsDto = new ProjectsDto(10, "MCloud", new Date(45623123486456L), 54684562);
        projectsService.create(projectsDto);
        projectsService.findById(10);
        projectsDto.setCost(1245);
        projectsService.update(projectsDto);
        projectsService.delete(projectsDto);

        Repository<SkillsDao> skillsRepository = new SkillsRepository(dbConnector);
        SkillsConverter skillsConverter = new SkillsConverter();
        SkillsService skillsService = new SkillsService(skillsConverter, skillsRepository);
        SkillsDto skillsDto = new SkillsDto(13, "All", "Pro");
        skillsService.create(skillsDto);
        skillsService.findById(13);
        skillsDto.setLanguage("Go");
        skillsService.update(skillsDto);
        skillsService.delete(skillsDto);
    }
}
