import java.sql.*;

/**
 * @author Evgeniy Govorushkin
 * @version 1.0
 */

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/weather_bot?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true\" +\n" +
            "                    \"&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456789";

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    //Запись данных в БД
    public void writeToDb(Long chatId, String userName, String firstName, String lastName, Float latitude, Float lontitude) throws SQLException {
        boolean isUserExists = false;
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        //проверка на существующую запись
        statement = connection.prepareStatement("SELECT chat_id FROM subscribers WHERE chat_id=?");
        statement.setLong(1, chatId);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            isUserExists = true;
        }
        if (isUserExists) {
            System.out.println("Пользователь уже существует.");

        } else {//добавление нового подписчика
            String sql = "INSERT INTO subscribers(chat_id, username, firstname, lastname, latitude, longitude) " +
                    "VALUES(?, ?, ?, ?, ?, ? ) ";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, chatId);
            statement.setString(2, userName);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setFloat(5, latitude);
            statement.setFloat(6, lontitude);

            statement.executeUpdate();
            System.out.println("Добавлен новый подписчик.");
        }
    }

    //Чтение координат из БД (широта)
    public Float readLatitude(Long chatId) throws SQLException {
        Float lat = null;
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String sql = "SELECT latitude FROM subscribers WHERE chat_id = ?";
        statement = connection.prepareStatement(sql);
        statement.setLong(1, chatId);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            lat = resultSet.getFloat("latitude");
        }
        return lat;
    }

    //Чтение координат из БД (долгота)
    public Float readLongitude(Long chatId) throws SQLException {
        Float lat = null;
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String sql = "SELECT longitude FROM subscribers WHERE chat_id = ?";
        statement = connection.prepareStatement(sql);
        statement.setLong(1, chatId);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            lat = resultSet.getFloat("longitude");
        }
        return lat;
    }

    //Удаление записи из БД
    public void deleteFromDb(Long chatId) throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql = "DELETE FROM subscribers WHERE chat_id = ?";
        statement = connection.prepareStatement(sql);
        statement.setLong(1, chatId);
        statement.executeUpdate();
    }

}
