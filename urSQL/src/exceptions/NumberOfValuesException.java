
package exceptions;

/**
 * @author maikol_beto
 */
public class NumberOfValuesException extends Exception {

    public NumberOfValuesException() {
    
        super("Error: El numero de valores es diferente al numero de columnas");
    
    }
    
}
