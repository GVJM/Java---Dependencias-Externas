package br.com.letscode.dependencias.trabalhofinal.tiposdedados;

import java.util.HashMap;


import lombok.NonNull;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.Data;
import lombok.ToString;

@Data public class Aluno {
    private final String nome;
    private HashMap<String,Boolean> turmas=new HashMap<String,Boolean>();
    
    public Aluno(@NonNull String nome){
        this.nome = nome;
    }

    public void addTurma(@NonNull String nomeDaTurma){
        if (nomeDaTurma.equals("Java")||nomeDaTurma.equals("Banco de dados")){
            turmas.put(nomeDaTurma,true);
        }
    }
}
