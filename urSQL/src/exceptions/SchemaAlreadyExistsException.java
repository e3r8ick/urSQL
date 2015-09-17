package exceptions;

/**
 * @author maikol_beto
 */
public class SchemaAlreadyExistsException extends Exception {
    
    public SchemaAlreadyExistsException() {
        super("Error, el nombre del esquema ya está siendo utilizado, utilice otro");
    }
}
