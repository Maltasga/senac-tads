package br.senac.sp.poo.ado;

import br.senac.sp.poo.ado.aluno.AlunoDao;
import br.senac.sp.poo.ado.aluno.AlunoDaoImpl;
import br.senac.sp.poo.ado.aluno.Faculdade;
import br.senac.sp.poo.ado.aluno.comando.FabricaDeComandos;
import java.util.Scanner;

public class GerenciamentoFaculdade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AlunoDao alunoDao = new AlunoDaoImpl();
        Faculdade faculdade = new Faculdade(alunoDao);
        FabricaDeComandos fabricaDeComando = new FabricaDeComandos(faculdade, scanner);

        fabricaDeComando.criar(0);
        while (true) {
            System.out.print("Digite o número da operação: ");
            fabricaDeComando.criar(scanner.nextInt()).executar();
        }

    }
}
