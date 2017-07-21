package br.malta.encapsulamento;

/**
 *
 * @author Gabriel Malta
 */
public class ImpostoTest {

    public static void main(String[] args) {
        Imposto i = new Imposto(0.06);
        double impostoSobre = i.calcular(500);
        System.out.println("Imposto sobre R$ 500,00: " + impostoSobre);
    }
}
