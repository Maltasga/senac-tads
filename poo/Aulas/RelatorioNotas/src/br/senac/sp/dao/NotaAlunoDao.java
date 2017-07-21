package br.senac.sp.dao;

import br.senac.sp.model.NotaAluno;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gabriel Malta
 */
public class NotaAlunoDao {

    public ArrayList<NotaAluno> listar(String arquivo) throws Exception {
        ArrayList<NotaAluno> lista = new ArrayList<>();

        Scanner scanner;
        try {
            URL resource = getClass().getResource(arquivo);
            scanner = new Scanner(new FileReader(resource.getFile()))
                    .useDelimiter("\\t|\\n");
            while (scanner.hasNext()) {
                String nome = scanner.next();
                int nota = scanner.nextInt();
                lista.add(new NotaAluno(nome, nota));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new Exception("Não foi possível realizar a leitura das notas");
        }
        return lista;
    }
}
