/**
 * Prueba de la clase Biblioteca para asegurar su correcto funcionamiento.
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

public class BibliotecaTest {

    private static final Logger LOG = Logger.getLogger(BibliotecaTest.class.getName());

    /**
     * Prueba para verificar la creación de un Libro con datos completos.
     */
    @Test
    public void datosCompletos() {
        LOG.info("Inicio de prueba datos completos...");

        Libro libro = new Libro("50 sombras de Josué", new Autor("Daniel", "DeLuque", "Alemania"), "Obo quindiano",
                TipoGenero.NARRATIVO, 169, LocalDate.of(2023, 9, 03), "978-987-25620-2-1");
        assertEquals("50 sombras de Josué", libro.getNombre());

        LOG.info("Fin de prueba datos completos...");
    }

    /**
     * Prueba para verificar la creación de un Libro con datos nulos.
     */
    @Test
    public void datosNulos() {
        LOG.info("Inicio de prueba datos nulos...");
        // Almacenar los datos de prueba null|null|null|null|24|0|0|null|LOCAL
        assertThrows(Throwable.class, () -> new Libro(null, null, null, null, 0, null, null));

        LOG.info("Fin de prueba datos nulos...");
    }

    /**
     * Prueba para verificar la creación de un Libro con datos nulos.
     */
    @Test
    public void numeroDePaginasNegativos() {
        LOG.info("Inicio de prueba número de paginas negativo...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-08-01|2023-09-15|-24|0|0|LOCAL
        assertThrows(Throwable.class, ()-> new Libro("50 sombras de Josué", new Autor("Daniel", "DeLuque", "Alemania"), "Obo quindiano", TipoGenero.NARRATIVO, -169, LocalDate.of(2023, 9, 03), "978-987-25620-2-1"));
        
        LOG.info("Fin de prueba número de paginas negativo...");
    }

    /**
     * Prueba para verificar la creación de una Biblioteca con un límite de cantidad de libros negativo.
     */
    @Test
    public void limiteCantidadLibrosNegativo() {
        LOG.info("Inicio de prueba limites de edades negativo...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-08-01|2023-09-15|24|-1|0|LOCAL
        assertThrows(Throwable.class, ()-> new Biblioteca("Si pero No", -100));
        
        LOG.info("Fin de prueba  limites de edades negativo...");
    }

}
