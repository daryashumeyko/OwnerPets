package DAO;

import java.sql.*;
import java.util.List;


public abstract class AbstractDAO <K extends Number, E> {
    private Connection connection;
    
    public abstract List<E> getAll();
 //   public abstract E getEntityById(K id);
 //   public abstract boolean update(E entity);
 //   public abstract boolean delete(K id);
    public abstract boolean create(E entity);
    
    public AbstractDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("Произошла ошибка при загрузке MySQL драйвера.");
        }
        
        try {
            connection = DriverManager.getConnection(ConnectionProperties.URL, ConnectionProperties.USER, ConnectionProperties.PASSWORD);
        } catch (SQLException e) {
            System.out.println("Не удалось установить соединение с БД");
            e.printStackTrace();
        }
    }
    
    // Получение экземпляра PrepareStatement
    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    // Закрытие PrepareStatement
    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void closeConnection(){
         if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("");
                e.printStackTrace();
            }
        }
    }
}
