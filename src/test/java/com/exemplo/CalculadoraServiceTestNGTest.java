package com.exemplo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculadoraServiceTestNGTest {

    private Calculadora calc;

    @BeforeMethod
    public void setUp() {
        calc = new Calculadora();
    }

    @Test(description = "Deve somar dois números com sucesso")
    public void testSomar() {
        int res = calc.somar(10, 5);
        // Convenção do TestNG: Assert.assertEquals(atual, esperado)
        Assert.assertEquals(res, 15);
    }

    @Test(
        description = "Deve lançar exceção ao dividir por zero",
        expectedExceptions = ArithmeticException.class
    )
    public void testDivisaoZero() {
        calc.dividir(10, 0);
    }

    @DataProvider(name = "dadosParaSoma")
    public Object[][] fornecerDados() {
        return new Object[][] {
            { 1, 2, 3 },
            { 5, 5, 10 }
        };
    }

    @Test(dataProvider = "dadosParaSoma")
    public void testParametrizado(int a, int b, int esperado) {
        Assert.assertEquals(calc.somar(a, b), esperado);
    }
}