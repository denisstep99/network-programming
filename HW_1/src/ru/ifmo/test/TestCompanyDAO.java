package ru.ifmo.test;

import java.util.List;
import java.util.logging.Logger;

import ru.ifmo.data.Product.Product;
import ru.ifmo.data.Product.ProductDAO;
import ru.ifmo.data.company.Company;
import ru.ifmo.data.company.CompanyDAO;

public class TestCompanyDAO {
    private static Logger logger = Logger.getLogger("Product.class");

    public static void main(String[] args) throws Exception {
        CompanyDAO companyDAO = new CompanyDAO("business", "companies","root", "root");

        TestCompanyDAO.testGetAllID(companyDAO);
        TestCompanyDAO.testGetAll(companyDAO);
        TestCompanyDAO.testGetById(companyDAO);
        TestCompanyDAO.testAdd(companyDAO);
        TestCompanyDAO.testSet(companyDAO);
        TestCompanyDAO.testRemove(companyDAO);
    }


    private static void testGetAllID(CompanyDAO companyDAO) throws Exception {
        TestCompanyDAO.printBreak();
        logger.info("getAllID: ");

        List<Integer> companyIds = companyDAO.getAllID();
        companyIds.forEach(value -> logger.info("Очередной ID: " + value.toString()));
    }


    private static void testGetAll(CompanyDAO companyDAO) throws Exception {
        List<Company> companyAll = companyDAO.getAll();
        TestCompanyDAO.printBreak();
        logger.info("getAll: ");

        companyAll.forEach(value -> logger.info(
                "Информация о компании:\n" +
                        "ID: " + value.getId() + "\n" +
                        "Name: " + value.getName() + "\n" +
                        "Country: " + value.getCountry() + "\n" +
                        "Number of employees: " + value.getNumberOfEmployees() + "\n" +
                        "Revenue: " + value.getRevenue() + "$\n" +
                        "Type: " + value.getType() + "\n\n"
        ));
    }


    private static void testGetById(CompanyDAO companyDAO) throws Exception {
        TestCompanyDAO.printBreak();
        logger.info("getById: ");

        Company company = companyDAO.getByID(1);
        logger.info("Существующий id: ");
        logger.info(
                "Информация о компании:\n" +
                        "ID: " + company.getId() + "\n" +
                        "Name: " + company.getName() + "\n" +
                        "Country: " + company.getCountry() + "\n" +
                        "Number of employees: " + company.getNumberOfEmployees() + "\n" +
                        "Revenue: " + company.getRevenue() + "$\n" +
                        "Type: " + company.getType() + "\n\n"
        );

        company = companyDAO.getByID(10000);
        logger.info("Несуществующий id: ");
        logger.info("Company: " + company);
    }


    private static void testAdd(CompanyDAO companyDAO) throws Exception {
        TestCompanyDAO.printBreak();
        logger.info("add: ");

        Company company = new Company(10, "Ubisoft", "France", 6100, 315000000, "public");
        companyDAO.add(company);

        Company addedCompany = companyDAO.getByID(10);
        logger.info("Добавленный обьект, полученный из БД: ");
        logger.info(
                "Информация о компании:\n" +
                        "ID: " + addedCompany.getId() + "\n" +
                        "Name: " + addedCompany.getName() + "\n" +
                        "Country: " + addedCompany.getCountry() + "\n" +
                        "Number of employees: " + addedCompany.getNumberOfEmployees() + "\n" +
                        "Revenue: " + addedCompany.getRevenue() + "$\n" +
                        "Type: " + addedCompany.getType() + "\n\n"
        );
    }


    /*
     * !!!Внимание, тест связан с предыдущим тестом и зависит от его результата!!!
     * */
    private static void testSet(CompanyDAO companyDAO) throws Exception {
        TestCompanyDAO.printBreak();
        logger.info("set: ");

        Company company = new Company(10, "EASports", "England", 1100, 80000000, "division");
        companyDAO.set(company);

        Company addedCompany = companyDAO.getByID(10);
        logger.info("Обновленный обьект, полученный из БД: ");
        logger.info(
                "Информация о компании:\n" +
                        "ID: " + addedCompany.getId() + "\n" +
                        "Name: " + addedCompany.getName() + "\n" +
                        "Country: " + addedCompany.getCountry() + "\n" +
                        "Number of employees: " + addedCompany.getNumberOfEmployees() + "\n" +
                        "Revenue: " + addedCompany.getRevenue() + "$\n" +
                        "Type: " + addedCompany.getType() + "\n\n"
        );
    }


    /*
     * !!!Внимание, тест связан с предыдущим тестом и зависит от его результата!!!
     * */
    private static void testRemove(CompanyDAO companyDAO) throws Exception {
        TestCompanyDAO.printBreak();
        logger.info("remove: ");

        companyDAO.remove(10);
        Company company = companyDAO.getByID(10);
        if (company == null) {
            logger.info("Successfully deleted");
        } else {
            logger.info("Element hasn't been deleted!!!");
        }
    }

    private static void printBreak() {
        logger.info("\n\n--------------------------------------------------------------------------------\n\n");
    }
}