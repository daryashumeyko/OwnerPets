package DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface PetDAO {   //интерфейс с объявлением методов
    /** Создает новую запись и соответствующий ей объект */
    Pet create(Pet pet) throws IOException, SQLException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    Pet read(int key) throws SQLException;

    /** Сохраняет состояние объекта group в базе данных */
   void update(Pet pet, int key) throws SQLException;

    /** Удаляет запись об объекте из базы данных */
   void delete(Pet pet) throws SQLException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    List<Pet> getAll() throws SQLException;
}
