package exceptions;

/**
 * @author maikol_beto
 */
public class TableAlreadyExistsException extends Exception {

    public TableAlreadyExistsException() {
        super("Error: el nombre de la tabla ya existe, pruebe utilizando otro");
    }
}
