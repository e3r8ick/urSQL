package objects.datatypes;

/**
 * @author maikol_beto
 */
public class URSQL_Varchar extends DataType implements utils.Constants {

    public URSQL_Varchar() {
        type = VARCHAR;
        size = VARCHAR_SIZE;
    }
    
    @Override
    public String toString ()
    {
        return "VARCHAR (25)";
    }
    
}
