package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLOwnerDAO implements OwnerDAO {
    private final Connection connection;

    public MySQLOwnerDAO(Connection connection) {
        this.connection = connection;
    }
    //конструктор сохраняет соединение для дальнейшего использования в своих запросах

    @Override
    public Owner create(Owner owner) throws IOException, SQLException {
        String query = "insert into owner (`name`, `address`) values (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);  //подготовка запроса
            preparedStatement.setString(1, owner.getName());
            preparedStatement.setString(2, owner.getAddress());

            if (preparedStatement.execute()) {
                OwnerDAO ownerDAO = new DAO().getOwnerDao(connection);
                System.out.println("Owner was create with id: " +
                        (int) (ownerDAO.getAll().get(ownerDAO.getAll().size() - 1)).getId());
                return owner;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Owner read(int key) throws SQLException {
            String query = "select * from owner where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Owner owner = new Owner();
            owner.setId(resultSet.getInt("id"));
            owner.setName(resultSet.getString("name"));
            owner.setAddress(resultSet.getString("address"));

            return owner;
    }

    @Override
    public void update(Owner owner, int key) {
        String name = owner.getName();
        String query = "update owner set `name` = ?, `address` = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, owner.getName());
            preparedStatement.setString(2, owner.getAddress());
            preparedStatement.setInt(3, key);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Owner was changed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Owner owner) throws SQLException {
        String query = "delete from owner where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try {
                preparedStatement.setObject(1, owner.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                throw new SQLException("On delete modify more then 1 record: " + count);
            }
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Owner> getAll() throws SQLException {

        String query = "select * from owner";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Owner> list = new ArrayList<Owner>();
        Owner owner = new Owner();

        while (resultSet.next()) {
            owner.setId(resultSet.getInt("id"));
            owner.setName(resultSet.getString("name"));
            owner.setAddress(resultSet.getString("address"));

            list.add(owner);
        }
        return list;
    }
}
