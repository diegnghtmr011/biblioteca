/**
 * Clase que representa un Autor de libros, con su nombre, apellido y nacionalidad.
 * 
 * @author Área de programación UQ - Diego Flores
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */

package co.edu.uniquindio.poo;

public record Autor(String nombre, String apellido, String nacionalidad){
    public Autor{
        assert nombre != null && !nombre.isBlank() : "El nombre es requerido";
        assert apellido != null && !apellido.isBlank() : "El apellido es requerido";
        assert nacionalidad != null && !nacionalidad.isBlank() : "La nacionalidad es requerida";
    }
}
