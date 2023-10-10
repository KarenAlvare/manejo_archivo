package manipulacionarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ManipulacionArchivos {
    
    public static int countFileLines(String name){
        File archivo; //apunta a un archivo fisico del dd
        FileReader reader; //llave con permiso de solo lectura
        BufferedReader bufer; //recuperar info. del archivo
        int numLineas = 0;
        
        try{
            //crear un apuntador al archivo fisico
            archivo = new File("C:\\archivos\\" + name + ".txt");          
            reader = new FileReader(archivo);            
            bufer = new BufferedReader(reader);
            //contar las lineas que tiene el archivo
            while((bufer.readLine())!= null ){
                numLineas++;
            }
            reader.close();
        } catch( Exception e ){
            System.out.println("Error al leer el archivo: "+ e.toString());
        }
        
        return numLineas;
    }
    
    public static String[] fileToStringArray(String name) throws IOException{
        File archivo; //apunta a un archivo fisico del dd
        FileReader reader; //llave con permiso de solo lectura
        BufferedReader bufer; //recuperar info. del archivo
        String linea;
        String[] array = null;
        int t;
        int i = 0;
        
        try{
            //obtener tamaño archivo
            t = countFileLines(name);
            //con el tamaño del archivo, contruimos arreglos
            array = new String[t];
            //crear un apuntador al archivo fisico
            archivo = new File("C:\\archivos\\" + name + ".txt");
            //abrir el archivo para lectura
            reader = new FileReader(archivo);
            //configurar el bufer para leer datos del archivo
            bufer = new BufferedReader(reader);
            //lectura de contenido del archivo
            while((linea = bufer.readLine())!= null ){
                //System.out.println("Linea leida: "+ linea);
                array[i] = linea;
                i++;
        }
            reader.close();
        } catch( Exception e ){
            System.out.println("Error al leer el archivo: "+ e.toString());
        }
        return array;
    }
    
    public static int[] fileToInArray(String name) throws IOException{
        File archivo; //apunta a un archivo fisico del dd
        FileReader reader; //llave con permiso de solo lectura
        BufferedReader bufer; //recuperar info. del archivo
        String linea;
        int[] array = null;
        int t;
        int i = 0;
        
        try{
            
            t = countFileLines(name);
            array = new int[t];
            archivo = new File("C:\\Archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            //configurar el  para leer datos del archivo
            bufer = new BufferedReader(reader);
            while((linea = bufer.readLine())!= null ){
                array[i] = Integer.parseInt(linea);
                i++;
        }
            reader.close();
        } catch( Exception e ){
            System.out.println("Error al leer el archivo: "+ e.toString());
        }
        return array;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        
        String fileName;
        String[] mascotass;
        int[] numeros;
        
        System.out.println("Lectura de un archivo de texto");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        mascotass = fileToStringArray(fileName);   
        System.out.println("Contenido del arreglo de mascotas: ");
        for (String unaMascota : mascotass ){
            System.out.println(unaMascota);
        }
        
        System.out.println("");
        System.out.println("Lectura de datos numericos");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        numeros = fileToInArray(fileName);
        System.out.println("Contenido del arreglo de numeros");
        for ( int unNumber : numeros ){
            System.out.println(unNumber);
        }
}}