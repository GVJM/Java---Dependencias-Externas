package br.com.letscode.dependencias.trabalhofinal.tiposdedados;

import br.com.letscode.dependencias.trabalhofinal.tiposdedados.Aluno;

import java.util.HashMap;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.Getter;
import lombok.Data;
import lombok.ToString;
import lombok.NonNull;

public class ListagemDeAlunos {
    @Getter private HashMap<String,Aluno> listaDeAlunos = new HashMap<String,Aluno>();

    public void addAluno(@NonNull Aluno aluno){
        if(this.listaDeAlunos.containsKey(aluno.getNome())){
            
            for (String turma : this.listaDeAlunos.get(aluno.getTurmas()).getTurmas()) {
                aluno.addTurma(turma);    
            }
            
            this.listaDeAlunos.put(aluno.getNome(), aluno);
        } 
        else{
            this.listaDeAlunos.put(aluno.getNome(),aluno);
        }       
    }

    


    public ListagemDeAlunos(){
    }
}