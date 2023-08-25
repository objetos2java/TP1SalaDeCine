package SalaDeCine;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SalaDeCineTest {
    private SalaDeCine sala;

    @BeforeEach
    public void setUp() {
        sala = new SalaDeCine(5, 6);
    }

    @Test
    public void testSalaVaciaInicialmente() {
        assertTrue(sala.estaVacia());
    }

    @Test
    public void testOcuparButaca() {
        assertFalse(sala.butacaOcupada(2, 3));
        sala.ocuparButaca(2, 3);
        assertTrue(sala.butacaOcupada(2, 3));
    }

    @Test
    public void testTotalButacasOcupadas() {
        sala.ocuparButaca(2, 3);
        sala.ocuparButaca(3, 4);
        sala.ocuparButaca(4, 2);
        assertEquals(3, sala.totalButacasOcupadas());
    }

    @Test
    public void testHayEspacioPara() {
        sala.ocuparButaca(0, 2);
        sala.ocuparButaca(0, 3);
        sala.ocuparButaca(1, 2);
        sala.ocuparButaca(1, 3);
        sala.ocuparButaca(2, 2);
        sala.ocuparButaca(2, 3);
        sala.ocuparButaca(3, 2);
        sala.ocuparButaca(3, 3);
        sala.ocuparButaca(4, 2);
        sala.ocuparButaca(4, 3);
        assertTrue(sala.hayEspacioPara(2)); 
        assertFalse(sala.hayEspacioPara(3));  
    }
}