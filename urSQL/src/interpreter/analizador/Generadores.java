package interpreter.analizador;

import java.io.File;

/**
 * Compila los archivos Escaner.flex y Parser.cup para generar las clases de 
 * AnalizadorSintactico.java y AnalizadorLexico.java
 * @author maikol_beto
 */
public class Generadores {

    public static void main(String[] args) {
        String opciones[] = new String[5];
        opciones[0]="-destdir";
        opciones[1]="src"
                +File.separator+
                "interpreter"
                +File.separator+
                "analizador";
        opciones[2]="-parser";
        opciones[3]="AnalizadorSintactico";
        opciones[4]="src"
                +File.separator+
                "interpreter"
                +File.separator+
                "analizador"
                +File.separator+
                "Parser.cup";
        try {
            java_cup.Main.main(opciones);
        }
        catch (Exception e) {
            //System.out.print(e);
        }
        
        JFlex.Main.generate(new File(
            "src" + File.separator + "interpreter" +File.separator+
                "analizador" + File.separator + "Escaner.flex"));
    }
    
}
