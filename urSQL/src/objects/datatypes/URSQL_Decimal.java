package objects.datatypes;

/**
 * @author maikol_beto
 */
public class URSQL_Decimal extends DataType implements utils.Constants {
    
    public int digits;
    public int decimals;

    public URSQL_Decimal(int digits, int decimals) {
        this.digits = digits;
        this.decimals = decimals;
        type = DECIMAL;
        size = DECIMAL_SIZE;
    }
       
    @Override
    public String toString ()
    {
        return "DECIMAL (" + digits + ", " + decimals + ")";
    }
    
}
