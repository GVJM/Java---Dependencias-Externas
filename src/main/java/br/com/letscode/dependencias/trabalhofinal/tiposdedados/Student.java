package br.com.letscode.dependencias.trabalhofinal.tiposdedados;

import java.util.ArrayList;

import lombok.NonNull;
import lombok.Data;

@Data public class Student {
    private final String name;
    private ArrayList<String> classes = new ArrayList<String>();
    
    public Student(@NonNull String name){
        this.name = name;
    }

    public void addClass(@NonNull String className){
        if ( (className.equals("Java") && !this.hasClass("Java")) || className.equals("Banco de dados") && !this.hasClass("Banco de dados")){
            this.classes.add(className);
        }
    }

    public boolean hasClass(@NonNull String className){
        if( this.classes.contains(className) ){
            return true;
        }
        else{
            return false;
        }
    }

}
