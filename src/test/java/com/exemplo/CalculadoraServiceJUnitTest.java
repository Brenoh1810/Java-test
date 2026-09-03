package com.exemplo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Testes de Calculadora com JUnit 5")
class CalculadoraServiceJUnitTest {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
    }

    @Test
    @DisplayName("Deve somar dois números com sucesso")
    void testSomar() {
        int res = calc.somar(10, 5);
        assertEquals(15, res);
    }

    @Test
    @DisplayName("Deve lançar exceção ao dividir por zero")
    void testDivisaoZero() {
        assertThrows(ArithmeticException.class, () -> calc.dividir(10, 0));
    }

    @ParameterizedTest(name = "Soma de {0} + {1} deve ser {2}")
    @CsvSource({
        "1, 2, 3",
        "5, 5, 10"
    })
    void testParametrizado(int a, int b, int esperado) {
        assertEquals(esperado, calc.somar(a, b));
    }
}