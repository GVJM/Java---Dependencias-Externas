package br.com.letscode.dependencias.trabalhofinal.tiposdedados;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.Getter;
import lombok.Data;
import lombok.ToString;
import lombok.NonNull;

@Data public class ListagemDeAlunos {
    @Getter private HashMap<String,Aluno> listaDeAlunos = new HashMap<String,Aluno>();

    public void addAluno(@NonNull Aluno aluno){
        if(this.listaDeAlunos.containsKey(aluno.getNome())){
            
            for (String turma : this.listaDeAlunos.get(aluno.getNome()).getTurmas()) {
                aluno.addTurma(turma);    
            }
            
            this.listaDeAlunos.put(aluno.getNome(), aluno);
        } 
        else{
            this.listaDeAlunos.put(aluno.getNome(),aluno);
        }       
    }

    public void printLista(){
        List<String> sortedNameList = new ArrayList<String>(this.listaDeAlunos.keySet()) ;    
        Collections.sort(sortedNameList);
        for(String nome : sortedNameList){
            System.out.println(nome);
        }
    }

    public ListagemDeAlunos(){
    }
}