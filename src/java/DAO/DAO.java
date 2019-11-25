package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DAO {

    private String driver = "com.mysql.jdbc.Driver";//Имя драйвера
    
    //Меняем способ подключения к бд – в рамках сервера приложений вместо менеджера JDBC-драйверов используем источник данных.
    public Connection getConnection() throws SQLException, NamingException {
        InitialContext ctx = new InitialContext(); 
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/clients"); 
        Connection conn = ds.getConnection(); 
        return conn;
    }

    public OwnerDAO getOwnerDao(Connection connection) {
        return new MySQLOwnerDAO(connection);
    }  //объект доступа к таблице owner

    public PetDAO getPetDao(Connection connection) {
        return new MySQLPetDAO(connection);
    }
    //объект доступа к таблице pet

    public static void connectionClose(Connection connection) throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
        }
    }

    public DAO() {
        try {
            Class.forName(driver);  //Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
