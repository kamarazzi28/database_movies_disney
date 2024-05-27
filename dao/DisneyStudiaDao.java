package dao;

import entities.DisneyStudia;
import java.util.List;

public interface DisneyStudiaDao {
    void save(DisneyStudia disneyStudia);
    DisneyStudia findById(String nazevStudia);
    List<DisneyStudia> findAll();
    void delete(DisneyStudia disneyStudia);
}
