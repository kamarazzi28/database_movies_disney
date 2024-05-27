package dao;

import entities.Sequely;
import java.util.List;

public interface SequelyDao {
    void save(Sequely sequely);
    Sequely findById(Long id);
    List<Sequely> findAll();
    void delete(Sequely sequely);
}
