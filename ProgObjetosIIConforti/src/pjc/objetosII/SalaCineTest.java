/**
 * 
 */
package pjc.objetosII;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaCineTest {

    private SalaDeCine sala;

    @BeforeEach
    public void setUp() {
        sala = new SalaDeCine(5, 7); // Crear una sala de 5 filas y 7 butacas por fila
    }

    @Test
    public void testSalaVacia() {
        assertTrue(sala.estaVacia());
    }

    @Test
    public void testOcuparButaca() {
        assertTrue(sala.ocuparButaca(2, 3)); // Ocupar butaca en la fila 2 y asiento 3
        assertFalse(sala.estaVacia());
        assertFalse(sala.ocuparButaca(2, 3)); // Intentar ocupar la misma butaca nuevamente
    }

    @Test
    public void testTotalButacasOcupadas() {
        sala.ocuparButaca(1, 2);
        sala.ocuparButaca(3, 4);
        assertEquals(2, sala.totalButacasOcupadas());
    }
    
    @Test
    public void testHayEspacioPara() {
    	sala.ocuparButaca(0, 2);
    	sala.ocuparButaca(1, 2);
    	sala.ocuparButaca(2, 2);
    	sala.ocuparButaca(3, 2);
    	sala.ocuparButaca(4, 2);
    	sala.mostrarOcupacion();
        assertTrue(sala.hayEspacioPara(2)); // Hay espacio para 2 personas contiguas en cualquier fila
        assertTrue(sala.hayEspacioPara(3)); // Hay espacio para 3 personas contiguas en cualquier fila
        assertFalse(sala.hayEspacioPara(5)); // No hay espacio para 4 personas contiguas en ninguna fila
      
    }

    @Test
    public void testButacaInvalida() {
        assertFalse(sala.ocuparButaca(5, 7)); // Intentar ocupar una butaca fuera de los límites
        assertFalse(sala.estaOcupada(-1, 3)); // Consultar butaca inválida (fila negativa)
        assertFalse(sala.estaOcupada(3, 10)); // Consultar butaca inválida (asiento fuera de límites)
    }
    
}
