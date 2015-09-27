package exceptions;

/**
 * @author maikol_beto
 */
public class NotNullColumnException extends Exception {

    public NotNullColumnException(String column) {
        super("Error: La columna " + column + " no puede contener un valor nulo");
    }
}
