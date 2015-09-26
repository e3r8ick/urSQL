package exceptions;

/**
 * @author maikol_beto
 */
public class ForeignKeyExistsException extends Exception {

    public ForeignKeyExistsException() {
        super ("Error: La tabla que quiere borrar esta siendo referenciada por otra tabla existente");
    }
    
    public ForeignKeyExistsException(String table)
    {
        super ("Error: La tabla que quiere borrar esta siendo referenciada por la tabla " + table);
    }
    
    
    
}
