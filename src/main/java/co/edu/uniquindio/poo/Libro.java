/**
 * Clase que representa un Libro con información detallada como nombre, autor, editorial, género, número de páginas, fecha de publicación y ISBN.
 * 
 * @author Área de programación UQ - Diego Flores
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */

package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Libro {

    private String nombre;
    private Autor autor;
    private String editorial;
    private TipoGenero genero;
    private int numDePaginas;
    private LocalDate fechaPublicacion;
    private String isbn;

    public Libro(String nombre, Autor autor, String editorial, TipoGenero genero, int numDePaginas,
            LocalDate fechaPublicacion, String isbn) {
        assert nombre != null && !nombre.isBlank() : "El nombre es requerido";
        assert editorial != null && !editorial.isBlank() : "La editorial es requerida";
        assert numDePaginas > 0 : "El numero de paginas es requerido";
        assert fechaPublicacion != null && fechaPublicacion.isBefore(LocalDate.now().plusDays(1))
                : "La fecha de publicacion es requerida y no puede ser futura";
        assert isbn != null && !isbn.isBlank() : "El ISBN es requerido";
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.numDePaginas = numDePaginas;
        this.fechaPublicacion = fechaPublicacion;
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public TipoGenero getGenero() {
        return genero;
    }

    public int getNumeroDePaginas() {
        return numDePaginas;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setGenero(TipoGenero genero) {
        this.genero = genero;
    }

    public void setNumDePaginas(int numDePaginas) {
        this.numDePaginas = numDePaginas;

    }

    public void setFechaDePublicacion(LocalDate fechaDePublicacion) {
        this.fechaPublicacion = fechaDePublicacion;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro [nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", genero=" + genero
                + ", numDePaginas=" + numDePaginas + ", fechaPublicacion=" + fechaPublicacion + ", isbn=" + isbn + "]";
    }

    /**
     * Verifica si el nombre del libro es un palíndromo.
     * 
     * @return True si el nombre es un palíndromo, False en caso contrario.
     */
    public boolean verificarNombrePalindroma() {
        String invertida = "";
        for (int i = nombre.length() - 1; i >= 0; i--) {
            invertida += nombre.charAt(i);
        }
        return invertida.equals(nombre);
    }

    /**
     * Verifica si el ISBN del libro contiene vocales seguidas.
     * 
     * @return True si el ISBN contiene vocales seguidas, False en caso contrario.
     */
    public boolean verificarVocalesSeguidas() {
        // scope/alcance
        // String mensaje = "";
        boolean tieneVocalesSeguidas = false;
        for (int i = 0; i < isbn.length() - 1 || tieneVocalesSeguidas; i++) {
            String lowerIsbn = isbn.toLowerCase();
            char charInicial = lowerIsbn.charAt(i);
            char charPosterior = lowerIsbn.charAt(i + 1);
            if (esVocal(charInicial) && esVocal(charPosterior)) {
                tieneVocalesSeguidas = true;
                // mensaje += "Hay 2 vocales seguidas";
                return tieneVocalesSeguidas;
            }
        }
        // mensaje += "No hay vocales seguidas";
        return tieneVocalesSeguidas;
    }

    /**
     * Verifica si un carácter es una vocal.
     * 
     * @param vocal El carácter a verificar.
     * @return True si es una vocal, False en caso contrario.
     */
    public boolean esVocal(char vocal) {
        return vocal == 'a' || vocal == 'e' || vocal == 'i' || vocal == 'o' || vocal == 'u';
    }

    /**
     * Sobrescribe el método equals para comparar dos objetos Libro.
     * 
     * @param obj El objeto a comparar.
     * @return True si los objetos son iguales, False en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Libro other = (Libro) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        if (editorial == null) {
            if (other.editorial != null)
                return false;
        } else if (!editorial.equals(other.editorial))
            return false;
        if (genero == null) {
            if (other.genero != null)
                return false;
        } else if (!genero.equals(other.genero))
            return false;
        if (numDePaginas != other.numDePaginas)
            return false;
        if (fechaPublicacion == null) {
            if (other.fechaPublicacion != null)
                return false;
        } else if (!fechaPublicacion.equals(other.fechaPublicacion))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }
}