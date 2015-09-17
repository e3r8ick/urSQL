package exceptions;

/**
 * @author maikol_beto
 */
public class SchemaDoesntExistsException extends Exception {
    
    public SchemaDoesntExistsException ()
    {
        super("Error: El Schema no existe, por lo que no se puede eliminar");
    }
    
}
