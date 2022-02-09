package br.com.letscode.dependencias.trabalhofinal.tiposdedados;

import java.util.ArrayList;


import lombok.NonNull;
import lombok.Getter;
import lombok.ToString;

@ToString public class Aluno {
    @Getter private final String nome;
    @Getter private ArrayList<String> turmas = new ArrayList<String>();
    
    Aluno(@NonNull String nome){
        this.nome = nome;
    }

    public void addTurma(@NonNull String nomeDaTurma){
        if ( (nomeDaTurma.equals("Java") && !this.hasTurma("Java")) || nomeDaTurma.equals("Banco de dados") && !this.hasTurma("Banco de dados")){
            this.turmas.add(nomeDaTurma);
        }
    }

    public boolean hasTurma(@NonNull String nomeDaTurma){
        if( this.turmas.contains(nomeDaTurma) ){
            return true;
        }
        else{
            return false;
        }
    }

}
