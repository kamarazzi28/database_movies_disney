package dao;

import entities.Herci;
import java.util.List;

public interface HerciDao {
    void save(Herci herci);
    Herci findById(Long id);
    List<Herci> findAll();
    void delete(Herci herci);
}
