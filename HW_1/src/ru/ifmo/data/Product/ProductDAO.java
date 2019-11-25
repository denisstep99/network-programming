package ru.ifmo.data.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO {
    private String DBName;
    private String userName;
    private String password;

    public ProductDAO(String DBName, String userName, String password) {
        this.DBName = DBName;
        this.userName = userName;
        this.password = password;
    }

    private Connection getConnection() throws Exception {
        Connection connection = this.getConnection(3306);
        return connection;
    }

    private Connection getConnection(int port) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:" + port + '/' + this.DBName, this.userName, this.password);
        return connection;
    }

    /**
     * Возвращает список идентификаторов товаров
     *
     * @return
     */
    public List<Integer> getProductIds() throws Exception {
        List<Integer> productIds = new ArrayList<Integer>();
        Connection connection = getConnection();

        // Создание объекта Statement
        Statement statement = connection.createStatement();

        // Выполнение SQL-запроса
        ResultSet resultSet = statement.executeQuery("Select id From products");
        while (resultSet.next()) {
            productIds.add(resultSet.getInt(1));
        }

        resultSet.close();
        connection.close();
        return productIds;
    }

    /**
     * Возвращает список товаров
     *
     * @return
     */
    public List<Product> getProductAll() throws Exception {
        List<Product> productAll = new ArrayList<Product>();
        // Получение соединения с БД
        Connection connection = getConnection();

        // Создание объекта Statement
        Statement statement = connection.createStatement();

        // Выполнение SQL-запроса
        Product product = null;
        ResultSet resultSet = statement.executeQuery("Select * From products");
        while (resultSet.next()) {
            product = new Product(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getFloat(3),
                    resultSet.getInt(4)
            );
            productAll.add(product);
        }

        resultSet.close();
        connection.close();
        return productAll;
    }

    /**
     * Возвращает товар по идентификатору
     *
     * @return
     */
    public List<Product> getProductById(int id) throws Exception {
        List<Product> products = new ArrayList<Product>();
        Connection connection = getConnection();

        // Подготовка SQL-запроса
        PreparedStatement statement = connection
                .prepareStatement(
                        "Select description, rate, quantity " +
                                "From products " +
                                "Where id = ?"
                );
        // Указание значений параметров запроса
        statement.setInt(1, id);

        // Выполнение запроса
        ResultSet resultSet = statement.executeQuery();

        Product product = null;
        while (resultSet.next()) {
            product = new Product(
                    id,
                    resultSet.getString(1),
                    resultSet.getFloat(2),
                    resultSet.getInt(3)
            );
            products.add(product);
        }

        resultSet.close();
        connection.close();
        return products;
    }

    /**
     * Добавляет новый товар
     *
     * @param product
     * @throws Exception
     */
    public void addProduct(Product product) throws Exception {
        // Получение соединения с БД
        Connection connection = getConnection();

        // Подготовка SQL-запроса
        PreparedStatement statement = connection.prepareStatement(
                "Insert into products " +
                        "(id, description, rate, quantity) " +
                        "values (?, ?, ?, ?)"
        );

        statement.setInt(1, product.getId());
        statement.setString(2, product.getDescription());
        statement.setFloat(3, product.getRate());
        statement.setInt(4, product.getQuantity());

        // Выполнение запроса
        statement.executeUpdate();

        connection.close();
    }

    /**
     * Обновляет данные о товаре
     *
     * @param product
     * @throws Exception
     */
    public void setProduct(Product product) throws Exception {
        // Получение соединения с БД
        Connection connection = getConnection();

        // Подготовка SQL-запроса
        PreparedStatement statement = connection.prepareStatement(
                "Update products " +
                        "Set description=?, rate=?, quantity=? " +
                        "Where id=?"
        );

        statement.setString(1, product.getDescription());
        statement.setFloat(2, product.getRate());
        statement.setInt(3, product.getQuantity());
        statement.setInt(4, product.getId());

        // Выполнение запроса
        statement.executeUpdate();
        connection.close();
    }

    /**
     * Удаляет данные о товаре
     *
     * @param id
     * @throws Exception
     */
    public void removeProduct(int id) throws Exception {
        // Получение соединения с БД
        Connection connection = getConnection();

        // Подготовка SQL-запроса
        PreparedStatement statement = connection.prepareStatement(
                "Delete from products "
                + "Where id = ?"
        );

        statement.setInt(1, id);

        // Выполнение запроса
        statement.executeUpdate();
        connection.close();
    }
}
