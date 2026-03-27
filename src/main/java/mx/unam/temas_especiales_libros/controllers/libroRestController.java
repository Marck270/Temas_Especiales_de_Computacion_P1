package mx.unam.temas_especiales_libros.controllers;

import mx.unam.temas_especiales_libros.models.libro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1")
public class libroRestController {

    HashMap<Integer, libro> librosdb;

    public libroRestController() {
        librosdb = new HashMap<>();
        librosdb.put(1, new libro(1, "El nombre del viento", "Patrick Routfus", "Plaza Janes", "janes@gmail.com", BigDecimal.valueOf(650.00), "Fantasia Epica"));
        librosdb.put(2, new libro(2, "El Camino de los Reyes", "Brandon Sanderson", "Plaza Janes", "janes@gmail.com", BigDecimal.valueOf(850.00), "Fantasia Epica"));
        librosdb.put(3, new libro(3, "El Hombre en Busca del Sentido", "Victor Frankl", "Plaza Janes", "janes@gmail.com", BigDecimal.valueOf(150.00), "Autobiografia"));
    }

    @GetMapping("/")
    public ResponseEntity<HashMap<Integer, libro>> libros() {
        return new ResponseEntity<>(librosdb, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<libro> crearLibro(@RequestBody libro nuevoLibro) {
        int id = 1;
        while (librosdb.containsKey(id)) id++;

        nuevoLibro.setId(id);
        librosdb.put(id, nuevoLibro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<libro> actualizarLibro(@PathVariable int id, @RequestBody libro libroActualizado) {
        if (librosdb.containsKey(id)) {
            libroActualizado.setId(id);
            librosdb.put(id, libroActualizado);
            return new ResponseEntity<>(libroActualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<libro> modificarLibro(@PathVariable int id, @RequestBody libro camposModificados) {
        if (librosdb.containsKey(id)) {
            libro libroExistente = librosdb.get(id);

            if (camposModificados.getTitulo() != null) libroExistente.setTitulo(camposModificados.getTitulo());
            if (camposModificados.getAutor() != null) libroExistente.setAutor(camposModificados.getAutor());
            if (camposModificados.getEditorial() != null) libroExistente.setEditorial(camposModificados.getEditorial());
            if (camposModificados.getEmail_edutorial() != null) libroExistente.setEmail_edutorial(camposModificados.getEmail_edutorial());
            if (camposModificados.getPrecio() != null) libroExistente.setPrecio(camposModificados.getPrecio());
            if (camposModificados.getGenero() != null) libroExistente.setGenero(camposModificados.getGenero());

            return new ResponseEntity<>(libroExistente, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable int id) {
        if (librosdb.containsKey(id)) {
            librosdb.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}