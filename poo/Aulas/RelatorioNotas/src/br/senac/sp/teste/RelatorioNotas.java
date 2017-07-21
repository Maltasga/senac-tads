package br.senac.sp.teste;

import br.senac.sp.dao.NotaAlunoDao;
import br.senac.sp.model.NotaAluno;
import br.senac.sp.report.Relatorio;
import br.senac.sp.report.MediaAritmetica;
import br.senac.sp.report.Mediana;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Malta
 */
public class RelatorioNotas {

    public static void main(String[] args) {
        NotaAlunoDao dao = new NotaAlunoDao();
        ArrayList<Integer> notas = new ArrayList<>();
        Relatorio relAritimetica = new MediaAritmetica();
        Relatorio relMediana = new Mediana();
        
        try {
            for (NotaAluno n : dao.listar("notas-parte-2.txt")) {
                notas.add(n.getNota());
            }

            System.out.println(relAritimetica.calcularMedia(notas));
            System.out.println(relMediana.calcularMedia(notas));
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
