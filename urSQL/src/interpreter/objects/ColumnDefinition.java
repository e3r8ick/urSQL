package interpreter.objects;

import objects.datatypes.DataType;

/**
 * @author maikol_beto
 */
public class ColumnDefinition {
    
    public String name;
    public DataType type;
    public Boolean nullability; //true if NULL, false if NOT NULL 
    
    public ColumnDefinition(String name, DataType type, Boolean nullability)
    {
        this.name = name;
        this.type = type;
        this.nullability = nullability;
    }
    
    @Override
    public String toString ()
    {
        return "nombre: " + name + " tipo: " + type + " nulo? " + nullability.toString();
    }
}
