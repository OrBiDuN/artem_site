package com.example.marketplace.Repository;

import com.example.marketplace.Object.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepositoty  extends CrudRepository<Film, Integer> {
    Object findAllById(Integer id);
}
