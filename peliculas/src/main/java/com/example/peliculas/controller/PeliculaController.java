package com.example.peliculas.controller;


import com.example.peliculas.model.pelicula;
import com.example.peliculas.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    // Obtener todas las películas
    @GetMapping
    public List<pelicula> obtenerPeliculas() {
        return peliculaService.obtenerTodasLasPeliculas();
    }

    // Obtener una película por su ID
    @GetMapping("/{id}")
    public Optional<pelicula> obtenerPeliculaPorId(@PathVariable Long id) {
        return peliculaService.obtenerPeliculaPorId(id);
    }

    // Crear una nueva película
    @PostMapping
    public pelicula crearPelicula(@RequestBody pelicula pelicula) {
        return peliculaService.guardarPelicula(pelicula);
    }

    // Actualizar una película existente
    @PutMapping("/{id}")
    public pelicula actualizarPelicula(@PathVariable Long id, @RequestBody pelicula pelicula) {
        return peliculaService.actualizarPelicula(id, pelicula);
    }

    // Eliminar una película
    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
    }
}
