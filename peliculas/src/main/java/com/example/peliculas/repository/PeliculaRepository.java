package com.example.peliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.peliculas.model.pelicula;

public interface PeliculaRepository extends JpaRepository<pelicula, Long>{
    
}