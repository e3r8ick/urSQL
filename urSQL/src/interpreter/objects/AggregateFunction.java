package interpreter.objects;

/**
 * @author maikol_beto
 */
public class AggregateFunction {
    
    public String name;
    public String column;
    
    public AggregateFunction (String name, String column)
    {
        this.name = name;
        this.column = column;
    }
    
    @Override
    public String toString()
    {
        return name + "(" + column + ")";
    }
    
}
