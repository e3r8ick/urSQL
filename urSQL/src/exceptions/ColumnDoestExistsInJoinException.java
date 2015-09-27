
package exceptions;

/**
 * @author maikol_beto
 */
public class ColumnDoestExistsInJoinException extends Exception {

    public ColumnDoestExistsInJoinException() {
        super("Error: La columna que está referenciando en el JOIN no existe en la tabla");
    }
    
}
