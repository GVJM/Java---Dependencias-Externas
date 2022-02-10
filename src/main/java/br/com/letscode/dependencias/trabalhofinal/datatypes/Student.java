package br.com.letscode.dependencias.trabalhofinal.datatypes;

import java.util.ArrayList;

import lombok.NonNull;
import lombok.Data;


//Classe Student que tem attributos name, que guarda a string do nome do aluno, e classes, ArrayList que guarda as turmas(Strings) deste aluno.
@Data public class Student {
    private final String name;
    private ArrayList<String> classes = new ArrayList<String>();
    
    public Student(@NonNull String name){
        this.name = name;
    }

    //Método que adiciona nova turma ao aluno, com checagem de pré existência e de escrita correta.
    public void addClass(@NonNull String className){
        if ( (className.equals("Java") && !this.hasClass("Java")) || className.equals("Banco de dados") && !this.hasClass("Banco de dados")){
            this.classes.add(className);
        }
    }

    //Método que checa se está em determinada turma
    public boolean hasClass(@NonNull String className){
        if( this.classes.contains(className) ){
            return true;
        }
        else{
            return false;
        }
    }

}
