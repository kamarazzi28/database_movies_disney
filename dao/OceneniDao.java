package dao;

import entities.Oceneni;
import java.util.List;

public interface OceneniDao {
    void save(Oceneni oceneni);
    Oceneni findById(Long id);
    List<Oceneni> findAll();
}
