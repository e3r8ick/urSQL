package objects.datatypes;

/**
 * @author maikol_beto
 */
public class URSQL_Datetime extends DataType implements utils.Constants {

    public URSQL_Datetime() {
        type = DATETIME;
        size = DATETIME_SIZE;
    }
    
    @Override
    public String toString ()
    {
        return "DATETIME";
    }
    
}
