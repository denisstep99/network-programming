package ru.ifmo.data.company;

import ru.ifmo.helpers.DAOAbstract;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO extends DAOAbstract<Company> {
    public CompanyDAO(String DBName, String tableName, String userName, String password) {
        super(DBName, tableName, userName, password);
    }

    @Override
    public List<Company> getAll() throws Exception {
        List<Company> companyAll = new ArrayList<Company>();
        // Получение соединения с БД
        Connection connection = getConnection();

        // Создание объекта Statement
        Statement statement = connection.createStatement();
        Company company = null;

        ResultSet resultSet = statement.executeQuery("Select * From companies");
        while (resultSet.next()) {
            company = new Company(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getString(6)
            );
            companyAll.add(company);
        }

        resultSet.close();
        connection.close();
        return companyAll;
    }


    @Override
    public Company getByID(int id) throws Exception {
        List<Company> products = new ArrayList<Company>();
        Connection connection = getConnection();

        // Подготовка SQL-запроса
        PreparedStatement statement = connection
                .prepareStatement(
                        "Select name, country, numberOfEmployees, revenue, type " +
                                "From companies " +
                                "Where id = ?"
                );
        // Указание значений параметров запроса
        statement.setInt(1, id);

        // Выполнение запроса
        ResultSet resultSet = statement.executeQuery();

        Company company = null;
        if (resultSet.next()) {
            company = new Company(
                    id,
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)
            );
            resultSet.close();
            connection.close();
            return company;
        }

        resultSet.close();
        connection.close();
        return null;
    }

    @Override
    public void set(Company company) throws Exception {
        // Получение соединения с БД
        Connection connection = getConnection();

        // Подготовка SQL-запроса
        PreparedStatement statement = connection.prepareStatement(
                "Update companies " +
                        "Set name=?, country=?, numberOfEmployees=?, revenue=?, type=? " +
                        "Where id=?"
        );

        statement.setString(1, company.getName());
        statement.setString(2, company.getCountry());
        statement.setInt(3, company.getNumberOfEmployees());
        statement.setInt(4, company.getRevenue());
        statement.setString(5, company.getType());
        statement.setInt(6, company.getId());

        // Выполнение запроса
        statement.executeUpdate();

        connection.close();
    }


    @Override
    public void add(Company company) throws Exception {
        // Получение соединения с БД
        Connection connection = getConnection();

        // Подготовка SQL-запроса
        PreparedStatement statement = connection.prepareStatement(
                "Insert into companies " +
                        "(id, name, country, numberOfEmployees, revenue, type) " +
                        "values (?, ?, ?, ?, ?, ?)"
        );

        statement.setInt(1, company.getId());
        statement.setString(2, company.getName());
        statement.setString(3, company.getCountry());
        statement.setInt(4, company.getNumberOfEmployees());
        statement.setInt(5, company.getRevenue());
        statement.setString(6, company.getType());

        // Выполнение запроса
        statement.executeUpdate();

        connection.close();
    }
}
