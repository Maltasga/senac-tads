package br.senac.sp.report;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Malta
 */
public class MediaAritmetica implements Relatorio {

    @Override
    public String calcularMedia(ArrayList<Integer> notas) {
        try {
            int somaNotas = 0, media;
            for (int i : notas) {
                somaNotas += i;
            }
            media = somaNotas / notas.size();
            return "Média: " + media;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

}
