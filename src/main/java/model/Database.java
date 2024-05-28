
package model;

import java.sql.*;

public class Database
{
    private final Connection connection;

    public Database(String url, String user, String password) throws SQLException
    {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        connection = DriverManager.getConnection(url, user, password);
        if (connection.isClosed())
            throw new SQLException("Connection is closed");
    }

    public ResultSet executeQuery(String sqlQuery) throws SQLException
    {
        Statement statement = connection.createStatement();
        boolean isResultSet = statement.execute(sqlQuery);

        if (isResultSet)
            return statement.executeQuery(sqlQuery);

        return null;
    }

    public void closeConnection() throws SQLException
    {
        if (!connection.isClosed())
            connection.close();
    }


}
