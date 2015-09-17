package interpreter.objects;

/**
 * @author maikol_beto
 */
public class ColumnDefinition {
    
    public String name;
    public String type;
    public Boolean nullability; //true if NULL, false if NOT NULL 
    
    public ColumnDefinition(String name, String type, Boolean nullability)
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
