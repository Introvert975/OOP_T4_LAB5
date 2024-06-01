package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Flowers
{
    private Database database;

    public static final String URL = "jdbc:mysql://localhost:3306/flowers_schema";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "root";

    public List<Flower> getFlowers() throws SQLException
    {
        List<Flower> flowerArrayList = new ArrayList<>();

        database = new Database(URL, LOGIN, PASSWORD);

        ResultSet resultSet = database.executeQuery("SELECT id, name, type, color, length, price FROM flowers");
        while (resultSet.next())
        {
            flowerArrayList.add(new Flower(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6)
            ));
        }

        return flowerArrayList;
    }
    public void addFlower(Flower flower) throws SQLException {
        database = new Database(URL, LOGIN, PASSWORD);

        database.executeQuery(String.format("INSERT INTO flowers (name, type, color, length, price) " +
                        "VALUES ('%s', '%s', '%s', %d, %d)",
                flower.getName(), flower.getType(), flower.getColor(), flower.getLength(),flower.getPrice()));

        database.closeConnection();
    }
    public void deleteFlower(int ID) throws SQLException
    {
        database = new Database(URL, LOGIN, PASSWORD);

        database.executeQuery(String.format("DELETE FROM flowers WHERE id=%d", ID));

        database.closeConnection();
    }

    public void updateFlower(int ID, Flower flower) throws SQLException
    {
        database = new Database(URL, LOGIN, PASSWORD);

        database.executeQuery(String.format("UPDATE flowers SET name='%s', type='%s', color='%s', length=%d, price=%d WHERE id=%d",
                flower.getName(), flower.getType(), flower.getColor(), flower.getLength(), flower.getPrice(), ID));

        database.closeConnection();
    }
}