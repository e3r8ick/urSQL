
package exceptions;

/**
 * @author maikol_beto
 */
public class ConstraintColumnDoesntExistsException  extends Exception {

    public ConstraintColumnDoesntExistsException() {
        super("Error: La columna a la cual sle desea aplicar el constraint no existe");
    }
    
    
    
}
