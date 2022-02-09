package br.com.letscode.dependencias.trabalhofinal.tiposdedados;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

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

    public void allStudentsToTxt(String fileName){
        
        try{
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.newLine();
            bw.write("Todos os Alunos:");
            bw.newLine();
            bw.newLine();
            
            List<String> sortedNameList = new ArrayList<String>(this.listaDeAlunos.keySet()) ;    
            Collections.sort(sortedNameList);

            for(String nome : sortedNameList){
                bw.write(nome);
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){
            System.out.println("Erro de IO");
        }
            

    }

    public ListagemDeAlunos(){
    }
}