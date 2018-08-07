package com.hand.infra.mapper;

import com.hand.domain.entity.Film;
import org.apache.ibatis.annotations.Param;

public interface FilmMapper {

    Integer insertFilm(@Param("film")Film film);

    Film selectFilmById(@Param("id") int id);
}
