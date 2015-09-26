package exceptions;

/**
 * @author maikol_beto
 */
public class DiferentTypesComparationException extends Exception  {

    public DiferentTypesComparationException() {
        super("Error: Los tipos de datos que desea comparar en la operacion"
                + " WHERE son incompatibles");
    }
    
    
    
}
