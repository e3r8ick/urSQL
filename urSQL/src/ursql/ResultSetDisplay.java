package ursql;

import java.util.ArrayList;
import java.util.List;

/**
 * Muestra el ResultSet ordenado en una tabla para la terminal
 * @author maikol_beto
 */
public class ResultSetDisplay {
    
    public List<String> columnNames;
    public List<Integer> columnSizes;
    public List<ResultSetNode> values;

    public ResultSetDisplay(List<String> columnNames) {
        this.columnNames = new ArrayList<>();
        columnSizes = new ArrayList<>();
        values = new ArrayList<>();
        
        for (String col : columnNames)
        {
            this.columnNames.add(col);
            this.columnSizes.add(col.length());
        }
    }
    
    public void addRow (ResultSetNode newValue)
    {
        for (int index=0; index<newValue.values.size();index++)
        {
            if (columnSizes.get(index)<newValue.values.get(index).length())
            {
                columnSizes.remove(index);
                columnSizes.add(index, newValue.values.get(index).length());
            }
        }
        values.add(newValue);
    }
    
    public void print ()
    {
        printLine();
        printRow(columnNames);
        printLine();
        for (ResultSetNode obj : values)
        {
            printRow(obj.values);
        }
        printLine();
    }
    
    private void printRow (List<String> rowValues)
    {
        for (int column=0; column<columnSizes.size(); column++)
        {
            if (column == 0)
            {
                System.out.print("| ");
                System.out.print(completeString(rowValues.get(column), columnSizes.get(column)-1));
                if (columnSizes.size() == 1)
                {
                    System.out.print(" |");
                }
            }
            else if (column == columnSizes.size()-1)
            {
                System.out.print(" | ");
                System.out.print(completeString(rowValues.get(column), columnSizes.get(column)-1));
                System.out.print(" |");
            }
            else
            {
                System.out.print(" | ");
                System.out.print(completeString(rowValues.get(column), columnSizes.get(column)-1));
            }
        }
        System.out.println("");
    }
    
    private void printLine ()
    {
        for (int column=0;column<columnSizes.size();column++)
        {
            System.out.print("+");
            for (int i=0;i<columnSizes.get(column)+2;i++)
                System.out.print("-");
            if (column == columnSizes.size()-1)
            {
                System.out.print("+");
            }
        }
        System.out.println("");
    }
    
    private String completeString (String incomplete, int size)
    {
        
        String answer = incomplete;
        for (int len=incomplete.length();len<size+1;len++)
            answer = answer.concat(" ");
        return answer;
        
    }
    
    @Override
    public String toString()
    {
        String result = "";
        result += getLine();
        result += getRow(columnNames);
        result += getLine();
        for (ResultSetNode obj : values)
        {
            result += getRow(obj.values);
        }
        result += getLine();
        return result;
    }
    
    private String getLine ()
    {
        String result = "";
        for (int column=0;column<columnSizes.size();column++)
        {
            result += ("+");
            for (int i=0;i<columnSizes.get(column)+2;i++)
                result += ("-");
            if (column == columnSizes.size()-1)
            {
                result += ("+");
            }
        }
        return result + "\n";
    }
    
    private String getRow (List<String> rowValues)
    {
        String result = "";
        for (int column=0; column<columnSizes.size(); column++)
        {
            if (column == 0)
            {
                result += ("| ");
                result += (completeString(rowValues.get(column), columnSizes.get(column)-1));
                if (columnSizes.size() == 1)
                {
                    result += (" |");
                }
            }
            else if (column == columnSizes.size()-1)
            {
                result += (" | ");
                result += (completeString(rowValues.get(column), columnSizes.get(column)-1));
                result += (" |");
            }
            else
            {
                result += (" | ");
                result += (completeString(rowValues.get(column), columnSizes.get(column)-1));
            }
        }
        return result + "\n";
    }
}
