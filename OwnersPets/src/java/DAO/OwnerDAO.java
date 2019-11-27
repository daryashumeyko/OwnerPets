package DAO;

import entities.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OwnerDAO extends AbstractDAO <Integer, Owner>{
    @Override
    public List<Owner> getAll() {
        List<Owner> list = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement("select * from Owner;");

        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Owner owner = new Owner();
                owner.setId(rs.getLong(1));
                owner.setName(rs.getString(2));
                owner.setAddress(rs.getString(3));

                list.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return list;
    }

    
    @Override
    public boolean create(Owner owner) {
        PreparedStatement ps = getPrepareStatement("insert into Owner (name, address) VALUES (?, ?);");

        try {
            ps.setString(1, owner.getName());
            ps.setString(2, owner.getAddress());

            int result = ps.executeUpdate();
            if (result > 0) return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return false;
    }
 //   @Override
  //  public Pet getEntityById(Integer id) {
   //     Pet pet = new Pet();
    //    PreparedStatement ps = getPrepareStatement("select * from Orders where id=?;");

  //      try {
 //           ps.setInt(1, id);
   //         ResultSet rs = ps.executeQuery();
 //           if (rs.next()) {
         //       pet.setId(rs.getLong(1));
       //         pet.setName(rs.getString(2));
         //       //pet.setBirthDate(rs.getDate(3));
     //           pet.setType(rs.getString(4));
       //         pet.setPetOwnerId(rs.getLong(5));
   //         }

 //       } catch (SQLException e) {
  //          e.printStackTrace();
//        } finally {
      //      closePrepareStatement(ps);
    //    }
  //      return pet;
//    }

//    @Override
  //  public boolean update(Orders orders) {
    //    PreparedStatement ps = getPrepareStatement("update Orders  set orderNumber=?, personId=?, totalPrice=? WHERE id=?;");

        //try {
      //      ps.setString(1, orders.getOrderNumber());
    //        ps.setInt(2, orders.getPersonId());
  //          ps.setString(3, orders.getTotalPrice());
//            ps.setInt(4, orders.getId());

    //        int result = ps.executeUpdate();
  //          if (result>0) return true;
//
 //       } catch (SQLException e) {
   //         e.printStackTrace();
//    } finally {
//            closePrepareStatement(ps);
    //    }
  //      return false;
//    }

    //@Override
    //public boolean delete(Integer id) {
  //      PreparedStatement ps = getPrepareStatement("delete from Orders where id = ?;");
//
    //    try {
  //          ps.setInt(1, id);
//
    //        int result = ps.executeUpdate();
  //          if (result > 0) return true;
//
       // } catch (SQLException e) {
         //   e.printStackTrace();
       // } finally {
     //       closePrepareStatement(ps);
   //     }
 //       return false;
 //   }


}
