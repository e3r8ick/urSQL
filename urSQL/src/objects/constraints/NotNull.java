package objects.constraints;

/**
 * @author maikol_beto
 */
public class NotNull extends Constraint implements utils.Constants {
    
    public String column;
    
    public NotNull (String column)
    {
        this.column = column;
        this.type = NOT_NULL;
    }
    
    @Override
    public String toString ()
    {
        return "Column " + column + " Can't be Null: ";
    }
    
}
