package ua.goit;

import ua.goit.config.DatabaseManager;
import ua.goit.config.PostgresHikariProvider;
import ua.goit.config.PropertiesUtil;
import ua.goit.config.Queries.SelectQueries;

public class Main {
    public static void main(String[] args){

        PropertiesUtil util = new PropertiesUtil();

        DatabaseManager dbConnector = new PostgresHikariProvider(util.getHostname(), util.getPort(), util.getSchema(),
                util.getUser(), util.getPassword());

        SelectQueries selectQueries = new SelectQueries(dbConnector);

//        System.out.println(selectQueries.separatedProjectSalary(3));           //зп одного проекта
//
//        System.out.println(selectQueries.listOfDevelopersByProject(1));        //список разработчиков на проекте
//
//        System.out.println(selectQueries.listOfDevelopersByLanguage("Java"));          //разработчики по языкам
//
//        System.out.println(selectQueries.listOfDevelopersBySkill("Middle"));    //разработчики по скилу

        System.out.println(selectQueries.listInfOfProjects());


    }
}
