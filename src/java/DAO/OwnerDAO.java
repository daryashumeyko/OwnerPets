package DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface OwnerDAO {   //интерфейс с объявлением методов
    /** Создает новую запись и соответствующий ей объект*/
    Owner create(Owner owner) throws IOException, SQLException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    Owner read(int key) throws SQLException;

    /** Сохраняет состояние объекта group в базе данных */
    void update(Owner owner, int key);

    /** Удаляет запись об объекте из базы данных */
    void delete(Owner owner) throws SQLException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    List<Owner> getAll() throws SQLException;
}
