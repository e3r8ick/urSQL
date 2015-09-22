package exceptions;

/**
 * @author maikol_beto
 */
public class ReferencedColumnDoesntExistsException extends Exception {

    public ReferencedColumnDoesntExistsException() {
        super("Error: La columna a la que le hace referencia el constraint no existe");
    }
    
    
}
