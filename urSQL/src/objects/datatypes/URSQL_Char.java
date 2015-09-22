package objects.datatypes;

/**
 * @author maikol_beto
 */
public class URSQL_Char extends DataType implements utils.Constants {
    
    public int variableSize;

    public URSQL_Char(int variableSize) {
        this.variableSize = variableSize;
        type = CHAR;
        size = CHAR_SIZE;
    }
    
    @Override
    public String toString ()
    {
        return "CHAR (" + variableSize + ")";
    }
    
}
