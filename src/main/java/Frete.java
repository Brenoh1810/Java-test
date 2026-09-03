public class Frete {

    public int calcular(int valorCompra) {
        if (valorCompra < 0) {
            throw new IllegalArgumentException("Valor invalido");
        }
        return valorCompra >= 200 ? 0 : 20;
    }

    public static void main(String[] args) {
        Frete frete = new Frete();
        int[] compras = {0, 199, 200, 201, 350};

        for (int compra : compras) {
            System.out.println("Compra: " + compra + " - Frete: " + frete.calcular(compra));
        }

        try {
            frete.calcular(-1);
        } catch (IllegalArgumentException exception) {
            System.out.println("Excecao capturada: " + exception.getMessage());
        }
    }
}