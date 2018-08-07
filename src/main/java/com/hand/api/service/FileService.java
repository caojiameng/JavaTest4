package com.hand.api.service;

import com.hand.domain.entity.Film;
import com.hand.infra.mapper.FilmMapper;

public interface FilmService {
    public int insertFilm(Film film);
    public Film selectFilm(Integer id);
}
