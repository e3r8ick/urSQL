package ursql;

import exceptions.ResultSetTypeException;
import java.util.ArrayList;
import java.util.List;

/**
 * Contiene el resultado del comando SELECT
 * @author maikol_beto
 */
public class ResultSet {
    
    public List<String> columns;
    public List<ResultSetNode> values;
    
    private int index;

    public ResultSet(List<String> columns) 
    {
        this.columns = columns;
        values = new ArrayList<>();
        index = 0;
    }
    
    /* importante sustituir por otro constructor */
    public void addValue (ResultSetNode newValue)
    {
        values.add(newValue);
    }
    
    public boolean next()
    {
        index = index + 1;
        if (index<values.size())
            return true;
        else
            return false;
    }
    
    public boolean previous()
    {
        if (index == 0)
        {
            return false;
        }
        else
        {
            index = index - 1;
            return true;
        }
    }
    
    public boolean first()
    {
        index = 0;
        return true;
    }
    
    public boolean last()
    {
        index = columns.size()-1;
        return true;
    }
    
    public boolean absolute(int row)
    {
        if (row >= 0 && row <= columns.size()-1)
        {
            index = columns.size()-1;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int getInteger(String column) throws Exception
    {
        ResultSetNode node = values.get(index);
        int i = 0;
        for (String columna : columns)
        {
            if (columna.equals(column))
                break;
            else
                i++;
        }
        try
        {
            return Integer.parseInt(node.values.get(i));
        }
        catch (Exception e)
        {
            throw new exceptions.ResultSetTypeException(column, "integer");
        } 
    }
    
    public java.math.BigDecimal getDecimal(String column) throws Exception
    {
        ResultSetNode node = values.get(index);
        int i = 0;
        for (String columna : columns)
        {
            if (columna.equals(column))
                break;
            else
                i++;
        }
        try
        {
            return new java.math.BigDecimal(node.values.get(i));
        }
        catch (Exception e)
        {
            throw new exceptions.ResultSetTypeException(column, "decimal");
        } 
    }
    
    public String getChar (String column)
    {
        ResultSetNode node = values.get(index);
        int i = 0;
        for (String columna : columns)
        {
            if (columna.equals(column))
                break;
            else
                i++;
        }
        return node.values.get(i);
    }
    
    public String getVarchar (String column)
    {
        ResultSetNode node = values.get(index);
        int i = 0;
        for (String columna : columns)
        {
            if (columna.equals(column))
                break;
            else
                i++;
        }
        return node.values.get(i);
    }
    
    public java.util.Date getDateTime (String column)
    {
        ResultSetNode node = values.get(index);
        int i = 0;
        for (String columna : columns)
        {
            if (columna.equals(column))
                break;
            else
                i++;
        }
        return utils.Convert.stringToDate(node.values.get(i));
    }
    
    public void printResult ()
    {
        ResultSetDisplay rsd = new ResultSetDisplay(columns);
        for (ResultSetNode node : values)
        {
            rsd.addRow(node);
        }
        rsd.print();
    }
    
    @Override
    public String toString()
    {
        ResultSetDisplay rsd = new ResultSetDisplay(columns);
        for (ResultSetNode node : values)
        {
            rsd.addRow(node);
        }
        return rsd.toString();
    }
    
}
