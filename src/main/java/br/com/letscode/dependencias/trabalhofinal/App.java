package br.com.letscode.dependencias.trabalhofinal;

import br.com.letscode.dependencias.trabalhofinal.tiposdedados.*;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] turmaJava = {
            "Alexandre Martins",
            "Vitor Hugo Lima",
            "Esther Rodrigues",
            "Lavínia Cunha",
            "Natália Gomes",
            "Yago Ramos",
            "Letícia Cunha",
            "Srta. Ana Júlia Ramos",
            "Pietra Martins",
            "Thomas Peixoto",
            "Thales Farias"
        };

        String[] turmaBD = {
            "Vitor Hugo Lima",
            "Esther Rodrigues",
            "Nathan Nascimento",
            "Lavínia Cunha",
            "Natália Gomes",
            "Dra. Lavínia Lopes",
            "Yago Ramos",
            "Letícia Cunha",
            "Luiz Miguel Azevedo",
            "Srta. Ana Júlia Ramos",
            "Thales Farias",
            "Dra. Alana Porto"
        };

        ListagemDeAlunos lista = new ListagemDeAlunos();

        for( String nome : turmaJava){
            Aluno aluno = new Aluno(nome);
            aluno.addTurma("Java");
            lista.addAluno(aluno);
        }

        for( String nome : turmaBD){
            Aluno aluno = new Aluno(nome);
            aluno.addTurma("Banco de dados");
            lista.addAluno(aluno);
        }

        lista.printLista();
    }
}
