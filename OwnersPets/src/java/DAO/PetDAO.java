package DAO;

import entities.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PetDAO extends AbstractDAO <Integer, Pet>{
    @Override
    public List<Pet> getAll() {
        List<Pet> list = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement("select * from Pet;");

        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getLong(1));
                pet.setName(rs.getString(2));
                pet.setBirthDate(rs.getDate(3).toString());
                pet.setType(rs.getString(4));
                pet.setPetOwnerId(rs.getLong(5)); 
                
                list.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return list;
    }

    
    @Override
    public boolean create(Pet pet) {
        PreparedStatement ps = getPrepareStatement("insert into Pet (name, birthDate, type, petOwnerId) VALUES (?, ?, ?, ?);");

        try {
            ps.setString(1, pet.getName());
            ps.setDate(2, new java.sql.Date(pet.getBirthDate().getTime()));
            ps.setString(3, pet.getType());
            ps.setLong(4, pet.getPetOwnerId());

            int result = ps.executeUpdate();
            if (result > 0) return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return false;
    }
}
