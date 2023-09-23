/**
 * Prueba de la clase Autor para asegurar su correcto funcionamiento.
 * 
 * @author Área de programación UQ - Diego Flores
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */

package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class AutorTest {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(AutorTest.class.getName());
    
    /**
     * Prueba para verificar el registro de un Autor.
     */
    @Test
    public void registrarEquipo() {
        LOG.info("Inicio de prueba registrarEquipo...");

        Autor autor = new Autor("Nicolas", "Quiso", "Mexico");
        assertEquals("Nicolas", autor.nombre());

        LOG.info("Fin de prueba registrarEquipo...");
    }

}
