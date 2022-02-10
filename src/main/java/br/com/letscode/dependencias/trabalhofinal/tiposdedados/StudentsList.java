package br.com.letscode.dependencias.trabalhofinal.tiposdedados;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import lombok.Data;
import lombok.NonNull;



// Classe que guarda instâncias da classe Student em um HashMap com chaves String que serâo o nome de cada aluno.
// Além disso reune métodos para adição, filtragem e escrita de dados.
@Data public class StudentsList {
    private HashMap<String,Student> studentList = new HashMap<String,Student>();

    //Função que adiciona novos alunos ao HashMap, com checagem de existência prévia.
    //Caso haja um estudante no banco com mesmo nome, ela adiciona a turma do novo registro ao já registrado.
    public void addstudent(@NonNull Student student){
        if(this.studentList.containsKey(student.getName())){
            
            for (String className : this.studentList.get(student.getName()).getClasses()) {
                student.addClass(className);    
            }
            
            this.studentList.put(student.getName(), student);
        } 
        else{
            this.studentList.put(student.getName(), student);
        }       
    }

    //Método escreve no txt os nomes de todos os alunos
    public void allStudentsToTxt(@NonNull String fileName){
        
        try{
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Todos os estudantes:");
            bw.newLine();
            bw.newLine();
            
            List<String> sortedNameList = new ArrayList<String>( this.studentList.keySet()) ;    
            Collections.sort(sortedNameList);

            for(String nome : sortedNameList){
                bw.write(nome);
                bw.newLine();
            }
            bw.newLine();
            bw.newLine();
            bw.close();
        }
        catch(IOException e){
            System.out.println("Erro de IO");
        }
    }

    //Método que escreve no txt o nome dos alunos da turma selecionada
    public void classStudentsToTxt(@NonNull String className, @NonNull String fileName){
        if(className.equals("Java")||className.equals("Banco de dados")){

            try{
                FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter bw = new BufferedWriter(fw);
                
                bw.write("Turma "+className+":");
                bw.newLine();
                bw.write("Nº de Alunos: " + this.getClassStudents(className).size());
                bw.newLine();
                bw.newLine();
                    
                for(Student student : this.getClassStudents(className)){
                    bw.write(student.getName());
                    bw.newLine();
                }
                bw.newLine();
                bw.newLine();
                bw.close();
            }
            catch(IOException e){
                System.out.println("Erro de IO");
            }
        }
    }

    //Método que retorna uma lista com todos os Alunos de determinada turma
    public List<Student> getClassStudents(@NonNull String className){

        List<Student> classStudents = new ArrayList<Student>() ;    

        for(Student student : this.studentList.values()){
            if(student.hasClass(className)){
                classStudents.add(student);
            }
        }

        return classStudents;

    }

    public StudentsList(){
    }
}