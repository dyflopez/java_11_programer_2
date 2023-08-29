package utils;

import dtos.ProductDTO;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Commons {
    public static  void writeFile (String nombre , String contenido){
        try {
            // Crear un FileWriter para escribir en el archivo
            //instanciar de FileWriter
            //por prametro se pasa el nombre del archivo en el cual vamos a escribir
            FileWriter fileWriter = new FileWriter(nombre,true);

            //Crea un BufferedWriter para escribir en el archivo de manera eficiente
            //se le pasa un fileWriter y se se escribe
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //escribir en el archivo
            //bufferedWriter.write("hola soy docente o instructor de aula matriz");
            bufferedWriter.append(contenido);
            bufferedWriter.newLine();
            bufferedWriter.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static  List<String>  fileReadBackup(String nombre){
        List<String> stringList = new ArrayList<>();
        try {
            ProductDTO productDTO = new ProductDTO();
            //Crear un FileReader para leer desde el archivo
            //objeto que busca el archivo
            FileReader fileReader = new FileReader(nombre);

            //crea el buffer para leer el archivo linea a linea
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //bufferedReader.lines().forEach(System.out::println);
            String line ="";
            while ((line= bufferedReader.readLine())!=null){
               // System.out.println(line);
                stringList.add(line);
            }
            bufferedReader.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return stringList;
    }

    public static  void leerEnRutaEspesifica(){
        JOptionPane.showMessageDialog(null,"Leer archivo");


        System.out.println("***************************************");
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filtro  = new FileNameExtensionFilter("Archivos de texto","txt");
        fileChooser.setFileFilter(filtro);
        int seleleccon = fileChooser.showOpenDialog(null);

        System.out.println(seleleccon);

        if(seleleccon == JFileChooser.APPROVE_OPTION){
            try {
                File archivo = fileChooser.getSelectedFile();
                BufferedReader  bufferedReader = new BufferedReader(new FileReader(archivo));
                bufferedReader.lines().forEach(System.out::println);
            }catch (Exception e){

            }
        }
    }
}
