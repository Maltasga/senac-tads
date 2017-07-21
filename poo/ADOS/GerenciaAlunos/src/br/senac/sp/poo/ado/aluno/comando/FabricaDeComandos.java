package br.senac.sp.poo.ado.aluno.comando;

import br.senac.sp.poo.ado.aluno.Faculdade;
import java.util.HashMap;
import java.util.Scanner;

public class FabricaDeComandos {

    private HashMap<Integer, Comando> comandos;

    public FabricaDeComandos(Faculdade faculdade, Scanner scanner) {
        comandos = new HashMap<Integer, Comando>();

        comandos.put(0, new SemAcaoComando());
        comandos.put(2, new MenuComando());
        comandos.put(1, new ConsultarAlunoComando(faculdade, scanner));
        comandos.put(3, new MatricularAlunoComando(faculdade, scanner));
        comandos.put(4, new ListarAlunosMatriculadosComando(faculdade));
        comandos.put(5, new AtualizarCadastroAlunoComando(faculdade, scanner));
        comandos.put(6, new RemoverMatriculaComando(faculdade, scanner));
        comandos.put(7, new EncerrarComando());
    }

    public Comando criar(Integer operacao) {
        return comandos.get(operacao);
    }
}
