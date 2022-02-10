package br.com.letscode.dependencias.trabalhofinal;

import br.com.letscode.dependencias.trabalhofinal.datatypes.*;

public class App 
{
    public static void main( String[] args ){
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

        StudentsDB lista = new StudentsDB();

        for( String name : turmaJava){
            Student student = new Student(name);
            student.addClass("Java");
            lista.addstudent(student);
        }

        for( String name : turmaBD){
            Student student = new Student(name);
            student.addClass("Banco de dados");
            lista.addstudent(student);
        }

        lista.classStudentsToTxt("Java", "output.txt");

        lista.classStudentsToTxt("Banco de dados", "output.txt");

        lista.allStudentsToTxt("output.txt");


    }

}