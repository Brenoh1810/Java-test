import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FreteTestNGTest {

    private final Frete frete = new Frete();

    @Test
    public void freteGratisNoLimite() {
        Assert.assertEquals(frete.calcular(200), 0);
    }

    @DataProvider(name = "compras")
    public Object[][] compras() {
        return new Object[][] {
            {0, 20},
            {199, 20},
            {200, 0},
            {350, 0}
        };
    }

    @Test(dataProvider = "compras")
    public void calculaFrete(int compra, int esperado) {
        Assert.assertEquals(frete.calcular(compra), esperado);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void rejeitaNegativo() {
        frete.calcular(-1);
    }
}