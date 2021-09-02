package com.nproblem.dao;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nproblem.entity.Film;

@Repository
public interface FilmDao extends JpaRepository<Film, Integer> {
	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "language", "filmActors", "filmActors.actor" })
	Page<Film> findAll(Pageable pageable);

}
