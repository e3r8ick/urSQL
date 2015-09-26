package exceptions;

/**
 * @author maikol_beto
 */
public class DecimalTooBigException extends Exception {

    public DecimalTooBigException() {
    
        super ("Error: El valor decimal que se desea utilizar es demasiado grande");
    
    }
    
}
