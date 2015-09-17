package interpreter.objects;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author maikol_beto
 */
public class interpreterTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        objects.RuntimeDatabaseProcessor linkToWorld = 
                new objects.RuntimeDatabaseProcessor();
        
        while (true)
        {
            String input = in.nextLine();
            
            if (input.equals("quit()"))
                break;
            
            escribir ("query.txt",input);
            
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
