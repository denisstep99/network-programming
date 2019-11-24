package ru.ifmo.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class DAOAbstract<T> {
    protected String DBName;
    private String userName;
    private String password;
    protected String tableName;

    public DAOAbstract(String DBName, String tableName, String userName, String password) {
        this.tableName = tableName;
        this.DBName = DBName;
        this.userName = userName;
        this.password = password;
    }


    /**
     * Вспомогательная функция для установки соединения с БД
     *
     * @return Connection
     * @throws Exception
     */
    protected Connection getConnection() throws Exception {
        Connection connection = this.getConnection(3306);
        return connection;
    }


    /**
     * Вспомогательная функция для установки соединения с БД
     *
     * @param port - номер порта
     * @return
     * @throws Exception
     */
    protected Connection getConnection(int port) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:" + port + '/' + this.DBName, this.userName, this.password);
        return connection;
    }


    /**
     * Возвращает список идентификаторов элементов
     *
     * @return
     */
    public List<Integer> getAllID() throws Exception {
        List<Integer> elementsID = new ArrayList<Integer>();
        Connection connection = getConnection();

        // Создание объекта Statement
        Statement statement = connection.createStatement();

        // Выполнение SQL-запроса
        ResultSet resultSet = statement.executeQuery("Select id From " + this.tableName);
        while (resultSet.next()) {
            elementsID.add(resultSet.getInt(1));
        }

        resultSet.close();
        connection.close();
        return elementsID;
    }


    /**
     * Удаляет данные о товаре
     *
     * @param id
     * @throws Exception
     */
    public void remove(int id) throws Exception {
        // Получение соединения с БД
        Connection connection = getConnection();

        // Подготовка SQL-запроса
        PreparedStatement statement = connection.prepareStatement(
                "Delete from " + tableName
                        + " Where id = ?"
        );

        statement.setInt(1, id);

        // Выполнение запроса
        statement.executeUpdate();
        connection.close();
    }


    /**
     * Возвращает список товаров
     *
     * @return
     * @throws Exception
     */
    public abstract List<T> getAll() throws Exception;


    /**
     * Возвращает товар по id
     *
     * @return
     * @throws Exception
     */
    public abstract T getByID(int id) throws Exception;


    /**
     * Обновляет запись в таблице
     *
     * @return
     * @throws Exception
     */
    public abstract void set(T element) throws Exception;


    /**
     * Добавляет новый товар
     *
     * @param element
     * @throws Exception
     */
    public abstract void add(T element) throws Exception;
}
