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

@Data public class StudentsList {
    private HashMap<String,Student> studentList = new HashMap<String,Student>();

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

    public void printLista(){
        List<String> sortedNameList = new ArrayList<String>(this.studentList.keySet()) ;    
        Collections.sort(sortedNameList);
        for(String nome : sortedNameList){
            System.out.println(nome);
        }
    }

    public void allStudentsToTxt(@NonNull String fileName){
        
        try{
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Todos os estudantes:");
            bw.newLine();
            bw.newLine();
            
            List<String> sortedNameList = new ArrayList<String>(this.studentList.keySet()) ;    
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