package br.senac.sp.poo.ado.aluno.comando;

public class EncerrarComando implements Comando {

    @Override
    public void executar() {
        System.out.println("Sistema Encerrado!");
        System.exit(0);
    }

}
