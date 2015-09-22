package ursql;

import static interpreter.objects.interpreterTester.escribir;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Facade que conecta las aplicaciones con la API de urSQL
 * @version 1.0
 * @author maikol_beto
 */
public class Connection {
    
    private objects.RuntimeDatabaseProcessor linkToWorld;
        
    public void startConnection ()
    {
        linkToWorld = new objects.RuntimeDatabaseProcessor();
        System.out.println("Conección establecida");
        /* cargar todos los componentes */
    }
    
    public void startConnection (String database)
    {
        linkToWorld = new objects.RuntimeDatabaseProcessor();
        System.out.println("Conección establecida");
        executeCommand("SET DATABASE " + database);
    }
    
    public void executeCommand(String sql)
    {
        escribir ("query.txt",sql);
            
        try
        {
            interpreter.analizador.AnalizadorLexico lexico = 
                new interpreter.analizador.AnalizadorLexico(new FileReader("query.txt"));

            interpreter.analizador.AnalizadorSintactico parser = 
                new interpreter.analizador.AnalizadorSintactico(lexico, linkToWorld);

            parser.parse();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public static void escribir(String direccion, String text){
        //metodo que guarda lo que esta escrito en un archivo de texto
	try{	
            FileWriter writer = new FileWriter(direccion);
            PrintWriter print = new PrintWriter(writer);
            print.print(text);
            writer.close();
	}
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    
}
