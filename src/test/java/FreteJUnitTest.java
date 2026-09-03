import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FreteJUnitTest {

    private final Frete frete = new Frete();

    @Test
    void freteGratisNoLimite() {
        assertEquals(0, frete.calcular(200));
    }

    @ParameterizedTest
    @CsvSource({
        "0, 20",
        "199, 20",
        "200, 0",
        "350, 0"
    })
    void calculaFrete(int compra, int esperado) {
        assertEquals(esperado, frete.calcular(compra));
    }

    @Test
    void rejeitaNegativo() {
        assertThrows(IllegalArgumentException.class, () -> frete.calcular(-1));
    }
}