package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DAO.DAO.connectionClose;

public class MySQLPetDAO implements PetDAO {
    private final Connection connection;

    public MySQLPetDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Pet create(Pet pet){
        String query = "insert into pet (`name`, `BirthDate`, `type`, `pet_owner_id`) values (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, pet.getName());
            preparedStatement.setDate(2, new java.sql.Date(pet.getBirthDate().getTime()));
            preparedStatement.setString(3, pet.getType());
            preparedStatement.setLong(4, pet.getPetOwnerId());

            if (preparedStatement.executeUpdate() > 0) {
                PetDAO petDAO = new DAO().getPetDao(connection);
                System.out.println("Pet was create with id: " +
                        (int) (petDAO.getAll().get(petDAO.getAll().size() - 1)).getId());
                return pet;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Pet read(int key) throws SQLException {
        String query = "select * from pet where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, key);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        Pet pet = new Pet();
        pet.setId(resultSet.getInt("id"));
        pet.setName(resultSet.getString("name"));
        pet.setBirthDate(resultSet.getDate("birthDate").toString());
        pet.setType(resultSet.getString("type"));
        pet.setPetOwnerId(resultSet.getInt("pet_owner_id"));

        return pet;
    }

    @Override
    public void update(Pet pet, int key) {
        String query = "update pet set `name` = ?, `BirthDate` = ?, `pet_owner_id` = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, pet.getName());
            preparedStatement.setDate(2, new java.sql.Date(pet.getBirthDate().getTime()));
            preparedStatement.setLong(3, pet.getPetOwnerId());
            preparedStatement.setInt(4, key);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Owner was changed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Pet pet) throws SQLException {
        String query = "delete from pet where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try {
                preparedStatement.setObject(1, pet.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                throw new SQLException("On delete modify more then one record: " + count);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionClose(connection);
        }
    }

    @Override
    public List<Pet> getAll() throws SQLException {
        String query = "select * from pet";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Pet> list = new ArrayList<Pet>();
        Pet pet = new Pet();

        while (resultSet.next()){
            pet.setId(resultSet.getInt("id"));
            pet.setName(resultSet.getString("name"));
            pet.setBirthDate(resultSet.getDate("birthDate").toString());
            pet.setType(resultSet.getString("type"));
            pet.setPetOwnerId(resultSet.getInt("pet_owner_id"));

            list.add(pet);
        }
        return list;
    }
}
