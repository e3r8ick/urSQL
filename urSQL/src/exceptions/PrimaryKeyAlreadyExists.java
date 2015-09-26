
package exceptions;

/**
 * @author maikol_beto
 */
public class PrimaryKeyAlreadyExists extends Exception{

    public PrimaryKeyAlreadyExists() {
    
        super("Error: El primary Key que se desea insertar ya existe");
    
    }
    
}
