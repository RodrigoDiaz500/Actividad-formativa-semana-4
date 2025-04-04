package com.example.peliculas.service;

import com.example.peliculas.model.pelicula;
import com.example.peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    // Obtener todas las películas
    public List<pelicula> obtenerTodasLasPeliculas() {
        return peliculaRepository.findAll();
    }

    // Obtener una película por su ID
    public Optional<pelicula> obtenerPeliculaPorId(Long id) {
        return peliculaRepository.findById(id);
    }

    // Guardar una nueva película
    public pelicula guardarPelicula(pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    // Actualizar una película existente
    public pelicula actualizarPelicula(Long id, pelicula pelicula) {
        if (peliculaRepository.existsById(id)) {
            pelicula.setId(id);
            return peliculaRepository.save(pelicula);
        }
        return null; // Si no existe la película con ese ID, no se actualiza
    }

    // Eliminar una película
    public void eliminarPelicula(Long id) {
        peliculaRepository.deleteById(id);
    }
}
