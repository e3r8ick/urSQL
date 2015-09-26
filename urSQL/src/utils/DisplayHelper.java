package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Ayuda a mostrar los datos de una tabla identados y de manera correcta
 * @author maikol_beto
 */
public class DisplayHelper {
    
    private int maxFieldSize = 0;
    private int maxTypeSize = 0;
    private final int NullSize = 6;
    private final int KeySize = 6;
    
    List<DisplayObject> objects = new ArrayList<>();
    
    public void addRow (String field, String type, String nule, String key)
    {
        if (maxFieldSize < field.length())
            maxFieldSize = field.length();
        if (maxTypeSize < type.length())
            maxTypeSize = type.length();
        
        objects.add(new DisplayObject(field, type, nule, key));
    }
    
    public void print ()
    {
        printLine();
        System.out.print("| ");
        System.out.print(completeString("Field", maxFieldSize-1));
        System.out.print(" | ");
        System.out.print(completeString("Type", maxFieldSize));
        System.out.print(" | ");
        System.out.print(completeString("Null", NullSize-3));
        System.out.print(" | ");
        System.out.print(completeString("Key", KeySize-3));
        System.out.println(" |");
        printLine();
        for (DisplayObject obj : objects)
        {
            System.out.print("| ");
            System.out.print(completeString(obj.field, maxFieldSize-1));
            System.out.print(" | ");
            System.out.print(completeString(obj.type, maxFieldSize));
            System.out.print(" | ");
            System.out.print(completeString(obj.nule, NullSize-3));
            System.out.print(" | ");
            System.out.print(completeString(obj.key, KeySize-3));
            System.out.println(" |");
        }
        printLine();
    }
    
    private void printLine ()
    {
        System.out.print("+");
        for (int i=0;i<maxFieldSize+2;i++)
            System.out.print("-");
        System.out.print("+");
        for (int i=0;i<maxTypeSize+2;i++)
            System.out.print("-");
        System.out.print("+");
        for (int i=0;i<NullSize;i++)
            System.out.print("-");
        System.out.print("+");
        for (int i=0;i<KeySize;i++)
            System.out.print("-");
        System.out.println("+");
    }
    
    private String completeString (String incomplete, int size)
    {
        
        String answer = incomplete;
        for (int len=incomplete.length();len<size+1;len++)
            answer = answer.concat(" ");
        return answer;
        
    }
    
}
