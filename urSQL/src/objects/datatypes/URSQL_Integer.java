package objects.datatypes;


/**
 * @author maikol_beto
 */
public class URSQL_Integer extends DataType implements utils.Constants {

    public URSQL_Integer() 
    {
        type = INTEGER;
        size = INTEGER_SIZE;
    }
    
    @Override
    public String toString ()
    {
        return "INTEGER";
    }
    
}
