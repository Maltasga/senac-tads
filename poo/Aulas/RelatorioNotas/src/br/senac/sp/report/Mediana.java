package br.senac.sp.report;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Malta
 */
public class Mediana implements Relatorio {

    @Override
    public String calcularMedia(ArrayList<Integer> notas) {
        try {
            int meio;

            if (notas.size() % 2 == 0) {
                meio = (((notas.size() / 2) - 1) + (notas.size() / 2) / 2);
            } else {
                meio = (notas.size() / 2) + 1;
            }

            return "Mediana: " + notas.get(meio);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

}
