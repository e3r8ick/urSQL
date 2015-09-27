
package exceptions;

/**
 * @author maikol_beto
 */
public class AggregateFunctionTypeException extends Exception {

    public AggregateFunctionTypeException() {
        super ("Error: El tipo al cual se le desea aplicar la función de agregación es incompatible con ésta función");
    }
    
}
