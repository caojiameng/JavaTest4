package com.hand.api.service.Impl;

import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import com.hand.infra.mapper.FilmMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class FilmServiceImpl implements FilmService {
    FilmMapper filmMapper;

    public void setFilmMapper(FilmMapper filmMapper) {
        this.filmMapper = filmMapper;
    }
    @Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    @Override
    public int insertFilm(Film film) {
        return  filmMapper.insertFilm(film);
    }
    @Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    @Override
    public Film selectFilm(Integer id) {
        return filmMapper.selectFilmById(id);
    }
}
