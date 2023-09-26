/**
 * Clase que representa una Biblioteca y gestiona la colección de libros.
 * 
 * @author Área de programación UQ - Diego Flores
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */

package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

public class Biblioteca {
    private final String nombreBiblioteca;
    private final Collection<Libro> listaLibros;
    private final int limiteCantidadLibros;

    public Biblioteca(String nombreBiblioteca, int limiteCantidadLibros) {
        assert nombreBiblioteca != null && !nombreBiblioteca.isBlank() : "El nombre es requerido";
        assert limiteCantidadLibros > 0;
        this.nombreBiblioteca = nombreBiblioteca;
        this.limiteCantidadLibros = limiteCantidadLibros;
        this.listaLibros = new LinkedList<Libro>();
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public Collection<Libro> getListaLibros() {
        return Collections.unmodifiableCollection(listaLibros);
    }


    public int getLimiteCantidadLibros() {
        return limiteCantidadLibros;
    }

    /**
     * Registra un nuevo libro en la biblioteca, si no existe un libro con el mismo
     * nombre o editorial.
     * 
     * @param libro El libro a registrar.
     */
    public void registrarLibro(Libro libro) {
        validarLibroExistente(libro);
        listaLibros.add(libro);
    }

    /**
     * Valida si un libro ya existe en la biblioteca por su nombre y editorial.
     * 
     * @param libro El libro a validar.
     */
    public void validarLibroExistente(Libro libro) {
        boolean nombreLibroExistente = buscarlistaLibrosPorNombre(libro.getNombre()).isPresent();
        boolean editorialExistente = buscarlistaLibrosPorEditorial(libro.getEditorial()).isPresent();
        assert !nombreLibroExistente || !editorialExistente : "El libro ya esta registrado";
    }

    /**
     * Busca un libro en la biblioteca por su nombre.
     * 
     * @param nombreLibro El nombre del libro a buscar.
     * @return Un Optional que contiene el libro si se encuentra, o vacío si no.
     */
    public Optional<Libro> buscarlistaLibrosPorNombre(String nombreLibro) {
        Predicate<Libro> condicion = libro -> libro.getNombre().equals(nombreLibro);
        return listaLibros.stream().filter(condicion).findAny();
    }

    /**
     * Busca un libro en la biblioteca por su editorial.
     * 
     * @param nombreEditorial El nombre de la editorial del libro a buscar.
     * @return Un Optional que contiene el libro si se encuentra, o vacío si no.
     */
    public Optional<Libro> buscarlistaLibrosPorEditorial(String nombreEditorial) {
        Predicate<Libro> condicion = libro -> libro.getEditorial().equals(nombreEditorial);
        return listaLibros.stream().filter(condicion).findAny();
    }
}
