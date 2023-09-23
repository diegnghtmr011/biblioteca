/**
 * Prueba de la clase Libro para asegurar su correcto funcionamiento.
 * 
 * @author Área de programación UQ - Diego Flores
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */

package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class LibroTest {

    private static final Logger LOG = Logger.getLogger(LibroTest.class.getName());

    @Test

    public void crearLibro() {

        LOG.info("Incicia prueba de creación de libros");

        /**
         * Libro libro1 = new Libro("deed","Juan Esteban Maya","Obo
         * quindiano","Romance",200,LocalDate.of(2023,9,04),"978-987-25620-2-1");
         * Libro libro2 = new Libro("50 sombras de Josué","Daniel Josué","Obo
         * quindiano","Terror",169,LocalDate.of(2021,9,03),"978-987-25620-2-1");
         * Libro libro3 = new Libro("Josué y los 7 enanitos","Josué Daniel","Obo
         * quindiano","Drama",200,LocalDate.of(2019,7,22),"978-987-25620-2-1");
         * Libro libro4 = new Libro("Maya y la piedra filosofal","Juan Esteban
         * Maya","Obo quindiano","Para
         * niños",204,LocalDate.of(2022,8,20),"978-987-25620-2-1ee");
         * Libro libro5 = new Libro("Mil y una noches con Diego","Diego Alexander
         * Quintero","Obo
         * quindiano","Ficción",250,LocalDate.of(2017,8,19),"978-987-25620-2-1");
         **/
        Libro libro2 = new Libro("50 sombras de Josué", new Autor("Daniel", "DeLuque", "Alemana"), "Obo quindiano",
                TipoGenero.NARRATIVO, 169, LocalDate.of(2022, 9, 03), "978-987-25620-2-1");
        /**
         * boolean isPalindrome = libro1.verificarNombrePalindroma();
         * boolean vocalesSeguidas = libro4.verificarVocalesSeguidas();
         * System.out.println(isPalindrome);
         * System.out.println(vocalesSeguidas);
         * 
         * assertTrue(isPalindrome, "Resultado ok");
         * 
         * assertTrue(vocalesSeguidas, "Resultado ok");
         **/

        assertThrows(
                Throwable.class, () -> new Libro("50 sombras de Josué", new Autor("Daniel", "DeLuque", "Alemana"),
                        "Obo quindiano", TipoGenero.NARRATIVO, 169, LocalDate.of(2028, 9, 03), "978-987-25620-2-1"),
                "Wrong");

        assertEquals("50 sombras de Josué", libro2.getNombre());

        LOG.info("Fin prueba creación de libros");

    }

}