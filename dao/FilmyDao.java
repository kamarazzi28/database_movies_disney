package dao;

import entities.Filmy;

import java.util.List;

public interface FilmyDao {
    void save(Filmy filmy);
    Filmy findById(Long id);
    List<Filmy> findAll();
    void delete(Filmy filmy);
}
